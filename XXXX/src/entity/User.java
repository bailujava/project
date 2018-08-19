package entity;

import java.io.Serializable;

public class User implements Serializable{
private Integer id;	
private String account;
private String password;
private String number;
public User(){}
public User(Integer id, String account, String password, String number) {
	super();
	this.id = id;
	this.account = account;
	this.password = password;
	this.number = number;
}
public Integer getId() {
	return id;
}
public String getAccount() {
	return account;
}
public String getPassword() {
	return password;
}
public String getNumber() {
	return number;
}
public void setId(Integer id) {
	this.id = id;
}
public void setAccount(String account) {
	this.account = account;
}
public void setPassword(String password) {
	this.password = password;
}
public void setNumber(String number) {
	this.number = number;
}
@Override
public String toString() {
	return "User [id=" + id + ", account=" + account + ", password=" + password
			+ ", number=" + number + "]";
}

}