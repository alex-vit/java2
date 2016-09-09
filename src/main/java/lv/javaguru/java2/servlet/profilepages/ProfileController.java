package lv.javaguru.java2.servlet.profilepages;

import lv.javaguru.java2.businesslogic.SpecialSaleOffer;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.frontpage.FrontPageController;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProfileController extends MVCController {

    private final String EMPTY_FIELDS = "All fields must be filled";
    private final String USER_ALREADY_EXISTS = "User with this email already exists";
    private final String UNEXPECTED_ERROR = "Oops, something went wrong";
    private final String USER_UPDATED = "Information succesfully updated !";

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;
    @Autowired
    private SpecialSaleOffer specialSaleOffer;

    @Override
    public MVCModel executeGet(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return redirectTo(FrontPageController.class);
        }

        User user = (User) request.getSession().getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();

        Product product = specialSaleOffer.getOffer();
        map.put("saleOffer", product);
        map.put("user", user);

        return new MVCModel(map, "/profile.jsp");
    }

    @Override
    protected MVCModel executePost(HttpServletRequest request) {

        String name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.getSession().setAttribute("profileError", EMPTY_FIELDS);
            return redirectTo(ProfileController.class);
        }

        try {
            User userCheckedByEmail = userDAO.getByEmail(email);
            User fromSession = (User) request.getSession().getAttribute("user");

            if (userCheckedByEmail == null || email.equals(fromSession.getEmail())) {
                User user = (User) request.getSession().getAttribute("user");
                user.setFullName(name);
                user.setEmail(email);
                user.setPassword(password);
                userDAO.update(user);

                request.getSession().removeAttribute("user");
                request.getSession().setAttribute("user", user);

                Map<String, Object> map = new HashMap<>();
                map.put("user", user);
                map.put("profileError", USER_UPDATED);
                return new MVCModel(map, "/profile.jsp");

            } else if (userCheckedByEmail != null) {
                request.getSession().setAttribute("profileError", USER_ALREADY_EXISTS);
                return redirectTo(ProfileController.class);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("profileError", UNEXPECTED_ERROR);
        return redirectTo(ProfileController.class);
    }
}