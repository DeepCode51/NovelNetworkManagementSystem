package com.ykjzone.pojo;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Advertisement {
    private Integer id;

    @URL
    @NotNull
    private String image_url;

    @NotNull
    private String hint;

    private Date pub_time;

    @NotNull
    private Integer location;

    @URL
    @NotNull
    private String link_to;


    public Advertisement(){
        pub_time = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url == null ? null : image_url.trim();
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint == null ? null : hint.trim();
    }

    public Date getPub_time() {
        return pub_time;
    }

    public void setPub_time(Date pub_time) {
        this.pub_time = pub_time;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getLink_to() {
        return link_to;
    }

    public void setLink_to(String link_to) {
        this.link_to = link_to == null ? null : link_to.trim();
    }
}