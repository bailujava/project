package com.baizhi.Lorry.service;

import com.baizhi.Lorry.dao.OrderDao;
import com.baizhi.Lorry.entity.D_order;
import com.baizhi.Lorry.util.MybatisUtil;

public class QueryOrderServiceImpl implements QueryOrderService{

	@Override
	public D_order queryOrder() {
		OrderDao OD = (OrderDao) MybatisUtil.getMapper(OrderDao.class);
		D_order order = OD.queryCurrval();
		return order;
	}


}
