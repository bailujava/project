package com.baizhi.Lorry.entity;

import java.util.HashMap;

/**
 * @description 购物车业务对象
 * @author Administrator
 * 
 */
public class CartBO {
	
	private   HashMap<String, CartItemBO>  shop;//购物的map
	private   HashMap<String, CartItemBO>  del;//删除的map
	private   Double save;//节省价格
	private   Double total;//总价
	
	
	public HashMap<String, CartItemBO> getShop() {
		return shop;
	}
	public void setShop(HashMap<String, CartItemBO> shop) {
		this.shop = shop;
	}
	public HashMap<String, CartItemBO> getDel() {
		return del;
	}
	public void setDel(HashMap<String, CartItemBO> del) {
		this.del = del;
	}
	public Double getSave() {
		return save;
	}
	public void setSave(Double save) {
		this.save = save;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	

}
