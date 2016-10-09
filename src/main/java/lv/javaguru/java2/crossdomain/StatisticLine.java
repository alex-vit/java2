package lv.javaguru.java2.crossdomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Getter
@Setter
@ToString
@Table(name = "product_statistics")
public class StatisticLine {

    @Id
    @Column(name = "product_id", updatable = false, nullable = false)
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "review_count")
    private long reviewCount;

    @Column(name = "user_visits", columnDefinition = "decimal")
    private long userVisits;

    @Column(name = "visitor_visits", columnDefinition = "decimal")
    private long visitorVisits;

    @Column(name = "avg_rate", columnDefinition = "decimal", precision = 18)
    private double avgRate;

}
