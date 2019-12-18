package cn.ncu.edu.onlineshopmall.entity;

public class Evaluation {
    private int evaluationid;
    private String username;
    private int commidityid;
    private String content;

    public int getEvaluationid() {
        return evaluationid;
    }

    public void setEvaluationid(int evaluationid) {
        this.evaluationid = evaluationid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCommidityid() {
        return commidityid;
    }

    public void setCommidityid(int commidityid) {
        this.commidityid = commidityid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
