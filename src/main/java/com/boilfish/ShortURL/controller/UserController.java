package com.boilfish.ShortURL.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(){
        //session.setAttribute("username",username);
        return "redirect:/";
    }
}
