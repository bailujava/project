package com.baizhi.Lorry.entity;

import java.io.Serializable;
import java.util.List;

public class D_sort implements Serializable{
private  Integer id;
private String name;
private Integer count;
private Integer pid;
private List<D_sort> sorts;
public D_sort(){}

public D_sort(Integer id, String name, Integer count, Integer pid,
		List<D_sort> sorts) {
	super();
	this.id = id;
	this.name = name;
	this.count = count;
	this.pid = pid;
	this.sorts = sorts;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}

public List<D_sort> getSorts() {
	return sorts;
}

public void setSorts(List<D_sort> sorts) {
	this.sorts = sorts;
}

@Override
public String toString() {
	return "D_sort [id=" + id + ", name=" + name + ", count=" + count
			+ ", pid=" + pid + ", sorts=" + sorts + "]";
}



}
