package com.baizhi.Lorry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_order;
import com.baizhi.Lorry.entity.D_receivce_address;
import com.baizhi.Lorry.util.Page;

public interface OrderDao {
   public D_order queryCurrval();
   public void add(D_order order);
}
