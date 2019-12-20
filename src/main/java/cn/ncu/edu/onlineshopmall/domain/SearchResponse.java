package cn.ncu.edu.onlineshopmall.domain;

import cn.ncu.edu.onlineshopmall.entity.User;

import java.util.List;

public class SearchResponse {
    private Long total;
    private String keyword;
    private List<User> users;


    public SearchResponse(Long total, List<User> users) {
        this.total = total;
        this.users = users;
    }

    public SearchResponse() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
