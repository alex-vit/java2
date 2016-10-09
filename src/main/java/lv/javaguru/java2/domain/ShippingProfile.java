package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "shipping_profiles")
public class ShippingProfile implements BaseEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "person")
    private String person;

    @Column(name = "document")
    private String document;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Override
    public String toString() {
        return "ShippingProfile{" +
                "id=" + id + '\'' +
                ",person='" + person + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        ShippingProfile other = (ShippingProfile) object;

        return new EqualsBuilder()
                .append(this.getAddress(), other.getAddress())
                .append(this.getPerson(), other.getPerson())
                .append(this.getDocument(), other.getDocument())
                .append(this.getPhone(), other.getPhone())
                .append(this.getUserId(), other.getUserId())
                .isEquals();
    }


}
