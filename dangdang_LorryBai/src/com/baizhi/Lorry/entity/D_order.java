package com.baizhi.Lorry.entity;

import java.util.Date;
import java.util.Random;

public class D_order {
private Integer id;
private Integer user_id;
private Date order_time;
private String order_desc;
private Double 	total_price;
private String 	receive_name;
private String 	full_address;
private String 	postal_code;
private String 	mobile;
private String 	phone;
public D_order(){}

public D_order(Integer id, Integer user_id, Date order_time, String order_desc,
		Double total_price, String receive_name, String full_address,
		String postal_code, String mobile, String phone) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.order_time = order_time;
	this.order_desc = order_desc;
	this.total_price = total_price;
	this.receive_name = receive_name;
	this.full_address = full_address;
	this.postal_code = postal_code;
	this.mobile = mobile;
	this.phone = phone;
}

public Integer getId() {
	return id;
}
public Integer getUser_id() {
	return user_id;
}
public Date getOrder_time() {
	return order_time;
}
public String getOrder_desc() {
	return order_desc;
}
public Double getTotal_price() {
	return total_price;
}
public String getReceive_name() {
	return receive_name;
}
public String getFull_address() {
	return full_address;
}
public String getPostal_code() {
	return postal_code;
}
public String getMobile() {
	return mobile;
}
public String getPhone() {
	return phone;
}
public void setId(Integer id) {
	this.id = id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public void setOrder_time(Date order_time) {
	this.order_time = order_time;
}
public void setOrder_desc(String order_desc) {
	this.order_desc = order_desc;
}
public void setTotal_price(Double total_price) {
	this.total_price = total_price;
}
public void setReceive_name(String receive_name) {
	this.receive_name = receive_name;
}
public void setFull_address(String full_address) {
	this.full_address = full_address;
}
public void setPostal_code(String postal_code) {
	this.postal_code = postal_code;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public void setPhone(String phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "D_order [id=" + id + ", user_id=" + user_id + ", order_time="
			+ order_time + ", order_desc=" + order_desc + ", total_price="
			+ total_price + ", receive_name=" + receive_name
			+ ", full_address=" + full_address + ", postal_code=" + postal_code
			+ ", mobile=" + mobile + ", phone=" + phone + "]";
}


}
