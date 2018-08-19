package com.baizhi.Lorry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.util.Page;

public interface BookDao {
   public List<D_book>QueryBookByRan();
   public List<D_book>QueryBookBySale();
   public List<D_book>QueryBookByDate();
   public List<D_book>QueryBookBySD();
   public List<D_book>queryBYId(@Param("id")Integer id,@Param("pid")Integer pid,@Param("page")Page<D_book> page);
   public D_book QueryBook(String id);
}
