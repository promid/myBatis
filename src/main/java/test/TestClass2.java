package test;

import bean.Classes;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.MybatisUtils;

/**
 * Created by DBQ on 2016/11/26.
 */
public class TestClass2 {

    @Test
    public void test1(){
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getFactory();
        SqlSession session = sqlSessionFactory.openSession();
        Classes classes = session.selectOne("classMapper2.getClass", 2);
        System.out.println(classes);
        session.close();
    }

    @Test
    public void test2(){
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getFactory();
        SqlSession session = sqlSessionFactory.openSession();
        Classes classes = session.selectOne("classMapper2.getClass2", 2);
        System.out.println(classes);
        session.close();
    }

}
