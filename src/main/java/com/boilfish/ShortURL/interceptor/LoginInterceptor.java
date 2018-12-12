package com.boilfish.ShortURL.interceptor;


import com.boilfish.ShortURL.model.UserM;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{
        UserM user = (UserM) request.getSession().getAttribute("currUser");
        if(user == null){
            response.sendRedirect("/login");
            return false;
        }else return true;
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
