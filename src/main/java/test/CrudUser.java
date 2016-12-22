package test;

import bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.MybatisUtils;

import java.util.List;

/**
 * Created by DBQ on 2016/11/26.
 */
public class CrudUser {

    @Test
    public void testAdd() {
        SqlSessionFactory factory = MybatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession();

        String statement = "userMapper2.addUser";
        int insert = session.insert(statement , new User(-1, "KK", 23));
        //提交
        session.commit();

        session.close();

        System.out.println(insert);
    }

    @Test
    public void testUpdate() {
        SqlSessionFactory factory = MybatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession(true);

        String statement = "userMapper2.updateUser";

        int update = session.update(statement, new User(4, "KK444", 25));

        session.close();
        System.out.println(update);
    }

    @Test
    public void testDelete() {
        SqlSessionFactory factory = MybatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession(true);

        String statement = "userMapper2.deleteUser";

        int delete = session.delete(statement, 4);

        session.close();
        System.out.println(delete);
    }

    @Test
    public void testGetUser() {
        SqlSessionFactory factory = MybatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession(true);

        String statement = "userMapper2.getUser";

        User user = session.selectOne(statement, 1);

        session.close();
        System.out.println(user);
    }

    @Test
    public void testGetAll() {
        SqlSessionFactory factory = MybatisUtils.getFactory();
        //默认是手动提交的
        SqlSession session = factory.openSession(true);

        String statement = "userMapper2.getAllUsers";

        List<User> list = session.selectList(statement);

        session.close();
        System.out.println(list);
    }



}
