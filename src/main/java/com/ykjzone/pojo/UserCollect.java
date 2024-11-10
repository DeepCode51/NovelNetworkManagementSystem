package com.ykjzone.pojo;

public class UserCollect {
    private Integer id;

    private String user_id;

    private String novel_id;

    private User user;

    private Novel novel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id(){
        return user_id;
    }

    public void setUser_id(String user_id){
        this.user_id = user_id;
    }

    public String getNovel_id(){
        return novel_id;
    }

    public void setNovel_id(String novel_id){
        this.novel_id = novel_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }
}