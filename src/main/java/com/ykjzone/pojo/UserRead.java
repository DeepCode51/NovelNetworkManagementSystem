package com.ykjzone.pojo;

public class UserRead {
    private Integer id;

    private User user;

    private Novel novel;

    private String user_id;

    private String novel_id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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