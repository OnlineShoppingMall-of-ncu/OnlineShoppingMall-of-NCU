package cn.ncu.edu.onlineshopmall.Controller.front;

import cn.ncu.edu.onlineshopmall.Service.PostService;
import cn.ncu.edu.onlineshopmall.entity.Post;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class CommentController {

    @Autowired
    private PostService postService;

    @RequestMapping("/post")
    public String post(HttpSession session, Model model){
        if(session.getAttribute("Users")!=null){
            List<Post> postList=postService.findAllPost();
            model.addAttribute("postList",postList);
            return "add-posts";
        } else {
            return "redirect:/users/login";
        }
    }

    @RequestMapping("/dopost")
    public String dopost(String content,HttpSession session,Model model){

        User user= (User) session.getAttribute("Users");
        if (user==null){
            return "redirect:/users/login";
        }else {
            String pid= UUID.randomUUID().toString().substring(0,5);
            postService.InsertPost(pid,user.getUsername(),content);
            List<Post> postList=postService.findAllPost();
            model.addAttribute("postList",postList);
            return "add-posts";
        }

    }
}
