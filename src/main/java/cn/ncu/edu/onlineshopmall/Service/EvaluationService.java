package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.EvaluationDao;
import cn.ncu.edu.onlineshopmall.entity.Evaluation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EvaluationService {
    @Resource
    private EvaluationDao EvaluationDao;

    /**
     *查询所有的评价信息
     * @return List<Evaluation>
     */
    public List<Evaluation> findAllEvaluation(){
        return EvaluationDao.findAllEvaluation();
    }

    /**
     *通过评价唯一编号evaluationid来查询评价信息
     *  @return Evaluation
     */
    public Evaluation findEvaluationByEvaluationid(int evaluationid){
        return EvaluationDao.findEvaluationByEvaluationid(evaluationid);
    }

    /**
     *通过用户名username来查询该用户所有的评价信息
     * @return List<Evaluation>
     */
    public List<Evaluation> findEvaluationByUsername(String username){
        return EvaluationDao.findEvaluationByUsername(username);
    }

    /**
     *通过商品唯一编号commidityid来查询评价信息
     *  @return Evaluation
     */
    public Evaluation findEvaluationByCommidityid(int commidityid){
        return EvaluationDao.findEvaluationByCommidityid(commidityid);
    }

    /**
     *插入评估信息，evaluationid为自增，自动生成
     * @param username
     * @param commidityid
     * @param content
     */
    public void InsertEvaluation(String username,int commidityid,String content){
        EvaluationDao.InsertEvaluation(username,commidityid,content);
    }

    /**
     * 通过评价唯一编号evaluationid在表中删除一条评价信息
     * @param evaluationid
     */
    public void deleteEvaluationByEvaluationid(int evaluationid){
        EvaluationDao.deleteEvaluationByEvaluationid(evaluationid);
    }

    /**
     * 通过用户名username在表中删除这一用户的所有评价信息
     * @param username
     */
    public void deleteEvaluationByUsername(String username){
        EvaluationDao.deleteEvaluationByUsername(username);
    }

    /**
     * 通过商品唯一编号commidityid在表中删除这一商品的所有评价信息
     * @param commidityid
     */
    public void deleteEvaluationByCommidityid(int commidityid){
        EvaluationDao.deleteEvaluationByCommidityid(commidityid);
    }
}
