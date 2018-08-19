package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Employee;
import com.baizhi.entity.User;

public interface EmployeeDao {
	public void add(Employee employee);
	public void delete(Integer id);
	public void update(Employee employee);
	public List<Employee> queryAll();
}
