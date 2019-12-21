package cn.ncu.edu.onlineshopmall.Controller.front;

import cn.ncu.edu.onlineshopmall.Service.ShoppingCarService;
import cn.ncu.edu.onlineshopmall.entity.ShoppingCar;
import cn.ncu.edu.onlineshopmall.entity.User;
import cn.ncu.edu.onlineshopmall.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ShopcartController {

    @Autowired
    private ShoppingCarService shoppingCarService;

    @RequestMapping("/addCart")
    @ResponseBody
    public Msg addCart(String goodsId, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("Users");
        if(user == null) {
            return Msg.fail("请先登录");
        }
        List<ShoppingCar> shoppingCars=shoppingCarService.findShoppingCarByUsername(user.getUsername());
        int number=shoppingCars.size();
        //判断是否已经加入购物车
        ShoppingCar shopCart =  shoppingCarService.findShopCarShopByGoodsId(goodsId);
        if (shopCart != null) {
            return Msg.fail("已加入购物车");
        }else{
            number=number+1;
            shoppingCarService.InsertShoppingCar(user.getUsername(),goodsId);
        }
        return Msg.success("加入购物车成功");
    }

}
