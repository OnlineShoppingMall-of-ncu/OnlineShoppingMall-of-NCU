package cn.ncu.edu.onlineshopmall.Controller;


import cn.ncu.edu.onlineshopmall.Dao.UserDao;
import cn.ncu.edu.onlineshopmall.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController

public class RegisterController {

    @Resource
    UserDao userdao;

    @GetMapping("/users/register")
    @ResponseBody
    public String Inregister() {
        System.out.println("111");
        return "redirect:/register.html";
    }


//    private String username;
//    private  String password;
//    private int  role;
//    private String sex;
//    private String address;
//    private String phone;
//    private String name;
//    private String idcard;

    @PostMapping("/users/register")
    @ResponseBody
    public String Register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("repassword") String repassword,
                           @RequestParam("role") int role,
                           @RequestParam("sex") String sex,
                           @RequestParam("address") String address,
                           @RequestParam("phone") String phone,
                           @RequestParam("name") String name,
                           @RequestParam("idcard") String idcard,
                           Map<String, Object> map) {

        User user = userdao.findUserByUsername(username);
        System.out.println(username);
        System.out.println(password);
        System.out.println(repassword);
        System.out.println(role);
        System.out.println(sex);
        System.out.println(address);
        System.out.println(phone);
        System.out.println(name);
        System.out.println(idcard);

        if(!password.equals(repassword)) {
            map.put("msg", "两次输入的密码不一致，请重新输入");
            return "register";
        } else if(user != null) {
            map.put("msg", "该用户名已经注册，请重新输入");
            return "register";
        }else {

            userdao.InsertUser(username, password, role, sex, address, phone, name, idcard);

            return "redirect:/login";
        }
    }



}

