package com.baizhi.Lorry.action;

import java.util.List;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.service.BookService;
import com.baizhi.Lorry.service.BookServiceImpl;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;

public class HotBookAction implements Action{
private List<D_book> hotBook;



public List<D_book> getHotBook() {
	return hotBook;
}

public void setHotBook(List<D_book> hotBook) {
	this.hotBook = hotBook;
}


public String execute() throws Exception {
	BookService cs=new BookServiceImpl();

	hotBook=cs.queryBookBySale();

	return "success";
}
}
