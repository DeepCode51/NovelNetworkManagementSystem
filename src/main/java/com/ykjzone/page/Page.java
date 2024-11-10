package com.ykjzone.page;


import com.github.pagehelper.PageHelper;
import com.ykjzone.pojo.NovelExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Page {

    protected Integer p;                  // 当前页数
    protected String start;               // 开始时间str
    protected String end;                 // 结束时间str
    protected Date start_date;            // 开始时间
    protected Date end_date;              // 结束时间

    protected int count;                  // 每页显示个数
    protected int total;                  // 总个数
    protected int totalPage;              // 总页数              ┌ 2 ┐     ┌ 2 ┐
    protected int aroundCount;            // 环绕页数      [1]...[4][5][Page][7][8]...[lastPage]
    protected SimpleDateFormat sdf;

    protected static final int defaultP = 1;                  // 默认第1页
    protected static final int defaultCount = 5;              // 默认每页显示5条
    protected static final int defaultAroundCount = 2;       // 默认环绕页数
    protected static final String dateFormat = "yyyy/MM/dd";

    public Page(){
        p = defaultP;
        count = defaultCount;
        aroundCount = defaultAroundCount;
        this.sdf = new SimpleDateFormat(dateFormat);
    }

//    public Page(int p, String start, String end, String name, Integer category_id, int count) {
//
//        this.p = p;
//        this.start = start;
//        this.end = end;
//        this.name = name;
//        this.category_id = category_id;
//        this.count = count;
//
//        setStart_date(start);
//        setEnd_date(end);
//
//    }

    public int getP() {
        return p;
    }

    public void setP(Integer p) {
        if(p == null || p <= 0)
            p = 1;
        else this.p = p;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStart(){
        return start;
    }

    public void setStart(String start){
        this.start = start;
    }

    public String getEnd(){
        return end;
    }

    public void setEnd(String end){
        this.end = end;
    }

    public Date getStart_date(){
        return start_date;
    }

    public void setStart_date(Date start_date){
        this.start_date = start_date;
    }

    public void setStart_date(String start){
        try {
            this.start_date = sdf.parse(start);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getEnd_date(){
        return end_date;
    }

    public void setEnd_date(Date end_date){
        this.end_date = end_date;
    }

    public void setEnd_date(String end){
        try {
            this.end_date = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean hasPrevious(){
        if(p > 1)
            return true;
        return false;
    }

    public boolean hasNext(){
        if(p < getTotalPage())
            return true;
        return false;
    }

    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count)
            totalPage = total /count;
            // 假设总数是51，不能够被5整除的，那么就有11页
        else
            totalPage = total / count + 1;

        if(0==totalPage)
            totalPage = 1;
        return totalPage;

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAroundCount(){
        return aroundCount;
    }

    public void setAroundCount(int aroundCount){
        this.aroundCount = aroundCount;
    }



    public Map<String,Object> getParams(){
        Map<String,Object> params = new HashMap<String,Object>() {
            {
                put("start", start);
                put("end", end);
                put("has_previous", hasPrevious());
                put("previous_page_number", hasPrevious() ? p - 1 : null);
                put("has_next", hasNext());
                put("next_page_number", hasNext() ? p + 1 : null);
            }
        };
        return params;
    }

    public Map<String,Object> getPaginationData(){
        int current_page = p;
        int num_pages = getTotalPage();

        boolean left_has_more = false;
        boolean right_has_more = false;

        List<Integer> left_pages = new ArrayList<>();
        if(current_page <= aroundCount + 2){
            for(int i = 1; i < current_page; i++) left_pages.add(i);
        } else{
            left_has_more = true;
            for(int i = current_page - aroundCount; i < current_page; i++) left_pages.add(i);
        }

        List<Integer> right_pages = new ArrayList<>();
        if(current_page >= num_pages - aroundCount - 1){
            for(int i = current_page + 1; i <= num_pages; i++) right_pages.add(i);
        } else{
            right_has_more = true;
            for(int i = current_page + 1; i <= current_page + aroundCount; i++) right_pages.add(i);
        }

        Map<String,Object> data = new HashMap<>();
        data.put("left_pages", left_pages);
        data.put("right_pages", right_pages);
        data.put("current_page", current_page);
        data.put("left_has_more", new Boolean(left_has_more));
        data.put("right_has_more", new Boolean(right_has_more));
        data.put("num_pages", num_pages);
        return  data;
    }
}
