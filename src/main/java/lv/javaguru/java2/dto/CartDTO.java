package lv.javaguru.java2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CartDTO {

    private List<ProductCard> productCards;
    private long totalPrice;
    private long cartCheckSum;
}
