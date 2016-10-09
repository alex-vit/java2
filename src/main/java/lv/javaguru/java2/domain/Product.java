package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import lv.javaguru.java2.crossdomain.StatisticLine;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product implements BaseEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

    @Column(name = "imgurl")
    private String imgUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "product_id")
    private List<Stock> stockList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id")
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.JOIN)
    @PrimaryKeyJoinColumn
    private StatisticLine productStatisticLine;


    public List<Stock> getFresh() {
        Date today = new Date();
        List<Stock> fresh = stockList.stream()
                .filter(stock -> stock.getExpireDate()
                        .compareTo(today) >= 0)
                .sorted((stock1, stock2) -> stock1.getExpireDate().compareTo(stock2.getExpireDate()))
                .collect(Collectors.toList());
        return fresh;
    }
    public int getFreshStockQuantity() {
        int quantity = 0;
        for (Stock stock : getFresh()) {
            quantity += stock.getQuantity();
        }
        return quantity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        Product other = (Product) object;

        return new EqualsBuilder()
                .append(this.getId(), other.getId())
                .append(this.getName(), other.getName())
                .append(this.getDescription(), other.getDescription())
                .append(this.getPrice(), other.getPrice())
                .append(this.getCategoryId(), other.getCategoryId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(11, 37)
                .append(id)
                .append(name)
                .append(description)
                .append(price)
                .append(categoryId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Product {"
                + "id: " + id + ", "
                + "name: " + name + ", "
                + "description: " + description + ", "
                + "price: " + price + ", "
                + "categoryId: " + categoryId
                + "}";
    }

}
