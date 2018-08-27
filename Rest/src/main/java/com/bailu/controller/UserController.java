package com.bailu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class UserController {
    @RequestMapping(value = "/user/60", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("cc", "白露");
        return "main2";
    }

    @RequestMapping(value = "/user/60", method = RequestMethod.DELETE)
    public String login2(Model model) {
        model.addAttribute("cc", "白露");
        return "main2";
    }
}
