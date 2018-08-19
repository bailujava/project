package service;

import java.util.List;

import org.junit.Test;

import user.User;
import dao.UserDAO;
import dao.UserDAOIMPL;

public class chaServiceIMPL implements chaService{
	
	public List<User> cha() {
		UserDAO UD=new UserDAOIMPL();
		return UD.queryAll();
	}

	
}
