package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	private UserDao userDao;

	@Override
	public void modifyRegister(User user) {

	userDao.add(user);
	}

}
