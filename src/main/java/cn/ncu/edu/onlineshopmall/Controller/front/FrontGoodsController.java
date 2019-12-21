package cn.ncu.edu.onlineshopmall.Controller.front;

import cn.ncu.edu.onlineshopmall.Service.CommodityService;
import cn.ncu.edu.onlineshopmall.Service.EvaluationService;
import cn.ncu.edu.onlineshopmall.entity.Commodity;
import cn.ncu.edu.onlineshopmall.entity.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
