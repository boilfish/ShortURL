package com.boilfish.ShortURL.controller;

import com.boilfish.ShortURL.service.ManageServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("manage")
@SessionAttributes("currUser")
public class ManageController {
    @Autowired
    private ManageServerI manageServer;

    @RequestMapping("")
    public String index(){ return "/WEB-INF/html/manageindex.html"; }
}
