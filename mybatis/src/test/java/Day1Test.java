import com.brianyi.entity.Country;
import com.brianyi.entity.SysRole;
import com.brianyi.entity.SysUser;
import com.brianyi.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * TODO
 *
 * @author ahao 2020-10-03
 */
public class Day1Test {
    private static SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }
    @Test
    public void  testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Country> selectAll = sqlSession.selectList("com.brianyi.mapper.CountryMapper.selectAll");
        selectAll.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void testSelectUserAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<SysUser> selectAll = sqlSession.selectList("com.brianyi.mapper.UserMapper.selectAll");
        System.out.println(selectAll);
        sqlSession.close();
    }
    @Test
    public void getOneUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = mapper.selectById(1L);
        System.out.println(sysUser.getHeadImg());
        sqlSession.close();
    }
    @Test
    public void getRolesForUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysRole> sysRoles =  mapper.selectRolesByUserId(1L);
        sysRoles.forEach(a->{
            System.out.println(a.getId()+a.getRoleName());
        });
        sqlSession.close();
    }
    @Test
    public void insertTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = new SysUser();
        sysUser.setCreateTime(new Date());
        sysUser.setUserPassword("12245");
        sysUser.setUserName("ahao");
        sysUser.setUserEmail("ahoa@qq.com");
        sysUser.setHeadImg(new byte[]{123,2});
//        Integer integer = mapper.insertUser(sysUser);
        mapper.getKeyBySelectKey(sysUser);
        System.out.println(sysUser.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void slf4jTest() {
        Logger logger = LoggerFactory.getLogger(Day1Test.class);
        logger.debug("logger 测试啦啦啦啦啦啦啦啦啦");
    }
}
