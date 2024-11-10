package com.ykjzone.validate;

import com.ykjzone.pojo.User;
import com.ykjzone.service.UserService;
import com.ykjzone.util.ImageCaptcha;
import com.ykjzone.util.MD5;
import com.ykjzone.util.Redis;
import com.ykjzone.util.ShortUUID;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.regex.Pattern;


public class UserValidator extends Validator {
    private UserService userService;
    private String telephone;
    private String username;
    private String password1;
    private String password2;
    private String img_captcha;
    private String sms_captcha;

    public UserValidator(HttpServletRequest request, UserService userService){
        super(request);
        this.userService = userService;

        this.telephone = (String) request.getParameter("telephone");
        this.username = (String) request.getParameter("username");
        this.password1 = (String) request.getParameter("password1");
        this.password2 = (String) request.getParameter("password2");
        this.img_captcha = (String) request.getParameter("img_captcha");
        this.sms_captcha = (String) request.getParameter("sms_captcha");
    }

    public boolean clean(){
        if(!cleanTelephone()) return false;
        if(!cleanUsername()) return false;
        if(!cleanPassword(password1)) return false;
        if(!cleanPassword(password2)) return false;
        if(!password1.equals(password2)) {
            message = "两次输入的密码不一致";
            return false;
        }
        if(!cleanImgCaptcha()) return false;
        if(!cleanSMSCaptcha()) return false;
        return true;
    }

    public boolean cleanTelephone(){
        if(telephone == null || telephone.equals("")){
            message = "手机号不能为空";
            return false;
        }

        String pa_telephone = "1[3-9]\\d{9}";
        boolean is_match = Pattern.matches(pa_telephone, telephone);
        if(!is_match) {
            message = "手机号输入有误";
            return false;
        }

        User user = userService.getByTelephone(telephone);
        if(user != null){
            message = "此手机号已注册";
            return false;
        }

        return true;
    }

    public boolean cleanUsername(){
        if(username == null || username.equals("")) {
            message = "用户名不能为空";
            return false;
        }
        if(username.length() < 2) {
            message = "用户名不能小于2位";
            return false;
        }
        if(username.length() > 12) {
            message = "用户名不能大于12位";
            return false;
        }

        User user = userService.getByUsername(username);
        if(user != null) {
            message = "此用户名已经被占用";
            return false;
        }

        return true;
    }

    public boolean cleanImgCaptcha(){
        if(img_captcha == null) {
            message = "图片验证码不能为空";
            return false;
        }
        img_captcha = img_captcha.toLowerCase();

        String session_image_code = (String) this.session.getAttribute(ImageCaptcha.RANDOMCODEKEY);
        if(session_image_code == null) {
            message = "图片验证码已过期";
            return false;
        }
        session_image_code = session_image_code.toLowerCase();
        if(img_captcha.equals(session_image_code) == false) {
            message = "图片验证码输入错误";
            return false;
        }

        return true;
    }

    public boolean cleanSMSCaptcha(){
        Jedis jedis = Redis.JEDIS;
        String redis_sms_captcha = jedis.get(telephone);
        if(redis_sms_captcha == null){
            message = "短信验证码已过时，请重新获取";
            return false;
        }
        if(redis_sms_captcha.equals(sms_captcha) == false){
            message = "短信验证码输入错误";
            return false;
        }
        return true;
    }

    public boolean cleanPassword(String password) {
        if(password == null || password.equals("")) {
            message = "密码不能为空";
            return false;
        }
        if(password.length() < 6) {
            message = "密码长度不能小于6位";
            return false;
        }
        if(password.length() > 16) {
            message = "密码长度不能大于16位";
            return false;
        }
        return true;
    }

    /**
     * 保存用户到数据库
     */
    public Object save() {
        User user = new User();
        user.setId(ShortUUID.generateShortUuid());
        user.setTelephone(telephone);
        user.setUsername(username);
        user.setPassword(MD5.str2MD5(password1));
        user.setDate_joined(new Date());
        user.setIs_active(true);
        user.setIs_author(false);
        user.setIs_staff(false);
        user.setIs_superuser(false);
        userService.register(user);
        return user;
    }
}
