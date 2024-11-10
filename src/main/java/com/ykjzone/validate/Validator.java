package com.ykjzone.validate;

import com.ykjzone.pojo.User;
import com.ykjzone.service.UserService;
import com.ykjzone.util.ImageCaptcha;
import com.ykjzone.util.Redis;
import com.ykjzone.util.ShortUUID;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.regex.Pattern;

public abstract class Validator {
    protected HttpServletRequest request;
    protected HttpSession session;
    protected String message;


    public Validator(HttpServletRequest request){
        this.request = request;
        this.session = request.getSession();
    }

    public abstract boolean clean();

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    /**
     * 保存到数据库
     */
    public abstract Object save();
}
