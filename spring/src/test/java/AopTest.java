import com.brianyi.dao.UserDao;
import com.brianyi.dao.UserDaoImpl;
import com.brianyi.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author ahao 2020-11-02
 */
public class AopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("aop.xml");
//        UserDao bean = classPathXmlApplicationContext.getBean(UserDao.class);
//        bean.getUser();
//        User bean1 = (User) classPathXmlApplicationContext.getBean("user");
//        System.out.println(bean1.toString());
//
//        User userByConstructor = (User) classPathXmlApplicationContext.getBean("userByConstructor");
//        System.out.println(userByConstructor);
//
//        User userByPNameSpace = classPathXmlApplicationContext.getBean("userByPNameSpace", User.class);
//        System.out.println(userByPNameSpace);
//
//        Person bean2 = classPathXmlApplicationContext.getBean("person2",Person.class);
//        System.out.println(bean2);
//
//        Person personByStaticFactory = classPathXmlApplicationContext.getBean("personByStaticFactory", Person.class);
//        System.out.println(personByStaticFactory);

        UserDao bean = classPathXmlApplicationContext.getBean("userDaoImpl",UserDao.class);
        bean.print( "1/0 ");
    }
}
