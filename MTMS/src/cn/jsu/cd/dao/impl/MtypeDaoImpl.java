package cn.jsu.cd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import cn.jsu.cd.dao.MtypeDao;
import cn.jsu.cd.dbc.DatabaseConnectionSql;
import cn.jsu.cd.vo.Mtype;

public class MtypeDaoImpl implements MtypeDao{

	@Override
	public Vector<Vector> searchById(int id) {
		String sql="select * from Mtype where ty_id="+id;;//ʹ��ռλ������������
		Vector<Vector> rows=new Vector<Vector>();
		ResultSet rs = null;
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
    			Collections.addAll(rows, row);//����������
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
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
    			Collections.addAll(rows, row);//����������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}

	@Override
	public void add(Mtype mt) {
		String sql="insert into Mtype(ty_id,ty_name,wmax,wmin,amax,amin) values(?,?,?,?,?,?)";//ʹ��ռλ������������
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    			pstmt.setInt(1, mt.getTy_id());//�����1��ռλ��������
    			pstmt.setString(2, mt.getTy_name());//�����2��ռλ��������
    			pstmt.setInt(3,mt.getWmax() );//�����3��ռλ��������
    			pstmt.setInt(4, mt.getWmin());//�����4��ռλ��������
    			pstmt.setInt(5, mt.getAmax());//�����5��ռλ��������
    			pstmt.setInt(6,mt.getAmin() );//�����6��ռλ��������
    			pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}

}
