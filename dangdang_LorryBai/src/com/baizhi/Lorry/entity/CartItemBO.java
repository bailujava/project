package com.baizhi.Lorry.entity;

/**
 * 购物项业务层对象
 * @author Administrator
 *
 */
public class CartItemBO {
	
	private  D_book  book;//购物对象
	private  Integer count;//购物数量
	private	 Integer order_id;
	public CartItemBO(){}
	public CartItemBO(D_book book, Integer count, Integer order_id) {
		super();
		this.book = book;
		this.count = count;
		this.order_id = order_id;
	}
	public D_book getBook() {
		return book;
	}
	public Integer getCount() {
		return count;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setBook(D_book book) {
		this.book = book;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "CartItemBO [book=" + book + ", count=" + count + ", order_id="
				+ order_id + "]";
	}
	
	

}
