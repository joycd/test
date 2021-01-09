package cn.jsu.cd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import cn.jsu.cd.dao.TransportDao;
import cn.jsu.cd.dbc.DatabaseConnectionSql;
import cn.jsu.cd.service.TtypeService;
import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.Transport;

public class TransportDaoImpl implements TransportDao{

	@Override
	public void add(Transport s) {
		String sql="insert into Transport(t_color,t_carry,t_brand,t_license,t_tonnage,t_flag,t_time) values(?,?,?,?,?,?,?)";//使用占位符定义插入语句
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, s.getT_color());//定义第2个占位符的内容
    		pstmt.setFloat(2, s.getT_carry());//定义第3个占位符的内容
    		pstmt.setString(3, s.getT_brand());//定义第4个占位符的内容
    		pstmt.setString(4, s.getT_license());//定义第5个占位符的内容
    		pstmt.setFloat(5, s.getT_tonnage());//定义第6个占位符的内容
    		pstmt.setInt(6, s.getT_flag());//定义第7个占位符的内容
    		pstmt.setString(7, s.getT_time());//定义第7个占位符的内容
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
		
	

	@Override
	public void delete(int id) {
		String sql="delete  from Transport where t_id="+id;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.executeQuery();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}



	@Override
	public Vector<Vector> searchAll(String sql) {
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		ResultSet rs = null;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		rs=pstmt.executeQuery();
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getInt(1));//获取第一个字段学号
    			row.add(rs.getString(2));//获取第二个字段姓名
    			row.add(rs.getFloat(3));
    			row.add(rs.getString(4));//获取第三个字段成绩
    			row.add(rs.getString(5));//获取第一个字段学号
    			row.add(rs.getFloat(6));//获取第二个字段姓名
    			row.add(rs.getInt(7));
    			row.add(rs.getString(8));//获取第三个字段成绩
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}



	@Override
	public void updata(String sql) {
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}



	@Override
	public Vector<Vector> searchById(int id) {
		String sql="select * from Transport where t_id="+id;//使用占位符定义插入语句
		Vector<Vector> rows=new Vector<Vector>();
		ResultSet rs = null;
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getInt(7),rs.getString(8));
    			Collections.addAll(rows, row);//增加行数据
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}



	@Override
	public int getNewId() {
		String sql="select top 1 * from Transport  order by t_id desc";//使用占位符定义插入语句
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
}
