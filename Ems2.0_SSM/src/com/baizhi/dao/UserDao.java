package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserDao {
	public void add(User user);
	public User queryOne(@Param("name")String name,@Param("password")String password);
	public List<User> queryAll();
}
