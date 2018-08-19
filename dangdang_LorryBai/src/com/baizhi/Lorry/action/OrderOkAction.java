package com.baizhi.Lorry.action;

import java.util.HashMap;

import com.baizhi.Lorry.entity.CartItemBO;
import com.baizhi.Lorry.entity.D_order;
import com.baizhi.Lorry.entity.D_receivce_address;
import com.baizhi.Lorry.entity.D_user;
import com.baizhi.Lorry.service.AddItemService;
import com.baizhi.Lorry.service.AddItemServiceImpl;
import com.baizhi.Lorry.service.AddressService;
import com.baizhi.Lorry.service.AddressServiceImpl;
import com.baizhi.Lorry.service.CreatOrderService;
import com.baizhi.Lorry.service.CreatOrderServiceImpl;
import com.baizhi.Lorry.service.QueryOrderService;
import com.baizhi.Lorry.service.QueryOrderServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class OrderOkAction implements Action{
private D_receivce_address address;
private D_order order2;

public D_order getOrder2() {
	return order2;
}

public void setOrder2(D_order order2) {
	this.order2 = order2;
}

public D_receivce_address getAddress() {
	return address;
}

public void setAddress(D_receivce_address address) {
	this.address = address;
}

@Override
public String execute() throws Exception {
	//获取地址信息
	//调用增加地址信息service
	 System.out.println(address);

	ValueStack vs = ActionContext.getContext().getValueStack();
	D_user user=(D_user) vs.findValue("#session.user");
	address.setUser_id(user.getId());
	AddressService AS = new AddressServiceImpl();
	AS.addAddress(address);
	//调用增加订单service
	D_order order = new D_order();
	order.setUser_id(user.getId());	

	//获取书籍ID,价格,数量,总价,Items封装
	HashMap<String, CartItemBO> shop = (HashMap<String, CartItemBO>) vs.findValue("#session.cart.shop");

	Double total_price = null;
	for (CartItemBO item : shop.values()) {
		total_price+=item.getCount()+item.getBook().getDd_price();
	}
	order.setTotal_price(total_price);
	order.setReceive_name(address.getReceive_name());
	order.setFull_address(address.getFull_address());
	order.setPostal_code(address.getPost_code());
	order.setMobile(address.getMobile());
	order.setPhone(address.getPhone());
	CreatOrderService COS = new CreatOrderServiceImpl();
	COS.creatOrder(order);
	//调用订单查询刚生成的订单号用序列名.currval或select max(id)from table
	QueryOrderService QOS = new QueryOrderServiceImpl();
	order2 = QOS.queryOrder();
	 System.out.println(order2);
	Integer id = order2.getId();
	AddItemService ADS=new AddItemServiceImpl();
	 for (CartItemBO item : shop.values()) {
		item.setOrder_id(id);
		 ADS.addItem(item,id);}

	return "success";
}
}
