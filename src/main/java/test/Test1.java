package test;

import bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by DBQ on 2016/11/26.
 */
public class Test1 {
    public static void main(String[] args) {
        String resource = "conf.xml";
        InputStream is = User.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        String statement = "userMapper.getUser";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}
