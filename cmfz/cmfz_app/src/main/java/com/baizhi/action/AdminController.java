package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login.do")
    public String login(String username, String password, HttpSession session, String enCode) {
        String captche = (String) session.getAttribute("captche");
        if (enCode.equalsIgnoreCase(captche)) {
            Admin admin = adminService.login(username, password);
            if (admin != null) {
                session.setAttribute("admin", admin);
                return "redirect:/main/main.jsp";
            } else {
                return "redirect:/main/main.jsp";
            }
        } else {
            return "redirect:/main/main.jsp";
        }
    }

    @RequestMapping("/register.do")
    public String register(Admin admin) {
        adminService.register(admin);
        return "mian/main";
    }
}
