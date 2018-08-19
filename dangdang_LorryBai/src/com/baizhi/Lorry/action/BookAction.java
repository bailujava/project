package com.baizhi.Lorry.action;

import java.util.List;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.service.BookService;
import com.baizhi.Lorry.service.BookServiceImpl;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.baizhi.Lorry.util.Page;
import com.opensymphony.xwork2.Action;

public class BookAction implements Action{
private Integer id;
private Integer pid;
private List<D_sort> QO;
private Page<D_book> page;
private BookService bs=new BookServiceImpl();



public List<D_sort> getQO() {
	return QO;
}



public void setQO(List<D_sort> qO) {
	QO = qO;
}



public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public Integer getPid() {
	return pid;
}



public void setPid(Integer pid) {
	this.pid = pid;
}


public Page<D_book> getPage() {
	return page;
}



public void setPage(Page<D_book> page) {
	this.page = page;
}



public String execute() throws Exception {
	//查询分类信息
	System.out.println(pid);
	CategoryService cs = new CategoryServiceImpl();
	QO = cs.queryOneById(pid);
	Integer count = cs.queryCountById(pid);

	//查询分页信息

	 page = bs.queryBookById(id, pid, page);

	return "success";
}
}
