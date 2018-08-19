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


public class AddressAction implements Action{
private	List<D_receivce_address> address;

public List<D_receivce_address> getAddress() {
	return address;
}

public void setAddress(List<D_receivce_address> address) {
	this.address = address;
}

@Override
public String execute() throws Exception {

	//调用按用户ID地址查询
	ValueStack vs = ActionContext.getContext().getValueStack();
	D_user user=(D_user) vs.findValue("#session.user");
	System.out.println(user.getId());
	AddressService AS=new AddressServiceImpl();
	address = AS.queryAddressById(user.getId());
	
	//跳转到address_form.jsp
	System.out.println(address);
	return "success";
}
}
