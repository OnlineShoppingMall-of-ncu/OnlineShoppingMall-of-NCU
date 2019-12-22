package cn.ncu.edu.onlineshopmall.Controller.front;

import cn.ncu.edu.onlineshopmall.Service.CommodityService;
import cn.ncu.edu.onlineshopmall.Service.EvaluationService;
import cn.ncu.edu.onlineshopmall.entity.Commodity;
import cn.ncu.edu.onlineshopmall.entity.Evaluation;
import cn.ncu.edu.onlineshopmall.entity.User;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class FrontGoodsController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private EvaluationService evaluationService;

    /**
     * 商品详情展示
     * @param commodityid
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detailGoods(String commodityid,Model model){

        //要查询商品的基本信息
        Commodity goods = commodityService.findGoodsById(commodityid);
        model.addAttribute("goodsinfo",goods);
        Evaluation evaluation =evaluationService.findEvaluationByCommodityid(goods.getCommodityid());
        if(evaluation!=null) {
            model.addAttribute("comment", evaluation);
        }
        return "deal_single";
    }

    //根据分类查找商品
    @RequestMapping("/getByCategory")
    public String getByCategoryId(String category, Model model, Integer pageNum, Integer pageSize, Integer pageIndex, HttpServletRequest request){

        User user= (User) request.getSession().getAttribute("Users");
        if (pageSize==null){
            pageSize=6;
        }
        if (pageNum==null){
            pageNum=1;
        }
        if (pageIndex == null){
            pageIndex =1;
        }

        List<Commodity> goodsList = commodityService.selectByCategory(category,pageNum,pageSize);
        int total = (int) ((Page) goodsList).getTotal();
        int num = total%pageSize == 0? total/pageSize:total/pageSize+1;
        int pages[] = new int[num];
        for(int i =0;i<num;i++){
            pages[i]=i+1;
        }
        model.addAttribute("category",category);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("pages",pages);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageIndex",pageIndex);
        return "goods-by-category";
    }


}
