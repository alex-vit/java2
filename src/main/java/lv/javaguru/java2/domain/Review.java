package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@ToString
public class Review implements BaseEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "user_id")
    public long userId;

    @Column(name = "product_id")
    public long productId;

    @Column(name = "review")
    public String review;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    public Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        return new EqualsBuilder()
                .append(id, review.id)
                .append(userId, review.userId)
                .append(productId, review.productId)
                .append(this.review, review.review)
                .append(userName, review.userName)
                .append(date, review.date)
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
