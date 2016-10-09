package lv.javaguru.java2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {

    private String fullName;
    private String email;
    private String password;
    private String repeatPassword;

    @Override
    public String toString() {
        return "UserProfile{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                '}';
    }
}
