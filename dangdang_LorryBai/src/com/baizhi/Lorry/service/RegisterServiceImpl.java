package com.baizhi.Lorry.service;


import com.baizhi.Lorry.dao.UserDao;
import com.baizhi.Lorry.entity.D_user;
import com.baizhi.Lorry.util.MybatisUtil;
import com.baizhi.Lorry.util.TXUtil;


public class RegisterServiceImpl implements RegisterService{


	public String register(D_user user) {
	try {
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		D_user u = dao.query(user.getEmail(),user.getPassword());
		if(u==null){
		user.setEmail(user.getEmail());
		user.setNickname(user.getNickname());
		user.setPassword(user.getPassword());
		dao.add(user);
		TXUtil.commit();}
		return null;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		TXUtil.rollback();
		return "账户已存在";
	}finally{MybatisUtil.close();}
	
	}



}
