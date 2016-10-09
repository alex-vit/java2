package lv.javaguru.java2.businesslogic.user;

import lombok.Getter;
import lombok.Setter;
import lv.javaguru.java2.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionUserProvider implements UserProvider {

    @Getter
    @Setter
    private User user;

    public boolean authorized() {
        return user != null;
    }
    public boolean isCurrent(long userId) {
        return authorized() && this.user.getId() == userId;
    }
}
