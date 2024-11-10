package com.ykjzone.page;


import com.github.pagehelper.PageHelper;
import com.ykjzone.pojo.ChapterExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChapterPage extends Page {
    private String title;                // 章节标题
    private String novel_id;
    private ChapterExample example;
    private ChapterExample.Criteria criteria;


    public ChapterPage(){
        super();
        count = 10;
        example = new ChapterExample();
        example.setOrderByClause("number desc");
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

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if(title != null && !title.equals("")){
            this.title = title;
            criteria.andTitleLike("%" + title.trim() + "%");
        }
    }

    public String getNovel_id(){
        return novel_id;
    }

    public void setNovel_id(String novel_id){
        if(novel_id != null && !novel_id.equals("")){
            this.novel_id = novel_id;
            criteria.andNovel_idEqualTo(novel_id);
        }
    }

    public ChapterExample getExample(){
        return example;
    }

    public void setExample(ChapterExample example){
        this.example = example;
    }

    public ChapterExample.Criteria getCriteria() {
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
                put("title",title);
                put("novel_id",novel_id);
                put("url_query", getUrlQuery());
            }
        };
        params.putAll(super.getParams());
        params.putAll(getPaginationData());
        return params;
    }

    public String getUrlQuery(){
        StringBuilder urlQuery = new StringBuilder();
        if(novel_id != null && !novel_id.equals(""))
            urlQuery.append("&novel_id=" + novel_id);
        if(title != null && !title.equals(""))
            urlQuery.append("&title=" + title);
        if(start != null && !start.equals(""))
            urlQuery.append("&start=" + start);
        if(end != null && !end.equals(""))
            urlQuery.append("&end=" + end);
        return urlQuery.toString();
    }

}
