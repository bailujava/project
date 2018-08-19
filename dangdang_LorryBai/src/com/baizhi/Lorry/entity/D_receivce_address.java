package com.baizhi.Lorry.entity;

public class D_receivce_address {
private Integer id;
private Integer user_id;
private String receive_name;
private String full_address;
private String post_code;
private String mobile;
private String phone;
public D_receivce_address(){}
public D_receivce_address(Integer id, Integer user_id, String receive_name,
		String full_address, String post_code, String mobile, String phone) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.receive_name = receive_name;
	this.full_address = full_address;
	this.post_code = post_code;
	this.mobile = mobile;
	this.phone = phone;
}
public Integer getId() {
	return id;
}
public Integer getUser_id() {
	return user_id;
}
public String getReceive_name() {
	return receive_name;
}
public String getFull_address() {
	return full_address;
}
public String getPost_code() {
	return post_code;
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
public void setReceive_name(String receive_name) {
	this.receive_name = receive_name;
}
public void setFull_address(String full_address) {
	this.full_address = full_address;
}
public void setPost_code(String post_code) {
	this.post_code = post_code;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "D_receivce_address [id=" + id + ", user_id=" + user_id
			+ ", receive_name=" + receive_name + ", full_address="
			+ full_address + ", post_code=" + post_code + ", mobile=" + mobile
			+ ", phone=" + phone + "]";
}

}
