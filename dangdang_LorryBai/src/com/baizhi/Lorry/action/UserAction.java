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

public class UserAction implements Action{


public String execute() throws Exception {
	ActionContext context = ActionContext.getContext();
	ValueStack vs = context.getValueStack();
	CreateValidateCode cvc = new CreateValidateCode();
	String code = cvc.getCode();
	vs.setValue("#session.code", code);
	HttpServletResponse response = ServletActionContext.getResponse();
	cvc.write(response.getOutputStream());
	
	return null;

	}
}
