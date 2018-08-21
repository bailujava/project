package com.bailu.controller;

import com.bailu.entity.User;
import com.bailu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/loign.do")
    public  String  login(String name, HttpSession session){
        User user = userService.login(name);
        if(user==null)return  "error";
        else {
            session.setAttribute("user",user);
            return  "success";}
    }
    @RequestMapping("/register.do")
    public  String  register(User user){
        userService.register(user);
        return "success";
    }
}
