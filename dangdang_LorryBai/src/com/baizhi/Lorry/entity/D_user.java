package com.baizhi.Lorry.entity;

import java.io.Serializable;
import java.util.List;

public class D_user implements Serializable{
private  Integer id;
private String email;
private String nickname;
private String password;
private Integer user_numberegral;
private String is_email_verify;
private String email_verify_code;
private Integer last_login_time;
private String last_login_ip;
public D_user() {
	super();
	// TODO Auto-generated constructor stub
}
public D_user(Integer id, String email, String nickname, String password,
		Integer user_numberegral, String is_email_verify,
		String email_verify_code, Integer last_login_time, String last_login_ip) {
	super();
	this.id = id;
	this.email = email;
	this.nickname = nickname;
	this.password = password;
	this.user_numberegral = user_numberegral;
	this.is_email_verify = is_email_verify;
	this.email_verify_code = email_verify_code;
	this.last_login_time = last_login_time;
	this.last_login_ip = last_login_ip;
}
public Integer getId() {
	return id;
}
public String getEmail() {
	return email;
}
public String getNickname() {
	return nickname;
}
public String getPassword() {
	return password;
}
public Integer getUser_numberegral() {
	return user_numberegral;
}
public String getIs_email_verify() {
	return is_email_verify;
}
public String getEmail_verify_code() {
	return email_verify_code;
}
public Integer getLast_login_time() {
	return last_login_time;
}
public String getLast_login_ip() {
	return last_login_ip;
}
public void setId(Integer id) {
	this.id = id;
}
public void setEmail(String email) {
	this.email = email;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public void setPassword(String password) {
	this.password = password;
}
public void setUser_numberegral(Integer user_numberegral) {
	this.user_numberegral = user_numberegral;
}
public void setIs_email_verify(String is_email_verify) {
	this.is_email_verify = is_email_verify;
}
public void setEmail_verify_code(String email_verify_code) {
	this.email_verify_code = email_verify_code;
}
public void setLast_login_time(Integer last_login_time) {
	this.last_login_time = last_login_time;
}
public void setLast_login_ip(String last_login_ip) {
	this.last_login_ip = last_login_ip;
}
@Override
public String toString() {
	return "D_user [id=" + id + ", email=" + email + ", nickname=" + nickname
			+ ", password=" + password + ", user_numberegral="
			+ user_numberegral + ", is_email_verify=" + is_email_verify
			+ ", email_verify_code=" + email_verify_code + ", last_login_time="
			+ last_login_time + ", last_login_ip=" + last_login_ip + "]";
}

}
