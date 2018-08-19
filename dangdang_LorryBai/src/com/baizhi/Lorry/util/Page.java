package com.baizhi.Lorry.util;

import java.util.List;

/**
 * 
 * @author Administrator
 * 分页工具类
 * @param <T>  对应的分类对象
 */
public class Page<T> {
	
	private  Integer   currPage;//当前页
	private  Integer   total;//总记录数
	private  static final  Integer  SIZE  = 3;//每页显示的记录数  
	private  Integer   totalPage;//总页数
	private  Integer  start;//开始的记录数
	private  Integer end;//结束的记录数
	private  boolean first;//是否是第一页
	private  boolean last;//是否是最后一页
	private  List<T> items;//查询到的分类数据
	
	
	
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	//修改set方法设置总页数，这样可以直接调用set方法不用传递参数即可
	public void setTotalPage() {
		if(total==null){this.totalPage =1;}
		else{this.totalPage = total%SIZE==0?total/SIZE:total/SIZE+1;}
	}
	public Integer getStart() {
		return start;
	}
	public void setStart() {
		this.start = (currPage-1)*SIZE+1;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd() {
		this.end = currPage*SIZE;
	}
	
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Page [currPage=" + currPage + ", total=" + total
				+ ", totalPage=" + totalPage + ", start=" + start + ", end="
				+ end + ", first=" + first + ", last=" + last + ", items="
				+ items + "]";
	}
	
	

}
