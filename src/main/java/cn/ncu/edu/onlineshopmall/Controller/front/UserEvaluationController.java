package cn.ncu.edu.onlineshopmall.Controller.front;


import cn.ncu.edu.onlineshopmall.Service.EvaluationService;

import cn.ncu.edu.onlineshopmall.entity.Evaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller

public class UserEvaluationController {

    @Resource
    EvaluationService evaluationService;



    /**我的订单按钮跳转
     * 用户查询自己的评价信息
     * th:href="@{/finduserevaluation}+${session.User.username}"
     */
    @RequestMapping("/finduserevaluation{username}")
    public String findUserEvaluation(@PathVariable("username") String username, Map<String, List<Evaluation>> map){
        map.put("evaluationlist", evaluationService.findEvaluationByUsername(username));
        return "evaluation";
    }


     /*
     **点击添加评论按钮之后跳转到addecaluation.html
     * th:href="@{/gotoaddevaluation}+${tmp.commodityid}"
      */
     @RequestMapping("/gotoaddevaluation{commodityid}")
     public String gotoaddevaluation(@PathVariable("commodityid") String commodityid,Map<String, String> map){
         map.put("commodityid",commodityid);
         return "addevaluation";
     }


    /*
    **输入评论之后的提交按钮
    * th:action="@{/adduserevaluation}"
     */
    @PostMapping("/adduserevaluation")
    public String addUserEvaluation(@RequestParam("username") String username,
                                    @RequestParam("commodityid") String commodityid,
                                    @RequestParam("content") String content){

            String evaluationid= UUID.randomUUID().toString().substring(0,6);
            evaluationService.InsertEvaluation(evaluationid,username,commodityid,content);
       return  "user-index";


        }

}
