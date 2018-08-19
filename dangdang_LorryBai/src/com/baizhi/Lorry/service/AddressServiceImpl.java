package com.baizhi.Lorry.service;

import java.util.List;

import com.baizhi.Lorry.dao.AddressDao;
import com.baizhi.Lorry.entity.D_receivce_address;
import com.baizhi.Lorry.util.MybatisUtil;

public class AddressServiceImpl implements AddressService{

	@Override
	public List<D_receivce_address> queryAddressById(Integer user_id) {
		AddressDao	AD=(AddressDao) MybatisUtil.getMapper(AddressDao.class);
		List<D_receivce_address> address = AD.query(user_id);
		return address;
	}

	@Override
	public void addAddress(D_receivce_address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public D_receivce_address queryAddress(Integer id) {
		AddressDao	AD=(AddressDao) MybatisUtil.getMapper(AddressDao.class);
		D_receivce_address address = AD.queryone(id);
		return address;
	}

}
