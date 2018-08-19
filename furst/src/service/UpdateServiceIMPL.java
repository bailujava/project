package service;

import util.TXUtil;
import dao.UserDAO;
import dao.UserDAOIMPL;

public class UpdateServiceIMPL implements UpdateService{

	public void update(String account, String password) {
		try {
			TXUtil.start();
			UserDAO UD = new UserDAOIMPL();
			UD.update(account, password);
			TXUtil.getCommit();
		} catch (Exception e) {
			e.printStackTrace();
			TXUtil.getRollback();
		}finally{TXUtil.close();}
	}

}
