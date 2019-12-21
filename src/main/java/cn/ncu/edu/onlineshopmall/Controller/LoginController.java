package cn.ncu.edu.onlineshopmall.Controller;


import cn.ncu.edu.onlineshopmall.Dao.UserDao;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @GetMapping("/admin")
//    public  String gotoadmin(){
//        return "index";
//    }

    @Resource
    UserDao userdao;

    @GetMapping(value="")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        User user = userdao.findUserByUsername(username);
        if("yw".equals(username) && "123456".equals(password))
            //管理员专属密码
            return "redirect:/";
        else if(user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            System.out.println(user);
            return "redirect:/";
        } else {
            map.put("msg", "账号或密码输入错误");
            return "signin";
        }


    }
}