import com.brianyi.entity.SysRole;
import com.brianyi.entity.SysUser;
import com.brianyi.mapper.RoleMapper;
import com.brianyi.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

/**
 * TODO
 *
 * @author ahao 2020-10-07
 */
public class AnnotationTest {
    private static SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void selectByIdRole() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        SysRole sysRole = mapper.selectRoleById(1L);
        System.out.println(sysRole.getRoleName());
        sqlSession.close();
    }

    @Test
    public void selectAllTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        mapper.selectAllRole().forEach(sysRole -> {
            System.out.println(sysRole.getId());
        });
        sqlSession.close();
    }

    @Test
    public void insertIntoSysRole(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        SysRole sysRole = new SysRole();
        sysRole.setCreateBy(3L);
        sysRole.setCreateTime(new Date());
        sysRole.setRoleName("测试");
        roleMapper.insertRoleGetNotAutoKey(sysRole);
        System.out.println(sysRole.getId());
        sqlSession.close();
    }
    @Test
    public void oneToOneTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = mapper.selectRoleMapSelect(1001L);
    }
}
