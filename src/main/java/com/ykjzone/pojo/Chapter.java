package com.ykjzone.pojo;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.ykjzone.util.ShortUUID;
import javax.validation.constraints.*;
import java.util.Date;

public class Chapter {
    private String id;

    @Size(max = 200, message = "标题最大长度为200字")
    private String title;

    @NotNull(message = "请求参数错误")
    private Integer number;

    @NotNull(message = "请输入内容")
    private String content;

    private Integer words_num;

    private Date pub_date;

    private String novel_id;

    // 非数据库字段
    private Novel novel;


    public void generate(){
        id = ShortUUID.generateShortUuid();
        pub_date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getWords_num() {
        return words_num;
    }

    /**
     * 统计content的字数 首先要去除html标签、标点符号和换行符
     */
    public void setWords_num() {
        String content_pure = this.content.replaceAll("</?[^>]*?>","");
        content_pure = content_pure.replaceAll("&nbsp;","");
        content_pure = content_pure.replaceAll("[~!@#$%^&*()_\\-+=<>?/,.，。？！￥…（）—《》：【】、·“”‘’:;{}\\[\\]|\'\"\\n\\r\\\\  ]","");
        this.words_num = content_pure.length();
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public String getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(String novel_id) {
        this.novel_id = novel_id;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public String getContent() {
        return content;
    }

    /**
     * 将多于的html标签去除，只保留p标签
     * @param content
     */
    public void setContent(String content) {
        content = content == null ? null : content.trim();
        this.content = content.replaceAll("</?[^p][^>]*?>","");
    }

    public static void main(String[] args){
//        String html = "<code><span class=\"hljs-keyword\">set</span> <span class=\"hljs-keyword\">java</span> environment\n" +
//                "JAVA_HOME=/usr/<span class=\"hljs-keyword\">java</span>/jdk<span class=\"hljs-number\">-14.0</span><span class=\"hljs-number\">.1</span>     \n" +
//                "JRE_HOME=/usr/<span class=\"hljs-keyword\">java</span>/jdk<span class=\"hljs-number\">-14.0</span><span class=\"hljs-number\">.1</span>/jre     \n" +
//                "CLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib\n" +
//                "<span class=\"hljs-keyword\">PATH</span>=$<span class=\"hljs-keyword\">PATH</span>:$JAVA_HOME/<span class=\"hljs-keyword\">bin</span>:$JRE_HOME/<span class=\"hljs-keyword\">bin</span>\n" +
//                "<span class=\"hljs-keyword\">export</span> JAVA_HOME JRE_HOME CLASS_PATH <span class=\"hljs-keyword\">PATH</span></code>";
//        String content_pure = html.replaceAll("</?[^>]*?>","");
//        content_pure = content_pure.replaceAll("&nbsp;","");
//        content_pure = content_pure.replaceAll("[~!@#%^&*()\\-+<>?,，。？！￥…（）—《》：【】、·“”‘’;{}\\[\\]|\'\"\\n\\r\\\\]","");
////        content_pure = content_pure.replaceAll("[~!@#$%^&*()_\\-+=<>?/,.，。？！￥…（）—《》：【】、·“”‘’:;{}\\[\\]|\'\"\\n\\r\\\\  ]","");
//        System.out.println("content_pure: \n" + content_pure);
//        System.out.println("length: " + content_pure.length());

        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.INFO);
        Logger log1 = Logger.getLogger("lavasoft");
        System.out.println(log==log1);     //true
        Logger log2 = Logger.getLogger("lavasoft.blog");
        log2.setLevel(Level.WARNING);

        log.info("aaa");
        log2.info("bbb");
        log2.fine("fine");
    }
}