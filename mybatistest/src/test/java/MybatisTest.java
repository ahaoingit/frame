import com.brianyi.dao.UserDao;
import com.brianyi.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * TODO
 *
 * @author ahao 2020-11-03
 */
public class MybatisTest {
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
        reader.close();
    }

    @Test
    public void findAllUser() {
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.queryById("1327128442de405782b737876e1dd764");
        System.out.println(user.getAddress());
        System.out.println(User.class.getCanonicalName());
    }
    @Test
    public void insertTest() {
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUid(UUID.randomUUID().toString().replace("-",""));
        user.setUsername("ahao");
        user.setPwd("123-564");
        user.setAddress("afds");
        user.setPhoneNum("11112345");
        user.setQqNum("1231231");
        user.setWechatNum("231313");
        user.setClazz("123");
        user.setImage("12111");
        user.setNickname("2111");
        int insert = mapper.insert(user);
        System.out.println(insert);
    }

}
