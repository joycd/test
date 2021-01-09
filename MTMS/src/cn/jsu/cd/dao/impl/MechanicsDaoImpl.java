package cn.jsu.cd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import cn.jsu.cd.dao.MechanicsDao;
import cn.jsu.cd.dbc.DatabaseConnectionSql;
import cn.jsu.cd.vo.Mechanics;

public class MechanicsDaoImpl implements MechanicsDao{

	@Override
	public void add(Mechanics s) {
		String sql="insert into Mechanics(m_name,m_weight,m_area,m_function,m_time,ty_id) values(?,?,?,?,?,?)";//使用占位符定义插入语句
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, s.getM_name());//定义第2个占位符的内容
    		pstmt.setFloat(2, s.getM_weight());//定义第3个占位符的内容
    		pstmt.setFloat(3, s.getM_area());//定义第4个占位符的内容
    		pstmt.setString(4, s.getM_function());//定义第5个占位符的内容
    		pstmt.setString(5, s.getM_time());//定义第6个占位符的内容
    		pstmt.setInt(6, s.getTy_id());//定义第7个占位符的内容
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
		
	

	@Override
	public void delete(int id) {
		String sql="delete  from Mechanics where m_id="+id;
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
    			row.add(rs.getInt(3));
    			row.add(rs.getInt(4));//获取第三个字段成绩
    			row.add(rs.getString(5));//获取第一个字段学号
    			row.add(rs.getString(6));//获取第二个字段姓名
    			row.add(rs.getInt(7));
    			row.add(rs.getInt(8));//获取第三个字段成绩
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
		String sql="select * from Mechanics where m_id="+id;//使用占位符定义插入语句
		Vector<Vector> rows=new Vector<Vector>();
		ResultSet rs = null;
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getFloat(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
    			Collections.addAll(rows, row);//增加行数据
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}



	@Override
	public int getNewId() {
		String sql="select top 1 * from Mechanics order by m_id desc";//使用占位符定义插入语句
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
