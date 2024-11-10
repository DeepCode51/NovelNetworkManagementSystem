package com.ykjzone.controller;

import com.ykjzone.pojo.Group;
import com.ykjzone.pojo.Permission;
import com.ykjzone.pojo.User;
import com.ykjzone.service.GroupService;
import com.ykjzone.service.PermissionService;
import com.ykjzone.service.UserService;
import com.ykjzone.util.ImageCaptcha;
import com.ykjzone.util.MD5;
import com.ykjzone.util.RESTful;
import com.ykjzone.util.Redis;
import com.ykjzone.validate.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping("/xsauth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;
    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        UserValidator userValidator = new UserValidator(request, userService);
        response.setContentType("application/json; charset=UTF-8");
        try {
            if(userValidator.clean()){
                User user = (User) userValidator.save();
                request.getSession().setAttribute("user",user);
                response.getWriter().write(RESTful.ok());
            } else{
                String message = userValidator.getMessage();
                response.getWriter().write(RESTful.params_error(message,null));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(String telephone, String password, String remember, HttpSession session){
        User user = userService.getByTelephoneAndPassword(telephone, MD5.str2MD5(password));
        if(user == null)
            return RESTful.unauth("手机号或密码错误");
        if(user.getIs_active() == false)
            return RESTful.unauth("您的账号被冻结了");
        List<Group> groups = groupService.getByUserId(user.getId());
        user.setGroups(groups);
        List<Permission> permissions = permissionService.getByUserId(user.getId());
        user.setPermissions(permissions);

        session.setAttribute("user", user);
        if("1".equals(remember)) session.setMaxInactiveInterval(60*60*24*7*2);
        else session.setMaxInactiveInterval(0);
        return RESTful.ok();
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }



    @RequestMapping("/img_captcha")
    public void imgCaptcha(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            ImageCaptcha randomValidateCode = new ImageCaptcha();
            randomValidateCode.getRandcode(request, response);//输出验证码图片
        } catch(Exception e){
            e.printStackTrace();
        }
        //从session中取出随机验证码
        System.out.println(request.getSession().getAttribute("RANDOMREDISKEY"));
    }

    @RequestMapping(value = "/sms_captcha", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String SMSCaptcha(String telephone){
        Jedis jedis = Redis.JEDIS;
        // 生成验证码
        String captcha = "";
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            int number = random.nextInt(10);
            captcha += String.valueOf(number);
        }
        // 保存到缓存redis
        jedis.set(telephone, captcha);
        jedis.expire(telephone, 5 * 60);
        // 给手机发送验证码，此步骤省略
        // 返回
        Map<String,Object> data = new HashMap<>();
        data.put("code", captcha);
        return RESTful.result(200,"",data);
    }

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
