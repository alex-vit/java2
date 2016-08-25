package lv.javaguru.java2.servlet;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.ProductDAOImpl;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class ProfileUpdateController extends MVCController {

    private final String EMPTY_FIELDS = "All fields must be filled";
    private final String USER_ALREADY_EXISTS = "User with this email already exists";
    private final String UNEXPECTED_ERROR = "Oops, something went wrong";
    private final String USER_UPDATED = "Information succesfully updated !";

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public MVCModel executeGet(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return new MVCModel("/index");
        }

        User user = (User) request.getSession().getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();

        String imgPath;
        int bannerId;
        List<Product> productList = productDAO.getAll();
        if (productList.size() == 0) {
            imgPath = "miskaweb/img/default.jpg";
        } else {
            Random random = new Random();
            bannerId = random.nextInt(productList.size());
            imgPath = productList.get(bannerId).getImgUrl();
        }

        if (request.getSession().getAttribute("profileError") != null) {
            String error = (String) request.getSession().getAttribute("profileError");
            request.getSession().removeAttribute("profileError");

            map.put("profileError", error);
            map.put("user", user);
            return new MVCModel(map, "/profile_update.jsp");
        }

        map.put("imgPath", imgPath);
        map.put("user", user);

        return new MVCModel(map, "/profile_update.jsp");
    }

    @Override
    protected MVCModel executePost(HttpServletRequest request) {

        String name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.getSession().setAttribute("profileError", EMPTY_FIELDS);
            return new MVCModel("/profile_update");
        }

        try {
            User userCheckedByEmail = userDAO.getByEmail(email);
            User fromSession = (User) request.getSession().getAttribute("user");

            if(userCheckedByEmail == null || email.equals(fromSession.getEmail())){
                User user = (User) request.getSession().getAttribute("user");
                user.setFullName(name);
                user.setEmail(email);
                user.setPassword(password);
                userDAO.update(user);

                Map<String, Object> map = new HashMap<>();
                map.put("user", user);
                map.put("profileError", USER_UPDATED);
                return new MVCModel(map, "/profile_update.jsp");

            }else if(userCheckedByEmail != null) {
                request.getSession().setAttribute("profileError", USER_ALREADY_EXISTS);
                return new MVCModel("/profile_update");
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("profileError", UNEXPECTED_ERROR);
        return new MVCModel("/profile_update");
    }
}