package com.ykjzone.pojo;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Excellentworks {
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    @URL
    private String link_to;

    private Date pub_time;

    @NotNull
    private Integer location;


    public Excellentworks(){
        pub_time = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLink_to() {
        return link_to;
    }

    public void setLink_to(String link_to) {
        this.link_to = link_to == null ? null : link_to.trim();
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
}