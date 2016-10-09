package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;

@Entity
@Table(name = "shipping_profiles")
public class ShippingProfile implements BaseEntity {

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

    @Column(name = "person")
    @Getter
    @Setter
    private String person;

    @Column(name = "document")
    @Getter
    @Setter
    private String document;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;

    @Column(name = "phone")
    @Getter
    @Setter
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
