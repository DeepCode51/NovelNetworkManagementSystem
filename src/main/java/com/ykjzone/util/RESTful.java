package com.ykjzone.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class RESTful {
    public static int OK = 200;               // 成功
    public static int PARAMS_ERROR = 400;      // 参数错误
    public static int UNAUTH = 401;           // 没有授权
    public static int METHOD_ERROR = 405;      //方法错误
    public static int SERVER_ERROR = 500;      // 服务器内部错误

    public static String _result(int code, String message, Map<String,Object> data){
        ObjectMapper mapper = new ObjectMapper();
        // 将Map类型的data变量转为String类型

        String resultString = "";
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",code);
        resultMap.put("message",message);
        resultMap.put("data",data);

        try {
            resultString = mapper.writeValueAsString(resultMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static String result(int code, String message, Map<String,Object> data){
        return _result(code, message, data);
    }

    public static String result(int code, String message){
        return _result(code, message, new HashMap<String, Object>());
    }

    public static String ok(){
        return result(OK, "");
    }

    public static String ok(Map<String,Object> data){
        return result(OK, "", data);
    }

    public static String params_error(String message, Map<String,Object> data){
        return result(PARAMS_ERROR, message, data);
    }

    public static String params_error(String message){
        return result(PARAMS_ERROR, message, new HashMap<String,Object>());
    }

    public static String unauth(String message, Map<String,Object> data){
        return result(UNAUTH, message, data);
    }

    public static String unauth(String message){
        return result(UNAUTH, message, new HashMap<String,Object>());
    }

    public static String method_error(String message, Map<String,Object> data){
        return result(METHOD_ERROR, message, data);
    }

    public static String  server_error(String message, Map<String,Object> data){
        return result(SERVER_ERROR, message, data);
    }
}