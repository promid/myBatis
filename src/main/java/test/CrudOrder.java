package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.MybatisUtils;

/**
 * Created by DBQ on 2016/11/26.
 */
public class CrudOrder {

    @Test
    public void test1() {
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession();
        String statement = "orderMapper.getOrder";
        Object order = session.selectOne(statement, 1);
        session.close();
        System.out.println(order);
    }

    @Test
    public void test2(){
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession();
        String statement = "orderMapper.getOrder2";
        Object order = session.selectOne(statement, 1);
        session.close();
        System.out.println(order);
    }
}
