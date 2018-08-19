package entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
private Integer id;
private String name;
private double salary;
private Date hireDate;
private Department dept;
public Employee(){}

public Employee(Integer id, String name, double salary, Date hireDate,
		Department depm) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.hireDate = hireDate;
	this.dept = depm;
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
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public Date getHireDate() {
	return hireDate;
}
public void setHireDate(Date hireDate) {
	this.hireDate = hireDate;
}

public Department getDepm() {
	return dept;
}

public void setDepm(Department depm) {
	this.dept = depm;
}

}
