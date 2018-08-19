package com.baizhi.lorry.service;

import java.util.List;

import com.baizhi.lorry.dao.UserDao;
import com.baizhi.lorry.entity.User;
import com.baizhi.util.MyBatisUtil;

public class QueryAllServiceImpl implements QueryAllService{

	@Override
	public List<User> cha() {
		UserDao UD = (UserDao) MyBatisUtil.getMapper(UserDao.class);
		List<User> all = UD.queryAll();
		return all;
	}

}
