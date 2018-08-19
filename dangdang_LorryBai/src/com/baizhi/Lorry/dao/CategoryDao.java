package com.baizhi.Lorry.dao;

import java.util.List;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_sort;

public interface CategoryDao {
   public List<D_sort> QueryCategory();  
   public List<D_sort> queryOneById(Integer id);
   public Integer queryCountById(Integer id);
}
