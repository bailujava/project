package com.baizhi.Lorry.action;

import java.util.List;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.service.BookService;
import com.baizhi.Lorry.service.BookServiceImpl;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;

public class HomeBookAction implements Action{

private List<D_book> ranBook;


public List<D_book> getRanBook() {
	return ranBook;
}

public void setRanBook(List<D_book> ranBook) {
	this.ranBook = ranBook;
}


@Override
public String execute() throws Exception {
	BookService cs=new BookServiceImpl();
	ranBook=cs.queryBook();
	return "success";
}
}
