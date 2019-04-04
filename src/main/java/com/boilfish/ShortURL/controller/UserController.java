package com.boilfish.ShortURL.controller;

import com.alibaba.fastjson.JSONObject;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


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

    @ResponseBody
    @RequestMapping("selectUrlByUser.do")
    public JSONObject selectUrlByUser(@ModelAttribute("currUser") UserM user, HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page")) ;
        int page2=(page-1)*5;
        int limit = Integer.parseInt(request.getParameter("limit"));
        limit=5;


        List<UrlM> urlList = userServer.selectUrlByUser(user,page2,limit);
        int count = userServer.selectUrlCountByUser(user);
        JSONObject object = new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",urlList);
        return object;
    }

    @RequestMapping("userUrl")
    public String index(){ return "/WEB-INF/html/user.html"; }

    @RequestMapping("deleteOneUrl.do")
    public void delUrlById(@RequestBody UrlM url,@ModelAttribute("currUser") UserM user){
        if(user.getId() == url.getUserId()) {
            userServer.deleteUrlById(url);
        }//校检session中的用户id是否与删除请求的用户id一致，防止恶意串号
    }

    @ResponseBody
    @RequestMapping("manageLogin.do")
    public int ManageLoginCheck(@RequestParam String passwd,ModelMap model){
        if(userServer.ManageLoginAuth(passwd) == 1){
            UserM tempuser = new UserM();
            tempuser.setId(0);
            tempuser.setName("admin");
            model.addAttribute("currUser",tempuser);
            return 1;
        }else return 0;
    }//返回1登录成功，返回0密码错误

}
