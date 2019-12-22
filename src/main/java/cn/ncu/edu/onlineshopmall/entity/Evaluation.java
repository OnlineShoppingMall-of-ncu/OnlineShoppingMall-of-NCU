package cn.ncu.edu.onlineshopmall.entity;

public class Evaluation {
    private String evaluationid;
    private String username;
    private String commodityid;
    private String content;


    public String getEvaluationid() {
        return evaluationid;
    }

    public void setEvaluationid(String evaluationid) {
        this.evaluationid = evaluationid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
