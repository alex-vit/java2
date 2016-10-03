package lv.javaguru.java2.dto.builders;

import lv.javaguru.java2.businesslogic.product.RateService;
import lv.javaguru.java2.businesslogic.product.StatisticCountService;
import lv.javaguru.java2.database.RateDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.Rate;
import lv.javaguru.java2.domain.Stock;
import lv.javaguru.java2.dto.ProductCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCardUtil {

    @Autowired
    private RateService rateService;
    @Autowired
    private RateDAO rateDAO;
    @Autowired
    private StatisticCountService statisticCountService;

    public ProductCard build(Product product, List<Stock> allStock) {
        ProductCard productCard = new ProductCard();

        productCard.setProductId(product.getId());
        productCard.setProductName(product.getName());
        productCard.setProductDescription(product.getDescription());
        productCard.setProductImgUrl(product.getImgUrl());
        productCard.setProductPrice(product.getPrice());

        int quantity = 0;
        Date expireDate = null;
        for (Stock stock : allStock) {
            quantity += stock.getQuantity();
            if (stock.getQuantity() <= 0)
                continue;
            if (expireDate == null) {
                expireDate = stock.getExpireDate();
            } else if (expireDate.compareTo(stock.getExpireDate()) > 0) {
                expireDate = stock.getExpireDate();
            }
        }
        productCard.setStockQuantity(quantity);
        productCard.setStockExpireDate(expireDate);
        productCard.setViewCount(statisticCountService.getProductViews(product.getId()));
        return productCard;
    }

    public ProductCard build(Product product, Integer quantity) {
        ProductCard productCard = build(product);
        productCard.setQuantity(quantity);
        return productCard;
    }

    public void build(ProductCard productCard, List<Rate> rates) {
        double averageRate = rateService.getAverageRate(rates);
        String rateColor = rateService.getRateColor(averageRate);
        productCard.setAverageRate(averageRate);
        productCard.setRateColorCode(rateColor);
    }


    public ProductCard build(Product product) {
        List<Stock> allStock = product.getFresh();
        return build(product, allStock);
    }

    public List<ProductCard> build(List<Product> products) {
        return products.stream()
                .map(product -> build(product))
                .collect(Collectors.toList());
    }

    public void addRate(List<ProductCard> list){
        for(ProductCard productCard : list){
            long productId = productCard.getProductId();
            List<Rate> rates = rateDAO.getByProductId(productId);
            build(productCard, rates);
        }
    }


}
