package com.baizhi.Lorry.service;

import java.util.List;

import com.baizhi.Lorry.dao.BookDao;
import com.baizhi.Lorry.dao.CategoryDao;
import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.util.MybatisUtil;
import com.baizhi.Lorry.util.Page;

public class BookServiceImpl implements BookService{

	public List<D_book> queryBookByDate() {
		BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<D_book> BD = dao.QueryBookByDate();
		MybatisUtil.close();
		return BD;
	}

	@Override
	public List<D_book> queryBookBySale() {
		BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<D_book> BS = dao.QueryBookBySale();
		MybatisUtil.close();
		return BS;
	}

	@Override
	public List<D_book> queryBookBySD() {
		BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);

		List<D_book> BSD = dao.QueryBookBySD();
		MybatisUtil.close();
		return BSD;
	}

	public Page<D_book> queryBookById(Integer id,Integer pid,Page<D_book> page) {
		CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
		BookDao dao2 = (BookDao) MybatisUtil.getMapper(BookDao.class);
		if(page==null){ 
		//新建page对象,设置初始值
			page=new Page<D_book>();
			page.setCurrPage(1);}
		//设置总记录数
		if(id==null){page.setTotal(dao.queryCountById(pid));}
		else{page.setTotal(dao.queryCountById(id));}
		//设置总页数
		page.setTotalPage(); 
		//设置是否是第一页 和最后一页
		if(page.getCurrPage().equals(1)){page.setFirst(true);}
		if(page.getCurrPage().equals(page.getTotalPage())||page.getTotalPage().equals(1))
		{page.setLast(true);}
		//设置起史记录数
		page.setStart();
		page.setEnd();
		//通过对应参数查询书籍信息
		List<D_book> list = dao2.queryBYId(id, pid, page);
		//设置page对象里面
		page.setItems(list);
		//返回page对象
		MybatisUtil.close();
		return page;
	}

	@Override
	public List<D_book> queryBook() {
		BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<D_book> BD = dao.QueryBookByRan();
		MybatisUtil.close();
		return BD;
	}

	@Override
	public D_book queryItemById(String id) {
		BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		D_book book = dao.QueryBook(id);
		MybatisUtil.close();
		return book;
	}

}
