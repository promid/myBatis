package test;

import bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by DBQ on 2016/11/26.
 */
public interface UserMapper {

    @Insert("insert into users(NAME, AGE) values(#{name}, #{age})")
    int add(User user);

    @Delete("delete from users where id=#{id}")
    int deleteById(int id);

    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    int update(User user);

    @Select("select * from users where id=#{id}")
    User getById(int id);

    @Select("select * from users")
    List<User> getAll();
}
