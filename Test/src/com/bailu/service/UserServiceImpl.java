package com.bailu.service;

import com.bailu.dao.UserDao;
import com.bailu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(String name) {
        User user = userDao.query(name);
        return user;
    }

   @Transactional
    public void register(User user) {

        userDao.add(user);
    }
}
