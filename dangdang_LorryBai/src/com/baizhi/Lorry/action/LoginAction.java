package com.baizhi.Lorry.action;

import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;

import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.entity.D_user;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.baizhi.Lorry.service.LoginService;
import com.baizhi.Lorry.service.LoginServiceImpl;
import com.baizhi.Lorry.util.CreateValidateCode;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginAction implements Action{
private String email;
private String password;







public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String execute() throws Exception {
	System.out.println(password+"  "+email);
	String flag=null; 
	ActionContext context = ActionContext.getContext();
	ValueStack vs = context.getValueStack();

	LoginService cs=new LoginServiceImpl();
	D_user user = cs.login(email, password);
	vs.setValue("flag", "loginsuccess");
	if(user==null){
	vs.setValue("#session.", "用户不存在");
	return "false";}else{
		vs.setValue("#session.user",user);
		flag = (String) vs.findValue("flag");
		if(flag==null){return "success";}
		else{return "address";}
	}
}
}
