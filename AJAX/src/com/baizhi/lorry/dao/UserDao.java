package com.baizhi.lorry.dao;

import java.util.List;

import com.baizhi.lorry.entity.User;

public interface UserDao {
public User queryByName(String name);
public List<User> queryAll();
}
