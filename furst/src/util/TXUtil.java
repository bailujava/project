package util;

import java.sql.Connection;
import java.sql.SQLException;

public class TXUtil {
	public static void start(){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			//自动变手动commit
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getCommit(){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void getRollback(){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.rollback();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			JDBCUtil.JDBCClose(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
