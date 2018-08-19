package com.baizhi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhi.entity.User;
import com.baizhi.service.EmpService;
import com.baizhi.service.UserService;
import com.baizhi.util.SecurityCode;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/findAll.do")
	public String findAll(ModelMap modelMap) {
		List<User> users = userService.findAll();
		modelMap.addAttribute("users", users);

		return "list";
	}

	@RequestMapping("/login.do")
	public String login(String name, String password, HttpSession session) {
		System.out.println(name+password);
		User user2 = userService.Login(name, password);
		if (user2 != null) {
			session.setAttribute("flag", "ok");
			return "redirect:/employee/showAll.do";
		} else {
			return "login";
		}

	}

	@RequestMapping("/register.do")
	public String register(String number,User user,HttpSession session) {
		String captche = (String) session.getAttribute("captche");
		if(number.equalsIgnoreCase(captche)){
		userService.register(user);
		return "redirect:/employee/showAll.do";
		}else {
			return "regist";
		}
		
	}
}
