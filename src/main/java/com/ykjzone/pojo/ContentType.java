package com.ykjzone.pojo;

public class ContentType {
    private Integer id;

    private String app_label;

    private String model;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApp_label() {
        return app_label;
    }

    public void setApp_label(String app_label) {
        this.app_label = app_label == null ? null : app_label.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }
}