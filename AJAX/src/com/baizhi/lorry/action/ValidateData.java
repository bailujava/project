package com.baizhi.lorry.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.lorry.entity.User;
import com.baizhi.lorry.service.QueryAllService;
import com.baizhi.lorry.service.QueryAllServiceImpl;
import com.baizhi.lorry.service.QueryUserServiceImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class ValidateData extends ActionSupport {
	private String name;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String cha() throws Exception {
		System.out.println(name);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	
	//执行查询姓名服务
	/*QueryAllService QS = new QueryAllServiceImpl();*/
	/*List<User> list = QS.cha();*/
	//Boolean queryName = queryUser.queryName(name);
	QueryUserServiceImpl queryUser= new QueryUserServiceImpl();
	User user = queryUser.queryName(name);

	Gson gson = new Gson();
	String json = gson.toJson(user);
/*	if(A){String result="可以使用的用户名";
		out.print(result);
	
	}
	else{
		String result="重复的用户名";
		out.print(result);
	
	}*/
	out.print(json);
	out.flush();
	return null;}
	
}
