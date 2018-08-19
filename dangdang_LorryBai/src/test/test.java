package test;

import java.util.List;

import org.junit.Test;

import com.baizhi.Lorry.dao.AddressDao;
import com.baizhi.Lorry.dao.BookDao;
import com.baizhi.Lorry.dao.UserDao;
import com.baizhi.Lorry.entity.D_book;
import com.baizhi.Lorry.entity.D_receivce_address;
import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.entity.D_user;
import com.baizhi.Lorry.service.BookService;
import com.baizhi.Lorry.service.BookServiceImpl;
import com.baizhi.Lorry.service.CategoryService;
import com.baizhi.Lorry.service.CategoryServiceImpl;
import com.baizhi.Lorry.util.MybatisUtil;

public class test {
@Test
public void XX(){
	AddressDao	AD=(AddressDao) MybatisUtil.getMapper(AddressDao.class);
	List<D_receivce_address> address = AD.query(1);
	System.out.println(address);
}
@Test
public void XX2(){
	UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
	 D_user user= dao.query("384848999@qq.com","123456ac");
	System.out.println(user);
	
}

@Test
public void XX3(){
	D_user user=new D_user();
	user.setEmail("1265523@qq.com");
	user.setNickname("xiaobai");
	user.setPassword("123456");
	UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
	dao.add(user);
	System.out.println(user);
	
}
@Test
public void XX4(){
CategoryService cs = new CategoryServiceImpl();
List<D_sort> QO = cs.queryOneById(5);
Integer count = cs.queryCountById(5);
 BookService bs=new BookServiceImpl();
System.out.println(QO);
System.out.println(count);

}
	@Test
	public void test5(){
		BookDao bookDao  = (BookDao) MybatisUtil.getMapper(BookDao.class);
		MybatisUtil.close();
		System.out.println(bookDao);
	}
}
