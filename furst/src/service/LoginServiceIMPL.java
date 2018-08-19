package service;


import user.User;
import dao.UserDAO;
import dao.UserDAOIMPL;

public class LoginServiceIMPL implements LoginService{

	public boolean login(User user) {
		UserDAO UD=new UserDAOIMPL();
		User u=UD.query(user);
		if(u!=null){return true;}
		return false;
	}

	

	

}
