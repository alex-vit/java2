package lv.javaguru.java2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserProfile {

    private String fullName;
    private String email;
    private String password;
    private String repeatPassword;

}
