package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "reviews")
public class Review implements BaseEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "review")
    private String review;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Review review = (Review) o;
        return new EqualsBuilder()
                .append(id, review.getId())
                .append(userId, review.getUserId())
                .append(productId, review.getProductId())
                .append(this.review, review.getReview())
                .append(userName, review.getUserName())
                .append(date, review.getDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(userId)
                .append(productId)
                .append(review)
                .append(userName)
                .append(date)
                .toHashCode();
    }
}
