package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.User;
import util.JDBCUtil;

public class UserDAOIMPL implements UserDAO{

	public User query(User user) {
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	User queryUser=null;
	
	try {
		conn=JDBCUtil.getConnection();
		String sql ="select * from t_user where account=? and password=?";
		pst=conn.prepareStatement(sql);
		pst.setString(1,user.getAccount());
		pst.setString(2, user.getPassword());
		rs=pst.executeQuery();
		if(rs.next()){
			queryUser=new User(rs.getString("account"),rs.getString("password"));
		}
		return queryUser;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	} finally{
		JDBCUtil.JDBCClose(conn, pst, rs);}
	}

	public int add(User user) {
		Connection conn=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			conn=JDBCUtil.getConnection();
			String sql ="insert into t_user values(S.NEXTVAL,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getAccount());
			pst.setString(2, user.getPassword());
			i=pst.executeUpdate();
			return i;}
		 catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		finally{JDBCUtil.JDBCClose(pst);}
	}

	public List<User> queryAll() {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User queryUser=null;
		List<User> L=new ArrayList<User>(); 
		try {
			conn=JDBCUtil.getConnection();
			String sql ="select * from t_user";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next()){
				queryUser=new User(rs.getString("account"),rs.getString("password"));
				L.add(queryUser);
			}
			return L;
			}
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{JDBCUtil.JDBCClose(pst, rs);}
		
	}

	public void update(String account, String password) {
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="update t_user set password=? where account=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, account);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{JDBCUtil.JDBCClose(pst);}
		}
		
	}


