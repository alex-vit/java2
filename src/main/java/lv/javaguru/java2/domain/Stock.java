package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock implements BaseEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "product_id")
    private long productId;

    @Getter
    @Setter
    @Column(name = "quantity")
    private int quantity;

    @Getter
    @Setter
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

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", expireDate=" + expireDate +
                '}';
    }
}
