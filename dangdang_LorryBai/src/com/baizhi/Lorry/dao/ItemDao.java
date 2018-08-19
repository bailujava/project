package com.baizhi.Lorry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.Lorry.entity.CartItemBO;
import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.util.Page;

public interface ItemDao {
   public void addItem(@Param("item") CartItemBO item,@Param("order_id")Integer order_id);
}
