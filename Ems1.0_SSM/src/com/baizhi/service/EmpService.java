package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Employee;
import com.baizhi.entity.User;

public interface EmpService {
	
	public List<Employee> showAll();
	
	public void update(Employee employee);
	
	public void add(Employee employee);
	
	public void delete(Integer id);
}
