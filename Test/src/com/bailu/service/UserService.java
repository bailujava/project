package com.bailu.service;

import com.bailu.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User login(String name);

    public  void  register(User user);
}
