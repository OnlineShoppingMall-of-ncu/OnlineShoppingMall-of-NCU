package cn.ncu.edu.onlineshopmall.Controller.font;

import cn.ncu.edu.onlineshopmall.Service.UserService;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("users")
public class CustomerController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        User user=userService.findUserByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            session.setAttribute("LoginUser", user);
            System.out.println(user);
            return "redirect:/main";
        } else {
            map.put("msg", "账号或密码输入错误");
            return "signin";
        }


    }
}
