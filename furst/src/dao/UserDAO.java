package dao;

import java.util.List;

import user.User;

public interface UserDAO {
	//��ѯ
	public User query(User user);
	//����
	public int add(User user);
	
	//��ѯ����
	public List<User> queryAll();
	
	//�޸�
	public void update(String account,String password);

}
