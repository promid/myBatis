package test;

import bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.MybatisUtils;

/**
 * Created by DBQ on 2016/11/26.
 */
public class TestInjections {

    @Test
    public void testAdd2(){
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int add = mapper.add(new User(-1, "ddsd", 45));
        sqlSession.close();
        System.out.println(add);
    }
}
