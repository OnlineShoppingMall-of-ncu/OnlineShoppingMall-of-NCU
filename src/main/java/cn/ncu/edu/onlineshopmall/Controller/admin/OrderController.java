package cn.ncu.edu.onlineshopmall.Controller.admin;

import cn.ncu.edu.onlineshopmall.Service.OrderService;
import cn.ncu.edu.onlineshopmall.Service.ShopService;
import cn.ncu.edu.onlineshopmall.entity.Order;
import cn.ncu.edu.onlineshopmall.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService ;
    @Autowired
    ShopService shopService ;


    @RequestMapping("/list_one")
    public String orderone() {
        return "indent-list";
    }



    @RequestMapping("/list_two")
    public String ordertwo() {
        return "indent-list2";
    }

    @RequestMapping("/list_test")
    public String ordertest() {
        return "indent-list-test";
    }


    /**
     * 用户是商家只显示所在商铺的订单信息；用户是系统管理员可以显示所有的订单信息
     */
    @RequestMapping("/findorder")
    public String findOrder(HttpServletRequest request, Map<String, List<Order>> map){
        String username = request.getParameter("username");
        String roles = request.getParameter("role");
        int role = Integer.parseInt(roles);
        if( role==3) {
            map.put("orderlist", orderService.findAllOrder());
            return "indent-list";
        }else {
           Shop shop=shopService.findShopByUsername(username);
            map.put("orderlist", orderService.findOrderByShopid(shop.getShopid()));
            return "indent-list";
        }

    }


}
