package com.ykjzone.util;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args){
        String pa_telephone = "1[3-9]\\d{9}";
        boolean is_match = Pattern.matches(pa_telephone, "16677778888");
        if(is_match) {
            System.out.println("手机号输入正确");
        }else{
            System.out.println("手机号输入有误");
        }
    }
}
