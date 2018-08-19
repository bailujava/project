package com.baizhi.lorry.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.baizhi.lorry.service.CityImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CityAction extends ActionSupport{
	private String city;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
@Override
	public String execute() throws Exception {
		System.out.println(city);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	CityImpl cityImpl = new CityImpl();
	HashMap<String, List> map = cityImpl.cha();
		List list = map.get(city);
		System.out.println(list);
	Gson gson = new Gson();
	String json = gson.toJson(list);
	out.print(json);
	out.flush();
		return null;
	}
	
}
