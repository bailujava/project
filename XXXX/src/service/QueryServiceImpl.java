package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class QueryServiceImpl implements QueryService{
	@Autowired
	private UserDao userDao;
	@Override
	public List<User> queryAll() {
		List<User> list = userDao.queryAll();
		return list;
	}




}
