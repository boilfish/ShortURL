package com.boilfish.ShortURL.controller;

import com.boilfish.ShortURL.dao.UrlDAOI;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.service.UrlServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class URLController {

    @Autowired
    private UrlServerI UrlServer;

    @RequestMapping("/")
    public String index(){
        return "/WEB-INF/html/index.html";
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
    public String submit(@RequestBody UrlM url){
        UrlM tempUrl = UrlServer.packUrlM(url.getLongUrl());
        UrlServer.insertUrl(tempUrl);
        return tempUrl.getShortUrl();
    }

    @ResponseBody
    @RequestMapping("/customSubmit")
    public UrlM customSubmit(@RequestBody UrlM url){
        UrlM tempUrl = UrlServer.customPackUrlM(url.getLongUrl(),url.getShortUrl());
        if(tempUrl == null){
            UrlM m = new UrlM();
            m.setId(0);
            return m;
        }else {
            UrlServer.insertUrl(tempUrl);
            return tempUrl;
        }
    }

    @RequestMapping("/404")
    public String notFound() {return "/WEB-INF/html/404.html";}
}
