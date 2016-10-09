package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "rate")
public class Rate implements BaseEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Column(name = "user_id")
    @Getter
    @Setter
    private long userId;

    @Column(name = "product_id")
    @Getter
    @Setter
    private long productId;

    @Column(name = "rate")
    @Getter
    @Setter
    private int rate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rate rate1 = (Rate) o;

        return new EqualsBuilder()
                .append(id, rate1.getId())
                .append(userId, rate1.getUserId())
                .append(productId, rate1.getProductId())
                .append(rate, rate1.getRate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(userId)
                .append(productId)
                .append(rate)
                .toHashCode();
    }
}
