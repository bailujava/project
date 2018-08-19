package com.baizhi.Lorry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.entity.D_user;

public interface UserDao {
   public D_user query(@Param("email")String email,@Param("password")String password);
   public List<D_user> queryAll();
   public void add(D_user user);
   public void delete(Integer ID);
   public void update(D_user user);
   

}
