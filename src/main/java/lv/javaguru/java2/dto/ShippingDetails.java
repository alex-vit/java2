package lv.javaguru.java2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingDetails {
    private long id;
    private String person;
    private String document;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return "ShippingDetails{" +
                "id=" + id +
                ", person='" + person + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
