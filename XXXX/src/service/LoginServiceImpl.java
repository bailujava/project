package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
@Autowired
private UserDao userDao;

@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public boolean login(String account,String password) {
	User u = userDao.queryOne(account, password);
	if(u==null){return false;}
	else {return true;}
}




}
