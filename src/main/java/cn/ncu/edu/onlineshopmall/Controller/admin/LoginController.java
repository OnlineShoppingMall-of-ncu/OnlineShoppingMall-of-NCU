package cn.ncu.edu.onlineshopmall.Controller.admin;

import cn.ncu.edu.onlineshopmall.Service.UserService;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    UserService userService ;

    @RequestMapping("/login")
    public String adminLogin() {
        return "admin-login";
    }


    @RequestMapping("/success")
    public String loginsuccess(){
        return "admin-index";
    }



    @RequestMapping(value = "/confirmLogin",method = RequestMethod.POST)
    public String confirmLogin(@RequestParam("username")String username, @RequestParam("password") String password, Model model, HttpServletRequest request){

        User admin = userService.findUserByUsername(username);
        if (admin == null||!(admin.getPassword().equals(password))){
            model.addAttribute("errorMsg", "用户名或密码错误");
            return "admin-login";
        }else
            {
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            return "redirect:/admin/success";
        }
    }




    @RequestMapping("/logout")
    public String adminLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "redirect:/admin/login";
    }
}
