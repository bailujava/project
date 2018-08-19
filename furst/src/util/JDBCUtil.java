package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	
			private static Properties p=new Properties();
	        private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
	        static{
	        InputStream I=JDBCUtil.class.getResourceAsStream("/util/account.properties");
	        
	        try {
				p.load(I);
				I.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	        }
	        
	    	public static Connection getConnection()throws ClassNotFoundException,SQLException{
				Connection conn = null;			
				//第二次调用创建连接方法的时候  判断 是否已经创建连接完成了绑定
				//获得Connection
				conn = threadLocal.get();
				if(conn==null){
					Class.forName(p.getProperty("dizhi"));
					conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("name"),p.getProperty("password"));	
					//第一创建连接 成功之后 应该将 conn连接和线程进行一个绑定   map    
					threadLocal.set(conn);
					return conn;	
				}else{
					return conn;
				}
				
		}
		
		// 关闭资源
		public static void JDBCClose(Connection conn,PreparedStatement pst,ResultSet rs){
			if(rs!=null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pst!=null)try {pst.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn!=null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		// 关闭资源
		public static void JDBCClose(Connection conn,PreparedStatement pst){
			if(pst!=null)try {pst.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn!=null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}		
		}
		public static void JDBCClose(PreparedStatement pst,Connection conn ){
			if(pst!=null)try {pst.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn!=null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}		
		}
		public static void JDBCClose(PreparedStatement pst, ResultSet rs){
			if(pst!=null)try {pst.close();} catch (SQLException e) {e.printStackTrace();}
			if(rs!=null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}		
		}
		public static void JDBCClose(PreparedStatement pst){
			if(pst!=null)try {pst.close();} catch (SQLException e) {e.printStackTrace();}
		}
		public static void JDBCClose(Connection conn){
				// 关闭连接  代表连接不再使用   解除连接和线程的绑定
			if(conn!=null)try {conn.close();threadLocal.remove();} catch (SQLException e) {e.printStackTrace();}		
		}
		
		
		

}
