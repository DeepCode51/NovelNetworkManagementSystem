package com.ykjzone.page;

import com.ykjzone.pojo.NovelExample;

import java.util.HashMap;
import java.util.Map;

public class RankPage extends Page {
    private Integer category_id;

    private NovelExample example;
    private NovelExample.Criteria criteria;

    public RankPage(){
        super();
        example = new NovelExample();
        criteria = example.createCriteria();
        count = 12;
    }

    public Integer getCategory_id(){
        return category_id;
    }

    public void setCategory_id(Integer category_id){
        this.category_id = category_id;
        if(category_id != null && category_id != 0)
            criteria.andCategory_idEqualTo(category_id);
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
        if(category_id != null)
            urlQuery.append("&category_id=" + category_id);
        return urlQuery.toString();
    }
}
