package com.baizhi.Lorry.action;

import java.util.List;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.service.BookService;
import com.baizhi.Lorry.service.BookServiceImpl;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;

public class NewBookAction implements Action{

private List<D_book> newBook;




public List<D_book> getNewBook() {
	return newBook;
}

public void setNewBook(List<D_book> newBook) {
	this.newBook = newBook;
}



@Override
public String execute() throws Exception {
	BookService cs=new BookServiceImpl();
	newBook= cs.queryBookByDate();
	System.out.println(newBook);
	return "success";
}
}
