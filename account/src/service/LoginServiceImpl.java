package service;

import util.MybatisUtil;
import util.TXUtil;
import dao.EmployeeDao;
import entity.Employee;

public class LoginServiceImpl  implements LoginService{

	public void Login(Integer id) {
		try{
			EmployeeDao dao=(EmployeeDao)MybatisUtil.getMapper(EmployeeDao.class);
			Employee employee = dao.query(id);
		TXUtil.commit();	
		if(employee==null){throw new RuntimeException("账号不存在");}}
		catch(Exception e){
			e.printStackTrace();
			TXUtil.rollback();
			throw new RuntimeException("查询失败");}
		finally{MybatisUtil.close();}

	}

}
