package com.baizhi.Lorry.service;

import java.util.List;

import com.baizhi.Lorry.dao.CategoryDao;

import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.util.MybatisUtil;

public class CategoryServiceImpl implements CategoryService{

	public List<D_sort> categoryService() {
			 CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			 System.out.println("******************************************");
			 List<D_sort> list = dao.QueryCategory();//查询分类
		    MybatisUtil.close();
			 return list;
	}

	@Override
	public List<D_sort> queryOneById(Integer id) {
		 CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
		 List<D_sort> list = dao.queryOneById(id);
	    MybatisUtil.close();
		 return list;
	}

	@Override
	public Integer queryCountById(Integer id) {
		CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
		 Integer count = dao.queryCountById(id);
	    MybatisUtil.close();
		 return count;
	}

}
