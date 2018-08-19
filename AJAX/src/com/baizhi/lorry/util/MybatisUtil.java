package com.baizhi.lorry.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory factory = null;
	
    static {
    	try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		    factory = builder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    private static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
    
	public static SqlSession openSession() {
		SqlSession session = tol.get();
		
		if(session==null){
		    session = factory.openSession();
		    tol.set(session);
		    return session;
		}else{
			return session;
		}	
	}
	
	public static void close(){
		SqlSession session = openSession();  
		session.close();
		tol.remove();
	}
	
	public static Object getMapper(Class a){
		SqlSession session = openSession();
		return session.getMapper(a);
	}
	
}














