package com.ykjzone.page;

import com.ykjzone.pojo.NovelExample;

import java.util.HashMap;
import java.util.Map;

public class WholePage extends Page {
    private Integer category_id;
    private Integer is_free;        // 0: 全部 1:免费 2:付费
    private Integer is_complete;    // 0: 全部 1:完本 2:连载
    private Integer sort;            // 0:最新 1:最热

    private NovelExample example;
    private NovelExample.Criteria criteria;

    public WholePage(){
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

    public Integer getIs_free(){
        return is_free;
    }

    public void setIs_free(Integer is_free){
        this.is_free = is_free;
        if(is_free == 1)
            criteria.andPriceEqualTo(0D);
        else if(is_free == 2)
            criteria.andPriceGreaterThan(0D);
    }

    public Integer getIs_complete(){
        return is_complete;
    }

    public void setIs_complete(Integer is_complete){
        this.is_complete = is_complete;
        if(is_complete == 1)
            criteria.andIs_completeEqualTo(true);
        else if(is_complete == 2)
            criteria.andIs_completeEqualTo(false);
    }

    public Integer getSort(){
        return sort;
    }

    public void setSort(Integer sort){
        this.sort = sort;
        if(sort == 0)
            example.setOrderByClause("pub_date desc");
        else if(sort == 1)
            example.setOrderByClause("views desc");
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
                put("is_free",is_free);
                put("is_complete",is_complete);
                put("sort",sort);
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
        if(is_free != null)
            urlQuery.append("&is_free=" + is_free);
        if(is_complete != null)
            urlQuery.append("&is_complete=" + is_complete);
        if(sort != null)
            urlQuery.append("&sort=" + sort);
        return urlQuery.toString();
    }

    public Map<String,String> getQuery_strings(){
        // 深拷贝用HashMap
        HashMap<String,Object> params = new HashMap<>();
//        if(category_id != null)
        params.put("category_id",category_id);
//        if(is_free != null)
        params.put("is_free",is_free);
//        if(is_complete != null)
        params.put("is_complete",is_complete);
//        if(sort != null)
        params.put("sort",sort);
        Map<String,String> query_strings = new HashMap<>();
        for(String key : params.keySet()){
            HashMap<String,Object> new_params = new HashMap<>();
            new_params.putAll(params);  // 深拷贝
            new_params.remove(key);
            query_strings.put(key + "_query", generateUrlQuery(new_params));
        }
        return query_strings;
    }

    public static String generateUrlQuery(Map<String,Object> map){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Map.Entry<String,Object> entry : map.entrySet()){
            if(entry.getValue() == null)
                continue;
            if(count++ > 0)
                sb.append("&");
            sb.append(entry.getKey() + "=" + entry.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String urlQuery = generateUrlQuery(new HashMap<String,Object>(){
            {
                put("name","kangjia");
                put("age",20);
            }
        });
        System.out.println(urlQuery);
    }
}
