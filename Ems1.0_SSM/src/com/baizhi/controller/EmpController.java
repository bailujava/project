package com.baizhi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhi.entity.Employee;
import com.baizhi.entity.User;
import com.baizhi.service.EmpService;
import com.baizhi.service.UserService;
import com.baizhi.util.SecurityCode;

@Controller
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/showAll.do")
	public String findAll(ModelMap modelMap) {
		List<Employee> all = empService.showAll();
		modelMap.addAttribute("employees", all);

		return "emplist";
	}

	@RequestMapping("/deleteEmp.do")
	public String deleteEmp(Integer id) {
		empService.delete(id);
		return "redirect:/employee/showAll.do";
	}

	@RequestMapping("/addEmp.do")
	public String addEmp(Employee employee) {
		empService.add(employee);
		return "redirect:/employee/showAll.do";

	}
	
	@RequestMapping("/updateEmp.do")
	public String updateEmp(Employee employee) {
		System.out.println(employee);
		empService.update(employee);
		return "redirect:/employee/showAll.do";

	}
	
}
