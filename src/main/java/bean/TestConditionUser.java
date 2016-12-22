package bean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.MybatisUtils;

import java.util.List;

/**
 * Created by DBQ on 2016/11/26.
 */
public class TestConditionUser {

    @Test
    public void test1(){
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getFactory();
        SqlSession session = sqlSessionFactory.openSession();
        List<User> users = session.selectList("userMapper3.getUser", new ConditionUser("o", 13, 28));
        session.close();
        System.out.println(users);
    }
}
