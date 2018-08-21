package com.bailu.dao;

import com.bailu.entity.User;

public interface UserDao {
    public  void add(User user);

    public  User query (String name);
}
