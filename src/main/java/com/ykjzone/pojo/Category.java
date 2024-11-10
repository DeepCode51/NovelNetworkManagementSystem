package com.ykjzone.pojo;

import java.util.List;

public class Category {
    public static final String[][] CATEGORY_NAME = {
        {"xuanhuan","玄幻"},
        {"qihuan","奇幻"},
        {"wuxia","武侠"},
        {"xianxia","仙侠"},
        {"dushi","都市"},
        {"xianshi","现实"},
        {"junshi","军事"},
        {"lishi","历史"},
        {"youxi","游戏"},
        {"tiyu","体育"},
        {"kehuan","科幻"},
        {"xuanyi","悬疑"}
    };

    private static List<Category> categories;

    private Integer id;

    private String name;

    private List<Tag> tags;

    private Integer novels_num;

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

    public List<Tag> getTags(){
        return tags;
    }

    public void setTags(List<Tag> tags){
        this.tags = tags;
    }

    public Integer getNovels_num(){
        return novels_num;
    }

    public void setNovels_num(Integer novels_num){
        this.novels_num = novels_num;
    }

//    public static List<Category> getCategories(){
//        if(categories == null){
//
//        }
//        return categories;
//    }



    public static void main(String[] args){
        System.out.println(1 << 3);
    }
}