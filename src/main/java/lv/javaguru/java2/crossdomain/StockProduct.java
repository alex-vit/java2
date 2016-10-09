package lv.javaguru.java2.crossdomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Immutable
@Entity
@Table(name = "stock_product")
public class StockProduct {

    @Id
    @Column(name = "stock_id", updatable = false, nullable = false)
    private long id;
    @Column(name = "product_id")
    private long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "quantity")
    private int quantity;
    @Temporal(TemporalType.DATE)
    @Column(name = "expire_date")
    private Date expireDate;
}
