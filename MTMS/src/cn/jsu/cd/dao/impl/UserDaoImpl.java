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
		
		String sql="insert into Userdb(username,password,time) values(?,?,?)";//ʹ��ռλ������������
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, user.getUsername());//�����1��ռλ��������
    		pstmt.setString(2, user.getPassword());//�����2��ռλ��������
    		pstmt.setString(3, user.getTime());//�����3��ռλ��������
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
     	

	@Override
	public void delete(String sql) {
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}


	@Override
	public int getNewId(){
		String sql="select top 1 * from userdb order by id desc";//ʹ��ռλ������������
//		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		ResultSet rs = null;
		int id = 0;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
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
		String sql="select * from userdb where id="+id;//ʹ��ռλ������������
//		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		ResultSet rs = null;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
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

