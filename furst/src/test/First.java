package test;

import java.util.List;

import org.junit.Test;

import service.RegisterService;
import service.RegisterServiceIMPL;
import service.chaServiceIMPL;
import user.User;
import dao.UserDAO;
import dao.UserDAOIMPL;

public class First {
	@Test
	public void testaddUser(){
		User u=new User("张三","123456");
		u.setId(50);
		UserDAO D=new UserDAOIMPL();
		int DS=D.add(u);
		System.out.println(DS);
	}
	@Test
	public  void testRegister(){
		User u=new User("李四","123456");
		 RegisterService D = new RegisterServiceIMPL();
		boolean DS=D.register(u);
		System.out.println(DS);
	}
	@Test
	public void taaa(){
		chaServiceIMPL cs  = new chaServiceIMPL();
		List<User> c = cs.cha();
		for (User user : c) {
			System.out.println(user);
		}
	}
}
