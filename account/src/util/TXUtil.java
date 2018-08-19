package util;

import org.apache.ibatis.session.SqlSession;

public class TXUtil {

	public static void commit(){
		SqlSession session = MybatisUtil.openSession();
		session.commit();
		MybatisUtil.close();
	}
	
	public static void rollback(){
		SqlSession session = MybatisUtil.openSession();
		session.rollback();
		MybatisUtil.close();
	}
	
}
