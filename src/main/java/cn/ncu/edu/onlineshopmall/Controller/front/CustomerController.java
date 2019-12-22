package cn.ncu.edu.onlineshopmall.Controller.front;

import cn.ncu.edu.onlineshopmall.Service.ShopService;
import cn.ncu.edu.onlineshopmall.Service.UserService;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class CustomerController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;

    @RequestMapping("/login")
    public String UserLogin(){
        return "sigin";
    }

    @RequestMapping("/logout")
    public String UserLogout(HttpSession session){
        session.removeAttribute("Users");
        return "index";
    }

    @RequestMapping(value = "/loginconfirm",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        User user=userService.findUserByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            session.setAttribute("Users", user);
            System.out.println(user);
            return "redirect:/main";
        } else {
            model.addAttribute("msg", "账号或密码输入错误");
            return "sigin";
        }

    }


    @RequestMapping("/register")
    public String UserRegister(){
        return "siginup";
    }



    @RequestMapping(value = "/registerconfirm",method = RequestMethod.POST)
    public String Register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("repassword") String repassword,
                           @RequestParam("role") int role,
                           @RequestParam("sex") String sex,
                           @RequestParam("address") String address,
                           @RequestParam("phone") String phone,
                           @RequestParam("name") String name,
                           @RequestParam("idcard") String idcard,
                           Model model) {

        System.out.println(username);
        if(!password.equals(repassword)) {
            model.addAttribute("msg", "两次输入的密码不一致，请重新输入");
            return "redirect:/users/register";
        } else if(userService.findUserByUsername(username) != null) {
            model.addAttribute("msg", "该用户名已经注册，请重新输入");
            return "redirect:/users/register";
        }else {

            User user1=new User(username, password, role, sex, address, phone, name, idcard);
            userService.InsertUser(user1);
            if(user1.getRole()==1)
            return "redirect:/users/login";

            else {
                String shopid= UUID.randomUUID().toString().substring(0,7);
                shopService.InsertShop(shopid,user1.getUsername());
                return "redirect:/admin/login";
            }
        }
    }
}
