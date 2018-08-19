package service;


import user.User;
import util.TXUtil;
import dao.UserDAO;
import dao.UserDAOIMPL;

public class RegisterServiceIMPL implements RegisterService{
	public boolean register(User user) {
		try {
			TXUtil.start();	
			UserDAO UD=new UserDAOIMPL();
			UD.add(user);
			TXUtil.getCommit();  return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TXUtil.getRollback(); return false;
		}
		finally{TXUtil.close();}
	}
}
