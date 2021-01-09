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
		String sql="insert into Transport(t_color,t_carry,t_brand,t_license,t_tonnage,t_flag,t_time) values(?,?,?,?,?,?,?)";//ʹ��ռλ������������
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, s.getT_color());//�����2��ռλ��������
    		pstmt.setFloat(2, s.getT_carry());//�����3��ռλ��������
    		pstmt.setString(3, s.getT_brand());//�����4��ռλ��������
    		pstmt.setString(4, s.getT_license());//�����5��ռλ��������
    		pstmt.setFloat(5, s.getT_tonnage());//�����6��ռλ��������
    		pstmt.setInt(6, s.getT_flag());//�����7��ռλ��������
    		pstmt.setString(7, s.getT_time());//�����7��ռλ��������
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
		
	

	@Override
	public void delete(int id) {
		String sql="delete  from Transport where t_id="+id;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.executeQuery();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}



	@Override
	public Vector<Vector> searchAll(String sql) {
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		ResultSet rs = null;
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    			PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		rs=pstmt.executeQuery();
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getInt(1));//��ȡ��һ���ֶ�ѧ��
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
    			row.add(rs.getFloat(3));
    			row.add(rs.getString(4));//��ȡ�������ֶγɼ�
    			row.add(rs.getString(5));//��ȡ��һ���ֶ�ѧ��
    			row.add(rs.getFloat(6));//��ȡ�ڶ����ֶ�����
    			row.add(rs.getInt(7));
    			row.add(rs.getString(8));//��ȡ�������ֶγɼ�
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}



	@Override
	public void updata(String sql) {
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}



	@Override
	public Vector<Vector> searchById(int id) {
		String sql="select * from Transport where t_id="+id;//ʹ��ռλ������������
		Vector<Vector> rows=new Vector<Vector>();
		ResultSet rs = null;
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getInt(7),rs.getString(8));
    			Collections.addAll(rows, row);//����������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}



	@Override
	public int getNewId() {
		String sql="select top 1 * from Transport  order by t_id desc";//ʹ��ռλ������������
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
}
