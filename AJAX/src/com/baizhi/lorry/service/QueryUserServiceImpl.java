package com.baizhi.lorry.service;

import com.baizhi.lorry.dao.UserDao;
import com.baizhi.lorry.entity.User;
import com.baizhi.lorry.util.MybatisUtil;
import com.baizhi.util.MyBatisUtil;

public class QueryUserServiceImpl implements QueryUserService {

	public User queryName(String name) {
		UserDao UD = (UserDao) MyBatisUtil.getMapper(UserDao.class);
		User user = UD.queryByName(name);
		System.out.println(user);
		MybatisUtil.close();
		return user;
		
	}

}
