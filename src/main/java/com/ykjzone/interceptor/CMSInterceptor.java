package com.ykjzone.interceptor;

import com.ykjzone.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CMSInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            String uri = request.getRequestURI();
            response.sendRedirect("/?next=" + uri);
            return false;
        }
        if(!user.getIs_staff() && !user.getIs_superuser()){
            response.sendRedirect("/novel/");
            return false;
        }
        return true;
    }
}
