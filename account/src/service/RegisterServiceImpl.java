package service;

import util.MybatisUtil;
import util.TXUtil;
import dao.EmployeeDao;
import entity.Employee;

public class RegisterServiceImpl implements RegisterService{

	@Override
	public void Register(Employee em) {
		try{ EmployeeDao dao = (EmployeeDao)MybatisUtil.getMapper(EmployeeDao.class);
		dao.add(em);
		TXUtil.commit();}
		catch(Exception e){
			e.printStackTrace();
			TXUtil.rollback();
			throw new RuntimeException("serviceError");
			}
		finally{MybatisUtil.close();}
	}

}
