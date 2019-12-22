package cn.ncu.edu.onlineshopmall.util;

import cn.ncu.edu.onlineshopmall.entity.Commodity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Msg {
    private int code;
    //分页时返回数据的条数
    private Long total;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Commodity> getCommditys() {
        return Commditys;
    }

    public void setCommditys(List<Commodity> commditys) {
        Commditys = commditys;
    }

    //提示信息
    private String msg;
    //数据
    private Map<String,Object> info = new HashMap<>();

    private List<Commodity> Commditys;


    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }


    public static Msg success(String msg){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg(msg);
        return result;
    }

    public static Msg fail(String msg){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    public Msg add(String key,Object value){
        this.getInfo().put(key,value);
        return this;
    }
}
