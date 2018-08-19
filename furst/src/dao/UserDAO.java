package dao;

import java.util.List;

import user.User;

public interface UserDAO {
	//查询
	public User query(User user);
	//增加
	public int add(User user);
	
	//查询所有
	public List<User> queryAll();
	
	//修改
	public void update(String account,String password);

}
