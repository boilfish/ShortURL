package com.boilfish.ShortURL.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{
        String username = (String) request.getSession().getAttribute("username");
        if(username == null){
           // System.out.println("sessionusername=null");
            return true;
        }else System.out.println(username);
        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception{

    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception modelAndView) throws Exception{

    }
}
