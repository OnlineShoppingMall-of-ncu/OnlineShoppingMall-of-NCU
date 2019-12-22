package cn.ncu.edu.onlineshopmall.Dao;

import cn.ncu.edu.onlineshopmall.entity.Evaluation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvaluationDao {
    /*
    **查询所有的评价信息
     */
    @Select("select * from evaluation ")
    List<Evaluation> findAllEvaluation();



    /*
    **通过评价唯一编号evaluationid来查询评价信息
     */
    @Select("select * from evaluation where evaluationid=#{evaluationid}")
    Evaluation findEvaluationByEvaluationid(@Param("evaluationid") String evaluationid);



    /*
     **通过用户名username来查询该用户所有的评价信息
     */
    @Select("select * from evaluation where username=#{username}")
    List<Evaluation> findEvaluationByUsername(@Param("username") String username);



    /*
     **通过商品唯一编号commodityid来查询评价信息
     */
    @Select("select *from evaluation where commodityid=#{commodityid}")
    Evaluation findEvaluationByCommodityid(@Param("commodityid") String commodityid);



    /*
    **插入评估信息
     */
    @Insert("insert into evaluation ( evaluation,username, commodityid, content)" +
            "values(#{evaluation}, #{username}, #{commodityid}, #{content})")
    void InsertEvaluation(
            @Param("evaluation")String evaluation,
            @Param("username") String username,
            @Param("commodityid") String commodityid,
            @Param("content") String content);



    /**
     * 通过评价唯一编号evaluationid在表中删除一条评价信息
     */
    @Delete("DELETE from evaluation WHERE evaluationid = #{evaluationid}")
    void deleteEvaluationByEvaluationid(@Param("evaluationid") String evaluationid);



    /**
     * 通过用户名username在表中删除这一用户的所有评价信息
     */
    @Delete("DELETE from evaluation WHERE username = #{username}")
    void deleteEvaluationByUsername(@Param("username") String username);



    /**
     * 通过商品唯一编号commodityid在表中删除这一商品的所有评价信息
     */
    @Delete("DELETE from evaluation WHERE commodityid = #{commodityid}")
    void deleteEvaluationByCommodityid(@Param("commodityid") String commdityid);


}
