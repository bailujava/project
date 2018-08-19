package com.baizhi.Lorry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_receivce_address;
import com.baizhi.Lorry.util.Page;

public interface AddressDao {
   public List<D_receivce_address> query(Integer user_id);
   public void add(D_receivce_address address);
   public D_receivce_address queryone(Integer id);
}
