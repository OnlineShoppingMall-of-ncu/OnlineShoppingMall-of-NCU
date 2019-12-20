package cn.ncu.edu.onlineshopmall.Controller.admin;

import cn.ncu.edu.onlineshopmall.Service.CommodityService;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/goods")
public class CommpdityController {

    @Resource
    private CommodityService  commodityService;

    @RequestMapping("searchAllGoods")
    public String SerchAll(Model model, HttpSession Session){
        User user=(User)Session.getAttribute("LoginUser");
        if(user.getRole()==3)
            model.addAttribute("GoodsList",commodityService.findAllCommodity());
        else {
            int shopid=1;
                    model.addAttribute("MyGoodList", commodityService.findAllCommdityByShopid(shopid));
        }
        return "goods-list";
    }
    @RequestMapping(value = "deleteGoodsById",method = RequestMethod.GET)
    public String deleteById(@RequestParam("commdityid")int commodityid) {
        commodityService.deleteCommodityById(commodityid);
        return "redirect:/goods/searchAllGoods";
    }

}
