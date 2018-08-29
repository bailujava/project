package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Admin login(String username, String password) {
        Admin admin = adminDao.queryOne(username, password);
        return admin;
    }

    @Transactional
    public void register(Admin admin) {
        adminDao.add(admin);
    }
}
