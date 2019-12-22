package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.PostDao;
import cn.ncu.edu.onlineshopmall.entity.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {

    @Resource
    PostDao postDao;


    /*
     **查询所有的帖子信息
     */
    public List<Post> findAllPost(){
      return  postDao.findAllPost();
    }



    /*
     **通过帖子唯一编pid来查询帖子信息
     */
    public Post findPostByPid(String pid){
        return postDao.findPostByPid(pid);
    }




    /*
     **通过用户名username来查询该用户所有的帖子信息
     */
    public List<Post> findPostByUsername( String username){
        return postDao.findPostByUsername(username);
    }



    /*
     **插入帖子信息
     */
    public void InsertPost(String pid,String username,String content){
        postDao.InsertPost(pid,username, content);
    }



    /**
     * 通过帖子唯一编号pid在表中删除一条帖子信息
     */
    public void deletePostByPid(String pid){
        postDao.deletePostByPid(pid);
    }



    /**
     * 通过用户名username在表中删除这一用户的所有帖子信息
     */
    public void deletePostByUsername(String username){
        postDao.deletePostByUsername(username);
    }

}
