package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
@Getter
@Setter
@ToString
public class Stock implements BaseEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date expireDate;


    public void substractQuantity(int quantity) {
        this.quantity -= quantity;
    }


    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if ((object == null) || !(object instanceof Stock)) {
            return false;
        }
        Stock that = (Stock) object;
        return new EqualsBuilder()
                .append(id, that.getId())
                .append(productId, that.getProductId())
                .append(quantity, that.getQuantity())
                .append(expireDate, that.getExpireDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(productId)
                .append(quantity)
                .append(expireDate)
                .toHashCode();
    }
}
