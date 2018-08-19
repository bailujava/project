package com.baizhi.entity;

public class Employee {
	private Integer id;
	private String name;
	private Double Salary;
	private Integer age;
	private String department_name;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getDepartment_name() {
		return department_name;
	}


	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}


	public Employee(Integer id, String name, Double salary, Integer age,
			String department_name) {
		super();
		this.id = id;
		this.name = name;
		Salary = salary;
		this.age = age;
		this.department_name = department_name;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Salary=" + Salary
				+ ", age=" + age + ", department_name=" + department_name + "]";
	}


}
