package cn.ncu.edu.onlineshopmall.Controller.front;

import cn.ncu.edu.onlineshopmall.Service.OrderService;
import cn.ncu.edu.onlineshopmall.Service.ShopService;
import cn.ncu.edu.onlineshopmall.entity.Order;
import cn.ncu.edu.onlineshopmall.entity.Shop;
import cn.ncu.edu.onlineshopmall.entity.User;
import cn.ncu.edu.onlineshopmall.util.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller

public class UserOrderController {

    @Resource
    OrderService orderService ;





    /**我的订单按钮跳转
     * 用户查询自己的订单信息
     */
    @RequestMapping("/finduserorder{username}")
    public String findUserOrder(@PathVariable("username") String username, Map<String, List<Order>> map){
        System.out.println(orderService.findOrderByUsername(username));
            map.put("orderlist", orderService.findOrderByUsername(username));

            return "order";
        }

     /*
     **跳转到个人中心首页
      */

    @RequestMapping("/center")
    public String addCart( HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("Users");
        if (user == null)
            return "sigin";
        else
           return "user-index";
    }

}



