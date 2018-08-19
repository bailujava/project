package com.baizhi.entity;

public class Employee {
	private Integer id;
	private String name;
	private Double Salary;
	private Integer age;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name, Double salary, Integer age) {
		super();
		this.id = id;
		this.name = name;
		Salary = salary;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return Salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Salary=" + Salary
				+ ", age=" + age + "]";
	}

}
