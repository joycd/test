package cn.jsu.cd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import cn.jsu.cd.dao.MtypeDao;
import cn.jsu.cd.dao.TtypeDao;
import cn.jsu.cd.dbc.DatabaseConnectionSql;
import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.Mtype;
import cn.jsu.cd.vo.Ttype;

public class TtypeDaoImpl implements TtypeDao{
	@Override
	public Vector<Vector> searchById(int id) {
		String sql="select * from Ttype where tty_id="+id;;//使用占位符定义插入语句
		Vector<Vector> rows=new Vector<Vector>();
		ResultSet rs = null;
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
    			Collections.addAll(rows, row);//增加行数据
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
    	}
    	
		

	@Override
	public Vector<Vector> searchAll(String sql) {
		Vector<Vector> rows=new Vector<Vector>();
		ResultSet rs = null;
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
    			Collections.addAll(rows, row);//增加行数据
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}

	@Override
	public void add(Ttype mt) {
		String sql="insert into Ttype(tty_id,tty_name,twmax,twmin,tamax,tamin) values(?,?,?,?,?,?)";//使用占位符定义插入语句
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    			pstmt.setInt(1, mt.getTty_id());//定义第1个占位符的内容
    			pstmt.setString(2, mt.getTty_name());//定义第2个占位符的内容
    			pstmt.setInt(3,mt.getTwmax() );//定义第3个占位符的内容
    			pstmt.setInt(4, mt.getTwmin());//定义第4个占位符的内容
    			pstmt.setInt(5, mt.getTamax());//定义第5个占位符的内容
    			pstmt.setInt(6,mt.getTamin() );//定义第6个占位符的内容
    			pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}

}