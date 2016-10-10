import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
@WebAppConfiguration
public class TestTest {

    @Autowired
    @Qualifier("ORM_UserDAO")
    UserDAO userDAO;

    @Test
    public void test() {
        System.out.println(userDAO);
    }

}
