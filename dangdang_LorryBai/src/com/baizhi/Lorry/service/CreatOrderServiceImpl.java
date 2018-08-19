package com.baizhi.Lorry.service;

import com.baizhi.Lorry.dao.OrderDao;
import com.baizhi.Lorry.entity.D_order;
import com.baizhi.Lorry.util.MybatisUtil;

public class CreatOrderServiceImpl implements CreatOrderService{

	@Override
	public void creatOrder(D_order order) {
		OrderDao OD = (OrderDao) MybatisUtil.getMapper(OrderDao.class);
		OD.add(order);
		MybatisUtil.close();
		
	}

}
