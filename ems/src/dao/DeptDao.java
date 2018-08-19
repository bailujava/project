package dao;

import java.util.List;

import entity.Department;
import entity.Employee;

public interface DeptDao {
	public void add (Department dm);
	public void delete(Integer id);
	public void update(Department dm);
	public Department query(Integer id);
	public List<Department> queryAll();
}
