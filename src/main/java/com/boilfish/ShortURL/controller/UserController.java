package com.boilfish.ShortURL.controller;

import com.boilfish.ShortURL.dao.UserDAOI;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;
import com.boilfish.ShortURL.service.UserServerI;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
@RequestMapping("user")
@SessionAttributes("currUser")
public class UserController {

    @Autowired
    private UserServerI userServer;

    @ResponseBody
    @RequestMapping("login.do")
    public int loginAction(@RequestBody UserM user,ModelMap model){
        if(user.getName() == null){
            return 2;
        }
        HashMap map =userServer.loginAuth(user);
        int i =(int) map.get("authStateCode");
        user=(UserM) map.get("currUser");
        //返回1成功，2用户名不存在，3密码错误


        if(i==1){
            model.addAttribute("currUser",user);
        }
        return i;
    }

    //return1成功，2用户名已存在，3未知错误，
    @ResponseBody
    @RequestMapping("register.do")
    public int registerAction(@RequestBody UserM user,ModelMap model){
        int i = userServer.registerCheckUser(user.getName());
        if(user.getName() == null){
            return 3;
        }else
        if(i == 1){
            userServer.registUser(user);
            model.addAttribute("currUser",user);
            return 1;
        }else if(i == 0) return 2;
        return i;
    }

}
