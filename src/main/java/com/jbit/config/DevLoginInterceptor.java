package com.jbit.config;

import com.jbit.pojo.DevUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DevLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DevUser user = (DevUser) request.getSession().getAttribute("devUserSession");
        if (user == null){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}

