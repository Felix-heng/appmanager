package com.jbit.config;

import com.jbit.pojo.BackendUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BackendUser user = (BackendUser) request.getSession().getAttribute("userSession");
        if (user == null){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
