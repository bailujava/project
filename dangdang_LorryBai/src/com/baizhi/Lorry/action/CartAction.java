package com.baizhi.Lorry.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.baizhi.Lorry.entity.CartBO;
import com.baizhi.Lorry.entity.CartItemBO;
import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.service.BookService;
import com.baizhi.Lorry.service.BookServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * 操作购物车的action，包含了添加，删除，恢复以及修改数量
 * @author Administrator
 *
 */
public class CartAction extends ActionSupport{
	
	private  String  id;//需要操作的商品id
	private  BookService bs = new BookServiceImpl();//业务层对象
	private int count;
	/**
	 * 添加购物车的方法 
	 * @return 跳转路径
	 */
	public  String addItem(){
		//从session 中获取我们的购物车   cart
		ValueStack  vs = ActionContext.getContext().getValueStack();
		CartBO cart = (CartBO) vs.findValue("#session.cart");
        if(cart == null){
            cart = new  CartBO();
            // 新建购物map   shop  
            HashMap<String, CartItemBO> shop = new  HashMap<String,CartItemBO>();
            //调用业务层对象查询商品（书籍）的信息
            D_book book = bs.queryItemById(id);
            //新建 购物项对象  item    设置book属性      设置count为1   
            CartItemBO item = new CartItemBO();
            item.setBook(book);
            item.setCount(1);
            //shop.put（id，item）
            shop.put(id, item);
            //cart.setShop（shop）
            cart.setShop(shop);
       }else{
           //获取shop  
    	   HashMap<String,CartItemBO> shop = cart.getShop();
    	   if(shop.containsKey(id)){
    		 //通过id获取购物项  item   将它的 count + 1
    		 CartItemBO item = shop.get(id);
             item.setCount(item.getCount()+1); 
    	   }else{
    		 //新建购物项 item   
    		 CartItemBO item = new CartItemBO();  
             //设置book，设置count 默认为1
    		 D_book book = bs.queryItemById(id);
    		 item.setBook(book);
    		 item.setCount(1);
             //shop.put(id,item) 
    		 shop.put(id, item);
    	   }
       }
       
        
       //计算节省价格和总价
       //获取所有的value  shop.values（）
       //新建save  新建total    Double   遍历相加
       Double   save = 0.0; 
       Double   total = 0.0;
       
       Collection<CartItemBO> items = cart.getShop().values();
       //save  += （book.getPrice（）-book.getDdPrice（））*  count
       //total同理
       for (CartItemBO item : items) {
    	   System.out.println(item);
    	   save += (item.getBook().getPrice()-item.getBook().getDd_price())*item.getCount();
		   total += item.getBook().getDd_price()*item.getCount();
	   }
       //cart.setSave（save）  cart.setTotal（total）
       cart.setSave(save);
       cart.setTotal(total);
       //覆盖原来的购物车   vs.setValue("#session.cart",cart)
       vs.setValue("#session.cart", cart);
	   return  "cartList";
	}

	// 修改数量
		public String changeCount() {
			try {
				CartBO cart = (CartBO)ActionContext.getContext().getValueStack().findValue("#session.cart");
				Map<String, CartItemBO> cartMap = cart.getShop();
				CartItemBO item = cartMap.get(id);
				item.setCount(count);
				//修改价格
				changePrice(cart);
				ActionContext.getContext().getValueStack().setValue("#session.cart", cart);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				ActionContext.getContext().getValueStack().setValue("#request.error", e.getMessage());
				return "error";
			}
			return "success";
		}
		
		// 删除商品
		public String deleteProduct(){
			try{
				//获取购物车map
				CartBO cart = (CartBO)ActionContext.getContext().getValueStack().findValue("#session.cart");
				HashMap<String, CartItemBO> cartMap = cart.getShop();
				if(cart.getDel() == null){
					//新创建一个删除恢复map
					HashMap<String,CartItemBO> delMap = new HashMap<String,CartItemBO>();
					//放入到删除map中
					delMap.put(id, cartMap.get(id));
					//从购物map中删除商品
					cartMap.remove(id);
					//将购物map和删除map放入到购物车中
					cart.setShop(cartMap);
					cart.setDel(delMap);
				}else{
					//放入到删除map中
					HashMap<String, CartItemBO> delMap = cart.getDel();
					//放入到删除map中
					delMap.put(id, cartMap.get(id));
					//从购物map中删除商品
					cartMap.remove(id);
					//将购物map和删除map放入到购物车中
					cart.setShop(cartMap);
					cart.setDel(delMap);
				}
				//更改价格
				changePrice(cart);
				return null;
			}catch(Exception e){
				e.printStackTrace();
				ActionContext.getContext().getValueStack().setValue("#request.error", e.getMessage());
				return "error";
			}
		}
			// 恢复
			public String recoverProduct(){
				try {
					//获取购物车map
					CartBO cart = (CartBO)ActionContext.getContext().getValueStack().findValue("#session.cart");
					HashMap<String, CartItemBO> cartMap = cart.getShop();
					HashMap<String, CartItemBO> delMap = cart.getDel();
					CartItemBO item = delMap.get(id);
					cartMap.put(id, item);
					delMap.remove(id);
					
					cart.setShop(cartMap);
					cart.setDel(delMap);
					
					changePrice(cart);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					ActionContext.getContext().getValueStack().setValue("#request.error", e.getMessage());
					return "error";
				}
				return "success";
			}
		/*-------------------------------------------------------------------------*/
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
		
		public void changePrice(CartBO cart) {
			// 修改节省总价和总计
			double totalSavePrice = 0.0;
			double totalPrice = 0.0;
			HashMap<String, CartItemBO> cartMap = cart.getShop();
			Collection<CartItemBO> items = cartMap.values();
			for (CartItemBO item : items) {
				totalSavePrice += (item.getBook().getPrice() - item.getBook().getDd_price()) * item.getCount();
				totalPrice += item.getBook().getDd_price() * item.getCount();
			}
			cart.setTotal(totalPrice);
			cart.setSave(totalSavePrice);
		}
	
}
