package com.baizhi.Lorry.action;

import java.util.List;

import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.service.BookService;
import com.baizhi.Lorry.service.BookServiceImpl;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;

public class NewHotBookAction implements Action{
private List<D_book> newHotBook;


@Override
public String execute() throws Exception {
	BookService cs=new BookServiceImpl();
	newHotBook= cs.queryBookBySD();
	return "success";
}

public List<D_book> getNewHotBook() {
	return newHotBook;
}

public void setNewHotBook(List<D_book> newHotBook) {
	this.newHotBook = newHotBook;
}

}
