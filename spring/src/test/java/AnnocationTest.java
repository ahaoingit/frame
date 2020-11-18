import com.brianyi.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author ahao 2020-11-03
 */
public class AnnocationTest {
    @Test
    public void testAutowiredByName() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);
        userService.runDao();
    }
}
