package cn.jsu.cd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.jsu.cd.dao.UserDao;
import cn.jsu.cd.dbc.DatabaseConnectionSql;
import cn.jsu.cd.vo.User;

public class UserDaoImpl implements UserDao {
	
	@Override
	public void add(User user) {
		
		String sql="insert into Userdb(username,password,time) values(?,?,?)";//使用占位符定义插入语句
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, user.getUsername());//定义第1个占位符的内容
    		pstmt.setString(2, user.getPassword());//定义第2个占位符的内容
    		pstmt.setString(3, user.getTime());//定义第3个占位符的内容
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
     	

	@Override
	public void delete(String sql) {
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}


	@Override
	public int getNewId(){
		String sql="select top 1 * from userdb order by id desc";//使用占位符定义插入语句
//		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		ResultSet rs = null;
		int id = 0;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			id=rs.getInt(1);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return id;
	}


	@Override
	public User seachID(int id) {
		User user=new User();
		String sql="select * from userdb where id="+id;//使用占位符定义插入语句
//		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		ResultSet rs = null;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			if(rs.getInt(1)==1)
    			user.setId(0);
    			user.setId(rs.getInt(1));
    			user.setUsername(rs.getString(2));
    			user.setPassword(rs.getString(3));
    			user.setTime(rs.getString(4));
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return user;
	
	}

	
	
}

