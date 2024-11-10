package com.ykjzone.interceptor;

import com.ykjzone.pojo.User;
import com.ykjzone.util.RESTful;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 * 登录之后才能访问
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        // 判断用户是否登录
        if(user == null){
            // 判断是否为ajax请求
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                //ajax请求
                response.setContentType("application/json");
                response.getWriter().print(RESTful.unauth("请先登录"));
                return false;
            }else{
                //非ajax请求
                StringBuilder sb = new StringBuilder();
                String path = request.getRequestURI();
                String queryString = request.getQueryString();
                if(path != null){
                    sb.append(path);
                    if(queryString != null){
                        sb.append("?");
                        sb.append(queryString);
                    }
                }
                response.sendRedirect("/?next=" + sb.toString());
            }
            return false;
        }
        return true;
    }
}
