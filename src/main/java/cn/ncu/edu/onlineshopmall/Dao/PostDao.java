package cn.ncu.edu.onlineshopmall.Dao;


import cn.ncu.edu.onlineshopmall.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostDao {

    /*
     **查询所有的帖子信息
     */
    @Select("select * from post")
    List<Post> findAllPost();



    /*
     **通过帖子唯一编pid来查询帖子信息
     */
    @Select("select * from post where pid=#{pid}")
    Post findPostByPid(@Param("pid") String pid);



    /*
     **通过用户名username来查询该用户所有的帖子信息
     */
    @Select("select * from post where username=#{username}")
    List<Post> findPostByUsername(@Param("username") String username);



    /*
     **插入帖子信息
     */
    @Insert("insert into post( pid,username, content)" +
            "values(#{pid}, #{username},#{content})")
    void InsertPost(
            @Param("pid") String pid,
            @Param("username") String username,
            @Param("content") String content);



    /**
     * 通过帖子唯一编号pid在表中删除一条帖子信息
     */
    @Delete("DELETE from post WHERE pid = #{pid}")
    void deletePostByPid(@Param("pid") String pid);



    /**
     * 通过用户名username在表中删除这一用户的所有帖子信息
     */
    @Delete("DELETE from post WHERE username = #{username}")
    void deletePostByUsername(@Param("username") String username);



}
