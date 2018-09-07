package com.bailu.service;

import com.bailu.dao.UserDao;
import com.bailu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.math.BigInteger;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void login() {
        userDao.queryone();
    }

    @Override
    public void register() {
        String s = new String("123456");
        char salt = s.charAt(0);

        byte[] bytes = DigestUtils.md5Digest((s+salt).getBytes());
        BigInteger bigInteger = new BigInteger(1, bytes);
        String s1 = bigInteger.toString();


        User bailu = new User(50, "bailu", "123456");
        userDao.add(bailu);
    }
}
