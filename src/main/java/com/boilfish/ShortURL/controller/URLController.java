package com.boilfish.ShortURL.controller;

import com.boilfish.ShortURL.dao.UrlDAOI;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;
import com.boilfish.ShortURL.service.UrlServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
//@SessionAttributes("currUser")
public class URLController {

    @Autowired
    private UrlServerI UrlServer;

    @RequestMapping("/")
    public String index(){ return "/WEB-INF/html/index.html"; }

    @ResponseBody
    @RequestMapping("/checkUser.do")
    //@ModelAttribute("currUser") UserM user
    public Map<String,Object> checkUser(HttpSession session){
        UserM user=(UserM) session.getAttribute("currUser");
        Map<String,Object> map = new HashMap<String, Object>();
        if(user != null) //System.out.println("未登录");
         {
            map.put("username", user.getName());
            map.put("userid", new Integer(user.getId()));
//        if(username != null ) {
//            map.put("username", username);
//            map.put("userid", userid);
//
        }
        return map;
    }

    @RequestMapping("/{code}")
    public RedirectView redirect(@PathVariable String code){

        String temp = UrlServer.searchLongUrl(code);

        if(temp == null){
            RedirectView redirectView = new RedirectView("/404");
            redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            return redirectView;
        }else {
            RedirectView redirectView = new RedirectView(temp);
            redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            return redirectView;
        }
    }

    @ResponseBody
    @RequestMapping("/submit")
    public String submit(@RequestBody UrlM url,HttpSession session){
        UrlM tempUrl = UrlServer.packUrlM(url.getLongUrl(),session);
        UrlServer.insertUrl(tempUrl);
        return tempUrl.getShortUrl();
    }

    @ResponseBody
    @RequestMapping("/customSubmit")
    public UrlM customSubmit(@RequestBody UrlM url,HttpSession session){
        UrlM tempUrl = UrlServer.customPackUrlM(url.getLongUrl(),url.getShortUrl(),session);
        if(tempUrl == null){
            UrlM m = new UrlM();
            m.setId(1);//返回用户id为1时即认定短链接重复，返回id为0时未登录
            return m;
        }else {
            UrlServer.insertUrl(tempUrl);
            return tempUrl;
        }
    }

    @RequestMapping("/404")
    public String notFound() {return "/WEB-INF/html/404.html";}

    @RequestMapping("/login")
    public String login(String username, String password){
        return "WEB-INF/html/login.html";

        //check

//        int id=2333;
//        // HttpSession session, int username, String password
//        ModelAndView mav = new ModelAndView("redirect:/");
//        mav.addObject("username",username);
//        mav.addObject("userid",id);
//        //session.setAttribute("username",username);
//        return mav;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("currUser");
        return "redirect:/";
    }
}
