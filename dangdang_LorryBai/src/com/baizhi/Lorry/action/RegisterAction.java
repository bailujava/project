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
import com.baizhi.Lorry.service.RegisterService;
import com.baizhi.Lorry.service.RegisterServiceImpl;
import com.baizhi.Lorry.util.CreateValidateCode;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class RegisterAction implements Action{
private D_user user;
private String VerifyCode;

public D_user getUser() {
	return user;
}


public void setUser(D_user user) {
	this.user = user;
}

public String getVerifyCode() {
	return VerifyCode;
}


public void setVerifyCode(String verifyCode) {
	VerifyCode = verifyCode;
}
public String execute() throws Exception {
	System.out.println(VerifyCode);
	ActionContext context = ActionContext.getContext();
	ValueStack vs = context.getValueStack();
  String code = vs.findString("#session.code");
	if(VerifyCode.equalsIgnoreCase(code)){	
	RegisterService cs=new RegisterServiceImpl();
	String ss = cs.register(user);
	System.out.println(ss);
	vs.setValue("#session.user",user);
	return "success";
	}
	return "false";
	

	}
}
