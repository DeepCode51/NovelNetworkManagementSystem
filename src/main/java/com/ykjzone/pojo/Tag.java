package com.ykjzone.pojo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Tag {
    private Integer id;

    @NotBlank
    @Size(max=200, message="标签长度不能超过20字")
    private String name;

    private Category category;

    private Integer category_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getCategory_id(){
        return category_id;
    }

    public void setCategory_id(Integer category_id){
        this.category_id = category_id;
    }
}