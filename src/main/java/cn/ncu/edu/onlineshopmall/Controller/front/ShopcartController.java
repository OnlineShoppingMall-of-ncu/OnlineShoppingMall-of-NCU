package cn.ncu.edu.onlineshopmall.Controller.front;

import cn.ncu.edu.onlineshopmall.Service.CommodityService;
import cn.ncu.edu.onlineshopmall.Service.OrderService;
import cn.ncu.edu.onlineshopmall.Service.ShoppingCarService;
import cn.ncu.edu.onlineshopmall.entity.Commodity;
import cn.ncu.edu.onlineshopmall.entity.ShoppingCar;
import cn.ncu.edu.onlineshopmall.entity.User;
import cn.ncu.edu.onlineshopmall.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ShopcartController {

    @Autowired
    private ShoppingCarService shoppingCarService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private OrderService orderService;

    /**
     * 加入购物车功能
     * @param goodsId
     * @param request
     * @return
     */
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
            shoppingCarService.InsertShoppingCar(user.getUsername(),goodsId);
        }
        return Msg.success("加入购物车成功");
    }


    /*购物车按钮
     **   th:href="@{/shoppingcar/gotoshoppingcar}+${session.User.username}"
     */
    @RequestMapping("/gotoshoppingcar")
    public String gotomyshoppingcar( Map<String, List<Commodity>> map,
                                    HttpSession session){
        User user= (User) session.getAttribute("Users");
        if (user==null){
            return "redirect:/users/login";
        }
        //首先通过用户名在购物车中查找Shoppingcar对象
        List<ShoppingCar> shoppingcar=shoppingCarService.findShoppingCarByUsername(user.getUsername());
        //在通过Shoppingcar对象里面的商品编号来查找商品信息
        List<Commodity> commodities= new ArrayList<>();
        float allprice=0;
        int goodsSum=0;
        for (ShoppingCar tmp : shoppingcar) {
            Commodity commodity=commodityService.findGoodsById(tmp.getCommodityid());
            commodities.add(commodity);
            goodsSum++;
            allprice+=commodityService.findGoodsById(tmp.getCommodityid()).getPrice();
        }
        map.put("mycommodities",commodities);//返回该用户购物车里的的所有商品信息mycommodities
        session.setAttribute("allprice",allprice);//返回总价
        session.setAttribute("goodsSum",goodsSum);
        return "cart";

    }


    /*
     **购买按钮，把这些商品放到订单中，在商品列表中删除对应的商品，删除所有购物车中关于该条商品的信息，最后把当前该用户购物车里面的商品全部删除
     *th:href="@{/shoppingcar/buy}+${session.User.username}"
     */

    @RequestMapping("/buy")
    public String buy( Map<String, List<Commodity>> map,
                      HttpSession session){
        User user= (User) session.getAttribute("Users");
        if (user==null){
            return "redirect:/users/login";
        }
        List<ShoppingCar> shoppingcar=shoppingCarService.findShoppingCarByUsername(user.getUsername());
        for (ShoppingCar tmp : shoppingcar) {
           Commodity commodity=commodityService.findGoodsById(tmp.getCommodityid());
            String oid=UUID.randomUUID().toString().substring(0,6);
            orderService.insertOrder(oid,user.getUsername(),commodity.getCommodityid(),commodity.getShopid());//把这些商品放到订单
            commodityService.deleteCommodityById(commodity.getCommodityid());//在商品列表中删除对应的商品
            shoppingCarService.findShopCarShopByGoodsId(commodity.getCommodityid());//删除所有购物车中关于该条商品的信息
        }
        shoppingCarService.deleteShoppingCarByUsername(user.getUsername());//把当前该用户购物车里面的商品全部删除
        return "/user-index";
    }


    /*
     **删除按钮，删掉购物车里面的某一个商品信息
     *th:href="@{/shoppingcar/delete(username=${session.User.username},commodityid=${***.commodityid}"
     */
    @RequestMapping("/delete")
    public String deleteShoppingCarByUC(HttpServletRequest request,HttpSession session){
        User user= (User) session.getAttribute("Users");
        if (user==null){
            return "redirect:/users/login";
        }
        String username = request.getParameter("username");
        String commodityid = request.getParameter("commodityid");
        shoppingCarService.deleteShoppingCarByUC(username,commodityid);//删掉购物车里面的某一个商品信息
        return "redirect:/gotoshoppingcar";

    }

}
