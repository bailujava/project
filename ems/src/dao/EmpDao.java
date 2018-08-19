package dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Employee;

public interface EmpDao {
	public void add (@Param("em")Employee em);
	public void delete(Integer id);
	public void update(@Param("em")Employee em);
	public Employee query(String name);
	public List<Employee> queryAll();
}
