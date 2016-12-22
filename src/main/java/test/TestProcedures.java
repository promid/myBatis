package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import util.MybatisUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DBQ on 2016/11/26.
 */
public class TestProcedures {

    @Test
    public void test1(){
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getFactory();
        SqlSession session = sqlSessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("sex_id", 1);
        map.put("user_count", -1);
        session.selectOne("userMapper4.getUserCount", map);
        session.close();
        System.out.printf(map.get("user_count").toString());
    }
}

