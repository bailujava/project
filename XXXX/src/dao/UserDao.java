package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.User;

public interface UserDao {
	public void add(User user);
	public void delete(List<Integer> list);
	public void update(User user);
	public User queryByName(String account);
	public User queryOne(@Param("account")String account,@Param("password")String password);
	public List<User> queryAll();
}
