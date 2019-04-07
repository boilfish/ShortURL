package com.boilfish.ShortURL.controller;

import com.alibaba.fastjson.JSONObject;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;
import com.boilfish.ShortURL.service.ManageServerI;
import com.boilfish.ShortURL.service.UserServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.DataTruncation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manage")
@SessionAttributes("currUser")
public class ManageController {
    @Autowired
    private ManageServerI manageServer;

    @Autowired
    private UserServerI userServer;

    @RequestMapping("")
    public String index(){ return "/WEB-INF/html/manageindex.html"; }

    @RequestMapping("statistics")
    public String statistics() {return "/WEB-INF/html/statistics.html";}

    @RequestMapping("urlsearch")
    public String urlSearch() {return "/WEB-INF/html/urlsearch.html";}

    @RequestMapping("manageurl")
    public String manageUrl() {return "/WEB-INF/html/manageurl.html";}

    @ResponseBody
    @RequestMapping("selectStatistics.do")
    public JSONObject selectStatistics(){

        Map<String,Object> map = manageServer.getStatistics();
        JSONObject object = new JSONObject();
        object.putAll(map);
        return object;
    }

    @ResponseBody
    @RequestMapping("selectUrlByLongUrl.do")
    public JSONObject selectUrlByLongUrl (HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page")) ;
        int page2=(page-1)*5;
        int limit = Integer.parseInt(request.getParameter("limit"));
        limit=5;

        String longUrl = request.getParameter("longUrl");
        Map<String,Object> map = manageServer.selectUrlByLongURL(longUrl,page2,limit);
        int count = (int)map.get("count");
        //List<UrlM> list = (List<UrlM>)map.get("urlList"); fastjson非常智能，直接怼object即可
        JSONObject object = new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",map.get("urlList"));
        return object;
    }

    @ResponseBody
    @RequestMapping("selectUrlByShortUrl.do")
    public JSONObject selectUrlByShortUrl (HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page")) ;
        int page2=(page-1)*5;
        int limit = Integer.parseInt(request.getParameter("limit"));
        limit=5;

        String shortUrl = request.getParameter("shortUrl");
        Map<String,Object> map = manageServer.selectUrlByShortURL(shortUrl,page2,limit);
        int count = (int)map.get("count");
        //List<UrlM> list = (List<UrlM>)map.get("urlList"); fastjson非常智能，直接怼object即可
        JSONObject object = new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",map.get("urlList"));
        return object;
    }

    @RequestMapping("adminDeleteOneUrl.do")
    @ResponseStatus(HttpStatus.OK)
    public void delUrlById(@RequestBody UrlM url){
            userServer.deleteUrlById(url);
    }

}
