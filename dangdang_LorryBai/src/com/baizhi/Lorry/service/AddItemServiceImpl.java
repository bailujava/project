package com.baizhi.Lorry.service;

import com.baizhi.Lorry.dao.ItemDao;
import com.baizhi.Lorry.entity.CartItemBO;
import com.baizhi.Lorry.util.MybatisUtil;

public class AddItemServiceImpl implements AddItemService{

	@Override
	public void addItem(CartItemBO item,Integer id) {
		ItemDao IT= (ItemDao) MybatisUtil.getMapper(ItemDao.class);
		IT.addItem(item,id);
		MybatisUtil.close();
		
	}

}
