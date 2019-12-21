package cn.ncu.edu.onlineshopmall.Controller.admin;

import cn.ncu.edu.onlineshopmall.Service.UserService;
import cn.ncu.edu.onlineshopmall.entity.User;
import cn.ncu.edu.onlineshopmall.util.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/adminuser")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 查询所有用户
     * @returnz
     */
    @RequestMapping("findAlluser")
    public String findAll(Map<String,List<User>> map){
        map.put("userlist",userService.findAll());
        return "user-list";

    }



//    @RequestMapping(value = "/queryuser",method = RequestMethod.GET)
//    public User findUserByUsername(@RequestParam(value = "username") String username){
//        return userService.findUserByUsername(username);
//    }

    /**
     * 注销用户
     * @param username
     * @return
     */
    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam("username")String username){
        userService.deleteUserByUsername(username);
        return "user-list";
    }

    /**
     * 编辑用户信息并报存
     * @param user
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public Msg editUserPage(User user){
        userService.editUser(user);
        return Msg.success("用户信息已修改");
    }

    /**
     * 选中行批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/multiDel")
    @ResponseBody
    public Msg deleteUsersPage(@RequestParam("ids")String ids){
        userService.multiDelUsers(ids);
        return Msg.success("删除用户信息成功");
    }

    //TODO 分页查询
//    @RequestMapping("/api/search")
//    @ResponseBody
//    public SearchResponse searchUserResponse(@RequestParam("pageNum")Integer pageNum,
//                                             @RequestParam("pageSize")Integer pageSize, @RequestParam("keyword")String keyword){
//        return userService.listUser(pageNum,pageSize,keyword);
//    }


}
