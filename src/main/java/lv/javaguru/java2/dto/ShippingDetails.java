package lv.javaguru.java2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShippingDetails {
    private long id;
    private String person;
    private String document;
    private String address;
    private String phone;

}
