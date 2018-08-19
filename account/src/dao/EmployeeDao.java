package dao;

import java.util.Date;
import java.util.List;

import entity.Employee;

public interface EmployeeDao {
	public void add (Employee em);
	public void delete(Integer id);
	public void update(String name,double salary ,Date date,Integer id);
	public Employee query(Integer id);
	public List<Employee> queryAll();
	
}
