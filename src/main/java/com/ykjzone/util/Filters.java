package com.ykjzone.util;

import com.ykjzone.pojo.Category;
import com.ykjzone.pojo.Group;
import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.User;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Filters {

    /**
     * 调整字符串，如果字符串超出指定长度，则多余部分省略
     * @param value
     * @param num
     * @return
     */
    public static String truncate(String value, int num){
        // 判断字符长度： 汉: 1, num: 0.5, upper: 0.75, lower: 0.5, other: 1, .:0.5
        float length = 0;
        int counter = 0;
        String new_value = "";
        for(int i =  0; i < value.length(); i++){
            char ch = value.charAt(i);
            float ch_len = char_length(ch);
            if(length + ch_len <= num - 1.5) {
                length += ch_len;
                new_value += ch;
                counter += 1;
            }else{
                break;
            }
        }

        // 判断不加省略号是否可以全部显示
//        float length_ = 0;
        for(int i = counter; i < value.length(); i++){
            char ch = value.charAt(i);
            length += char_length(ch);
        }
        if(length <= num) {
            for(int i = counter; i < value.length(); i++){
                char ch = value.charAt(i);
                new_value += ch;
            }
        }else {
            new_value += "...";
        }
        return new_value;
    }

    /**
     * 调整长字符串
     * @param value
     * @param num
     * @return
     */
    public static String profile_truncate(String value, int num){
        return truncate(htmlRemoveTag(value).replace(" ","").replace("　",""), num);
    }

    public static float char_length(char ch){
        if(String.valueOf(ch).matches("[\u4e00-\u9fa5]")){
            // 是否为汉字
            return 1;
        }else if(Character.isDigit(ch)) {
            // 是否为数字
            return 0.5F;
        }else if(Character.isUpperCase(ch)){
            // 是否为大写字母
            return 0.75F;
        }else if(Character.isLowerCase(ch)) {
            // 是否为小写字母
            return 0.5F;
        }else{
            return 1;
        }
    }

    /**
     * 根据分类id获取分类名称（en/ch）
     * @param id
     * @param language
     * @return
     */
    public static String getCategoryName(int id, String language){
        String[][] category_name = Category.CATEGORY_NAME;
        if("en".equals(language)){
            return category_name[id - 1][0];
        }else if("ch".equals(language)){
            return category_name[id-1][1];
        }else{
            return category_name[id-1][0];
        }
    }

    /**
     * 移除字符串中的html标签
     * @param inputString
     * @return
     */
    public static String htmlRemoveTag(String inputString) {
        if (inputString == null)
            return null;
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        java.util.regex.Matcher m_script;
        Pattern p_style;
        java.util.regex.Matcher m_style;
        Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textStr;// 返回文本字符串
    }

    /**
     * 统计字数（万字）
     * @param value
     * @return
     */
    public static float wordsNumFilter(int value){
        DecimalFormat df = new DecimalFormat("#.0");
        return Float.parseFloat(df.format(value / 10000.0));
    }

    /**
     * 格式化时间
     * @param date
     * @param strDateFormat  yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDate(Date date, String strDateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        return sdf.format(date);
    }

    public static boolean hasNovel(List<Novel> novelList, Novel novel){
        for(Novel n : novelList){
            if(n.getId().equals(novel.getId())) return true;
        }
        return false;
    }

    public static boolean hasPermission(User user, String perm){
        if(user == null) return false;
        return user.hasPermission(perm);
    }

    public static boolean hasGroup(List<Group> groups, Group group){
        for(Group g : groups){
            if(g.getId() != null && g.getId().equals(group.getId())){
                return true;
            }
        }
        return false;
    }
}