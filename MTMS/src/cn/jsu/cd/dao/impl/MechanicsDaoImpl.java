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
		String sql="insert into Mechanics(m_name,m_weight,m_area,m_function,m_time,ty_id) values(?,?,?,?,?,?)";//ʹ��ռλ������������
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, s.getM_name());//�����2��ռλ��������
    		pstmt.setFloat(2, s.getM_weight());//�����3��ռλ��������
    		pstmt.setFloat(3, s.getM_area());//�����4��ռλ��������
    		pstmt.setString(4, s.getM_function());//�����5��ռλ��������
    		pstmt.setString(5, s.getM_time());//�����6��ռλ��������
    		pstmt.setInt(6, s.getTy_id());//�����7��ռλ��������
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
		
	

	@Override
	public void delete(int id) {
		String sql="delete  from Mechanics where m_id="+id;
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
    			row.add(rs.getInt(3));
    			row.add(rs.getInt(4));//��ȡ�������ֶγɼ�
    			row.add(rs.getString(5));//��ȡ��һ���ֶ�ѧ��
    			row.add(rs.getString(6));//��ȡ�ڶ����ֶ�����
    			row.add(rs.getInt(7));
    			row.add(rs.getInt(8));//��ȡ�������ֶγɼ�
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
		String sql="select * from Mechanics where m_id="+id;//ʹ��ռλ������������
		Vector<Vector> rows=new Vector<Vector>();
		ResultSet rs = null;
		
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		rs=pstmt.executeQuery();
    		while(rs.next()){
    			Vector row=new Vector();
    			Collections.addAll(row, rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getFloat(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
    			Collections.addAll(rows, row);//����������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return rows;
	}



	@Override
	public int getNewId() {
		String sql="select top 1 * from Mechanics order by m_id desc";//ʹ��ռλ������������
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
