package entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
private int id;
private String name;
private double salary;
private String date1;
public Employee(int id, String name, double salary, String date1) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.date1 = date1;
}
public Employee(){}
public int getId() {
	return id;
}
public void setId(int id) {
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
public String getDate() {
	return date1;
}
public void setDate(String date1) {
	this.date1 = date1;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
			+ ", date=" + date1 + "]";
}

}
