package com.baizhi.Lorry.action;


import java.util.List;

import org.apache.struts2.dispatcher.ActionContextCleanUp;

import com.baizhi.Lorry.entity.D_receivce_address;
import com.baizhi.Lorry.entity.D_user;
import com.baizhi.Lorry.service.AddressService;
import com.baizhi.Lorry.service.AddressServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;


public class Address2Action implements Action{
private Integer id;
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

private	D_receivce_address DA;

public D_receivce_address getDA() {
	return DA;
}

public void setDA(D_receivce_address dA) {
	DA = dA;
}

@Override
public String execute() throws Exception {

	//调用按ID地址查询
	System.out.println(id+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	AddressService AS=new AddressServiceImpl();
	DA= AS.queryAddress(id);
	//跳转到address_form.jsp
	return "success";
}
}
