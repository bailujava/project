package com.baizhi.Lorry.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.crypto.dsig.DigestMethod;

import com.baizhi.Lorry.dao.CategoryDao;
import com.baizhi.Lorry.dao.UserDao;

import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.entity.D_user;
import com.baizhi.Lorry.util.MybatisUtil;
import com.baizhi.Lorry.util.TXUtil;
import com.sun.mail.smtp.DigestMD5;

public class LoginServiceImpl implements LoginService{
	@Override
	public D_user login(String email,String password) {
		UserDao UD = (UserDao) MybatisUtil.getMapper(UserDao.class);

		D_user user = UD.query(email,password);
		if(user==null){return null;}
		else{
			if(user.getPassword().equals(password) ){return user;}
			else{return null;}
			
		}
		

	}
}

