package com.baizhi.Lorry.service;

import java.util.List;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.util.Page;

public interface BookService {
 public List<D_book> queryBookByDate();
 public List<D_book> queryBookBySale();
 public List<D_book> queryBookBySD();
 public List<D_book> queryBook();
 public Page<D_book> queryBookById(Integer id,Integer pid,Page<D_book> page);
 public D_book queryItemById(String id);
}
