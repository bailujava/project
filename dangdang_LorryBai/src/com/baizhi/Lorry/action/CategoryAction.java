package com.baizhi.Lorry.action;

import java.util.List;

import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;

public class CategoryAction implements Action{
private List<D_sort> all;

public List<D_sort> getAll() {
	return all;
}

public void setAll(List<D_sort> all) {
	this.all = all;
}

@Override
public String execute() throws Exception {
	CategoryService cs=new CategoryServiceImpl();

	all= cs.categoryService();

	return "success";
}
}
