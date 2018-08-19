import java.util.List;

import org.junit.Test;

import com.baizhi.lorry.dao.UserDao;
import com.baizhi.lorry.entity.User;
import com.baizhi.lorry.service.QueryUserService;
import com.baizhi.lorry.service.QueryUserServiceImpl;
import com.baizhi.lorry.util.MybatisUtil;
import com.baizhi.util.MyBatisUtil;


public class test {
	@Test
	public void XX(){
	
	UserDao UD = (UserDao) MyBatisUtil.getMapper(UserDao.class);
	User user = UD.queryByName("白露");
	MyBatisUtil.closeSqlsession();
	System.out.println(user);
	}
	@Test
	public void test2(){
		QueryUserService queryUserService = new QueryUserServiceImpl();
	/*	Boolean queryName = queryUserService.queryName("白露");*/
/*		System.out.println(queryName);*/
	}
	@Test
	public void test3(){
		UserDao UD = (UserDao) MyBatisUtil.getMapper(UserDao.class);
		List<User> all = UD.queryAll();
		System.out.println(all);
	}
}
