package com.boilfish.ShortURL.controller;

import com.alibaba.fastjson.JSONObject;
import com.boilfish.ShortURL.service.ManageServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.DataTruncation;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("manage")
@SessionAttributes("currUser")
public class ManageController {
    @Autowired
    private ManageServerI manageServer;

    @RequestMapping("")
    public String index(){ return "/WEB-INF/html/manageindex.html"; }

    @RequestMapping("statistics")
    public String statistics() {return "/WEB-INF/html/statistics.html";}

    @RequestMapping("urlsearch")
    public String urlSearch() {return "/WEB-INF/html/urlsearch.html";}

    @ResponseBody
    @RequestMapping("selectStatistics.do")
    public JSONObject selectStatistics(){

        Map<String,Object> map = manageServer.getStatistics();
        JSONObject object = new JSONObject();
        object.putAll(map);
        return object;
    }

}
