package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "users_counter")
@Getter
@Setter
@ToString
public class CountUser implements BaseEntity, CountEntity {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name="product_id")
    private long productId;

    @Column(name="counter")
    private int counter;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountUser countUser = (CountUser) o;
        return new EqualsBuilder()
                .append(id, countUser.id)
                .append(userId, countUser.userId)
                .append(productId, countUser.productId)
                .append(counter, countUser.counter)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(userId)
                .append(productId)
                .append(counter)
                .toHashCode();
    }
}
