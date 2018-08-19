package com.baizhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.EmployeeDao;
import com.baizhi.entity.Employee;
import com.baizhi.entity.User;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Employee> showAll() {
		
		return employeeDao.queryAll();
	}

	@Transactional
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	@Transactional
	public void add(Employee employee) {
		employeeDao.add(employee);
		
	}

	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeDao.delete(id);
	}

}
