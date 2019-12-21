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
    Evaluation findEvaluationByEvaluationid(@Param("evaluationid") int evaluationid);



    /*
     **通过用户名username来查询该用户所有的评价信息
     */
    @Select("select * from evaluation where username=#{username}")
    List<Evaluation> findEvaluationByUsername(@Param("username") String username);



    /*
     **通过商品唯一编号commidityid来查询评价信息
     */
    @Select("select * from evaluation where commidityid=#{commidityid}")
    Evaluation findEvaluationByCommidityid(@Param("commidityid") String commidityid);



    /*
    **插入评估信息，evaluationid为自增，自动生成
     */
    @Options(useGeneratedKeys = true, keyProperty = "evaluationid")
    @Insert("insert into evaluation ( username, commidityid, content)" +
            "values(#{username}, #{commidityid}, #{content})")
    void InsertEvaluation(@Param(" username") String username,
                          @Param("commidityid") String commidityid,
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
     * 通过商品唯一编号commidityid在表中删除这一商品的所有评价信息
     */
    @Delete("DELETE from evaluation WHERE commidityid = #{commidityid}")
    void deleteEvaluationByCommidityid(@Param("commidityid") String commidityid);


}
