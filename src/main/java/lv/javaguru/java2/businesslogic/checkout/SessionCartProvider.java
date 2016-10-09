package lv.javaguru.java2.businesslogic.checkout;

import lombok.Getter;
import lombok.Setter;
import lv.javaguru.java2.domain.Cart;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionCartProvider implements CartProvider {

    @Getter
    @Setter
    private Cart cart;

    public SessionCartProvider(){
        this.cart = new Cart();
    }

    @Override
    public boolean isEmpty(){
        return cart.getAll().isEmpty();
    }

    @Override
    public void empty() {
        this.cart = new Cart();
    }

}
