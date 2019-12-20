package cn.ncu.edu.onlineshopmall.Dao;

import cn.ncu.edu.onlineshopmall.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {



    /*
     **查询所有的用户信息
     */
     @Select("select * from user")
     List<User> findAllUser();



    /*
     **@通过用户名username来查询该用户信息
     */
     @Select("SELECT * FROM user WHERE username = #{username}")
     User findUserByUsername(@Param("username") String username);



    /*
     **插入用户信息
     */
    @Insert("insert into user(username，password，role，sex，address,phone,name,idcard)" +
            "values(#{username}, #{password}, #{role}, #{sex}, #{address}，#{phone}，#{name}，#{idcard})")
    boolean InsertUser(@Param("username") String username, @Param("password") String password, @Param("role")  int  role,
                         @Param("sex") String sex, @Param("address") String address,@Param("phone") String phone,
                       @Param("name") String name,@Param("idcard") String idcard);



    /*
    **根据用户名username更新用户身份信息role（注册成为会员）
     */
    @Update("UPDATE user SET role = #{role} WHERE username = #{username}")
    boolean updateUserByUR(@Param("username") String username, @Param("role") int role);



    /**
     * 通过用户名username在表中删除该用户信息
     */
    @Delete("DELETE from user WHERE username = #{username}")
    boolean deleteUserByUsername(@Param("username") String username);



}
