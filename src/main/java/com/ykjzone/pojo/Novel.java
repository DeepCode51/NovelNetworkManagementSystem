package com.ykjzone.pojo;

import com.ykjzone.util.ShortUUID;
import org.hibernate.validator.constraints.*;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;


public class Novel {
    private String id;

    @NotBlank(message = "请输入小说名字")
    @Size(max=200, message = "小说名字最大长度为200")
    private String name;

    @NotNull(message = "价格不能为空")
    private Double price;

    @NotBlank(message = "请上传封面图")
    @Pattern(regexp="^(\\w+://)?\\w+(\\.[\\w]+)*(\\:\\d+)?\\/.*$", message = "图片上传错误（url错误）")
    private String cover_url;

    @NotBlank(message = "请输入简介")
    private String profile;

    @NotNull(message = "请选择分类")
    private Integer category_id;

    @NotNull(message = "请选择标签")
    private Integer tag_id;

    private Integer chapters_num;

    private Integer words_num;

    private Date pub_date;

    private Boolean is_complete;

    private Boolean is_recommend;

    private Integer views;

    private String author_id;

    // 非数据库字段
    private User author;

    private Category category;

    private Tag tag;

    private List<Chapter> chapters;

    // 创建Novel时调用
    public void generate(){
        id = ShortUUID.generateShortUuid();
        pub_date = new Date();
        is_complete = false;
        is_recommend = false;
        chapters_num = 0;
        words_num = 0;
        views = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getChapters_num() {
        return chapters_num;
    }

    public void setChapters_num(Integer chapters_num) {
        this.chapters_num = chapters_num;
    }

    public Integer getWords_num() {
        return words_num;
    }

    public void setWords_num(Integer words_num) {
        this.words_num = words_num;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url == null ? null : cover_url.trim();
    }

    public Integer getCategory_id(){
        return category_id;
    }

    public void setCategory_id(Integer category_id){
        this.category_id = category_id;
    }

    public Integer getTag_id(){
        return tag_id;
    }

    public void setTag_id(Integer tag_id){
        this.tag_id = tag_id;
    }

    public Boolean getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Boolean is_complete) {
        this.is_complete = is_complete;
    }

    public Boolean getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(Boolean is_recommend) {
        this.is_recommend = is_recommend;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
        this.author_id = author.getId();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.category_id = category.getId();
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
        this.tag_id = tag.getId();
    }

    public List<Chapter> getChapters(){
        return chapters;
    }

    public void setChapters(List<Chapter> chapters){
        this.chapters = chapters;
    }

    public static void main(String[] args){
        String url = "http://localhost:8080/media/image/account/2020/07/05/3vrDqGhp90.jpg";
        if(url.matches("^(\\w+://)?\\w+(\\.[\\w]+)*(\\:\\d+)?\\/.*$")){
            System.out.println("yes");
        }
    }
}