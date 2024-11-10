package com.ykjzone.page;


import com.github.pagehelper.PageHelper;
import com.ykjzone.pojo.NovelExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 接收查询字符串的请求参数注入到属性中
 */
public class NovelPage extends Page {
    private String name;                // 小说名字
    private Integer category_id;        // 分类id
    private NovelExample example;
    private NovelExample.Criteria criteria;


    public NovelPage(){
        super();
        example = new NovelExample();
        criteria = example.createCriteria();
    }

    public void setStart_date(String start){
        super.setStart_date(start);
        criteria.andPub_dateGreaterThan(start_date);
    }

    public void setEnd_date(String end){
        super.setEnd_date(end);
        criteria.andPub_dateLessThan(end_date);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        if(name != null && !name.equals("")){
            criteria.andNameLike("%" + name.trim() + "%");
        }
    }

    public Integer getCategory_id(){
        return category_id;
    }

    public void setCategory_id(Integer category_id){
        if(category_id != null && category_id != 0){
            this.category_id = category_id;
            criteria.andCategory_idEqualTo(category_id);
        }
    }

    public NovelExample getExample(){
        return example;
    }

    public void setExample(NovelExample example){
        this.example = example;
    }

    public NovelExample.Criteria getCriteria() {
        if(criteria == null)
            if(example == null)
                return null;
            else
                criteria = example.createCriteria();
        return criteria;
    }

    public Map<String,Object> getParams(){
        Map<String,Object> params = new HashMap<String,Object>(){
            {
                put("name",name);
                put("category_id",category_id);
                put("url_query", getUrlQuery());
            }
        };
        params.putAll(super.getParams());
        params.putAll(getPaginationData());
        return params;
    }

    public String getUrlQuery(){
        StringBuilder urlQuery = new StringBuilder();
        if(start != null && !start.equals(""))
            urlQuery.append("&start=" + start);
        if(end != null && !end.equals(""))
            urlQuery.append("&end=" + end);
        if(name != null && !name.equals(""))
            urlQuery.append("&name=" + name);
        if(category_id != null && category_id != 0)
            urlQuery.append("&category_id=" + category_id);
        return urlQuery.toString();
    }

}
