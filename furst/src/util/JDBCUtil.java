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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	        }
	        
	    	public static Connection getConnection()throws ClassNotFoundException,SQLException{
				Connection conn = null;			
				//�ڶ��ε��ô������ӷ�����ʱ��  �ж� �Ƿ��Ѿ�������������˰�
				//���Connection
				conn = threadLocal.get();
				if(conn==null){
					Class.forName(p.getProperty("dizhi"));
					conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("name"),p.getProperty("password"));	
					//��һ�������� �ɹ�֮�� Ӧ�ý� conn���Ӻ��߳̽���һ����   map    
					threadLocal.set(conn);
					return conn;	
				}else{
					return conn;
				}
				
		}
		
		// �ر���Դ
		public static void JDBCClose(Connection conn,PreparedStatement pst,ResultSet rs){
			if(rs!=null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pst!=null)try {pst.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn!=null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		// �ر���Դ
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
				// �ر�����  �������Ӳ���ʹ��   ������Ӻ��̵߳İ�
			if(conn!=null)try {conn.close();threadLocal.remove();} catch (SQLException e) {e.printStackTrace();}		
		}
		
		
		

}
