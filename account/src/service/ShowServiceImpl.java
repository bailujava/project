package service;

import java.util.List;

import util.MybatisUtil;
import util.TXUtil;
import dao.EmployeeDao;
import entity.Employee;

public class ShowServiceImpl implements ShowService{

	public List<Employee> Query() {
		
		try {
			EmployeeDao dao =(EmployeeDao) MybatisUtil.getMapper(EmployeeDao.class);
			List<Employee> list = dao.queryAll();
			TXUtil.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			TXUtil.rollback();
			throw new RuntimeException("系统繁忙");
		} finally{MybatisUtil.close();}
		
	}

}
