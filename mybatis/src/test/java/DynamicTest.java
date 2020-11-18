import com.brianyi.entity.SysUser;
import com.brianyi.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-10-08
 */
public class DynamicTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public  void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void login() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = new SysUser();
        sysUser.setUserName("admin");
        sysUser = mapper.selectByUser(sysUser);
        System.out.println(sysUser);
        sqlSession.close();
    }

    @Test
    public void foreachTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        mapper.selectUserByIdList(ids).forEach(System.out::print);
        sqlSession.close();
    }
    @Test
    public void updateTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("user_password","123456");
        mapper.updateUser(map);
        sqlSession.rollback();
        sqlSession.close();
    }
    @Test
    public void userRoleTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = mapper.selectUserAndRoleById(1001L);
        System.out.println(sysUser.getRole().getRoleName());
    }
}
