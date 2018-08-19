package com.baizhi.Lorry.service;

import java.util.List;

import com.baizhi.Lorry.entity.D_sort;

public interface CategoryService {
	public List<D_sort> categoryService();
	public List<D_sort> queryOneById(Integer id);
	public Integer queryCountById(Integer id);
}
