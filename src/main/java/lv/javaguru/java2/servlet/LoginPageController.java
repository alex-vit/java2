package lv.javaguru.java2.servlet;

import javax.servlet.http.HttpServletRequest;

public class LoginPageController implements MVCController{

    @Override
    public MVCModel execute(HttpServletRequest request) {
        System.out.println("in LoginPageController");
        return new MVCModel("","/login.jsp");
    }
}
