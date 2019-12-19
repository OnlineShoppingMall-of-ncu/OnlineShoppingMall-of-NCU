package cn.ncu.edu.onlineshopmall.Controller;

import cn.ncu.edu.onlineshopmall.Service.UserService;
import cn.ncu.edu.onlineshopmall.entity.User;
import cn.ncu.edu.onlineshopmall.util.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



@Controller
//@RequestMapping("/")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/findAlluser",method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("userlist",userService.findAll());
        return "user-list";
    }


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @RequestMapping(value = "/queryuser",method = RequestMethod.GET)
    public User findUserByUsername(@RequestParam(value = "username") String username){
        return userService.findUserByUsername(username);
    }

    /**
     * 注销用户
     * @param username
     * @return
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public Msg deleteUserPage(@RequestParam("username")String username){
        userService.deleteUserByUsername(username);
        return Msg.success("删除用户信息成功");
    }




}
