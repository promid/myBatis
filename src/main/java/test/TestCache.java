package test;

import bean.CUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.MybatisUtils;

/**
 * Created by DBQ on 2016/11/26.
 */

/*
 * 测试缓存
 1. 一级缓存 : session级的缓存
 	1. 执行了session.clearCache();
 	2. 执行CUD操作
 	3. 不是同一个Session对象
 	不会使用一级缓存
 2. 二级缓存: 是一个映射文件级的缓存 类需要实现序列化
 */
public class TestCache {
    @Test
    public void testCacheOne() {

        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession();


        String statement = "userMapper5.getUser";
        CUser user = session.selectOne(statement, 1);
        System.out.println(user);




		 //1. 执行了session.clearCache(); 不会使用一级缓存
		session.clearCache();


        user = session.selectOne(statement, 1);
        System.out.println(user);
        System.out.println("----------------*********************");

		/*
		//2. 执行CUD操作后 不会使用一级缓存
		session.update("userMapper5.updateUser", new CUser(1, "Tom", 13));
		session.commit();
		*/

        //3. 不是同一个Session对象 不会使用一级缓存
        session.close();
        session = factory.openSession();

        user = session.selectOne(statement, 1);

        System.out.println(user);



        session.close();
    }

    @Test
    public void testCacheTwo() {

        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();

        String statement = "userMapper5.getUser";
        CUser user = session1.selectOne(statement, 1);
        session1.close();
        System.out.println(user);

        user = session2.selectOne(statement, 1);
        session2.close();
        System.out.println(user);


    }
}
