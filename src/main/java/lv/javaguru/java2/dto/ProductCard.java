package lv.javaguru.java2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductCard {

    private long productId;
    private String productName;
    private String productDescription;
    private long productPrice;
    private String productImgUrl;
    private long quantity;
    private int stockQuantity;
    private Date stockExpireDate;
    private double averageRate;
    private String rateColorCode;
    private long viewCount;

    public long getAvailable() {
        return stockQuantity - quantity;
    }
}
