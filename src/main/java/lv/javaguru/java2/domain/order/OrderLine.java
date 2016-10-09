package lv.javaguru.java2.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lv.javaguru.java2.domain.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = "order")
@Entity
@Table(name = "order_lines")
public class OrderLine implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        OrderLine other = (OrderLine) object;
        return new EqualsBuilder()
                .append(this.getId(), other.getId())
                .append(this.getProductId(), other.getProductId())
                //.append(this.getOrderId(), other.getOrderId())
                .append(this.getName(), other.getName())
                .append(this.getDescription(), other.getDescription())
                .append(this.getPrice(), other.getPrice())
                .append(this.getQuantity(), other.getQuantity())
                //.append(this.getExpireDate(), other.getExpireDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + (int) (quantity ^ (quantity >>> 32));
        return result;
    }
}
