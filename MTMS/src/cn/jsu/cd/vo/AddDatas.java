package cn.jsu.cd.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.jsu.cd.dbc.DatabaseConnection;
import cn.jsu.cd.dbc.DatabaseConnectionSql;

public class AddDatas{
	//��������
		private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
		//����Ů������
		private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
		//������������
	    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";

	    private static String pass="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    
	    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
	    	//Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	    
	    public static String getPass() {
	    	String s ="";
	    	String s1;
	    	for(int i=0;i<9;i++){
	    		int length=pass.length();
	    		int index=getNum(0,length-1);//�����ȡ���ֵ�λ��
		        s1=pass.substring(index, index+1);
		        s+=s1;
	    	}
	        return s;
	    }
	    
	    public static String getSex() {//������ط���ָ����Χ�������
	    	//Math.random()�������0.0��1.0֮�����
	       if((int)(Math.random()*2)==0)
	       return "Ů";
	       return "��";
	    }
	   
	    //��������������� 
	    public static String getChineseName(String xb) {
	        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
	        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
	        String str=boy;//��������Ϊ�����ַ���
	        int length=boy.length();//��ȡ�����ַ����ĳ���
	        if(xb.equals("Ů")){//��������ȡΪ0�������ָ�ΪŮ��
	            str=girl;
	            length=girl.length();
	        }
	        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
	        String second=str.substring(index, index+1);//��ȡ��λ���е�����
	        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
	        String third="";//Ĭ��û�е�������
	        if(hasThird==1){//��������ȡΪ1�����е�������
	            index=getNum(0,length-1);
	            third=str.substring(index, index+1);
	        }
	        return first+second+third;//��������
	    }
	    public static void main(String[] args) {
	    	addCJ();
	    }
	    public static void addCJ() {//���ӳɼ�
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	String sql="insert into Userdb(username,xb,password,time) values(?,?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//���弯��
	    		for(int i=1;i<=10000;) {
	    				String xb=getSex();
	    				String xm=getChineseName(xb);//�����ȡ����
	    				String passWord=getPass();
	    				String time=new NowString().getTime();
//	    				System.out.println(xb+"   "+xm+"   "+passWord+"   "+time);
	    				int cj=getNum(0, 100);//�����ȡ�ɼ�
	    				pstmt.setString(1, xm);//�����1��ռλ��������
	    				pstmt.setString(2, xb);//�����2��ռλ��������
	    				pstmt.setString(3, passWord);//�����3��ռλ��������
	    	    		pstmt.setString(4,time );//�����4��ռλ��������
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//ѧ��Ψһ��ѭ����������ִ��
	    		}
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }

}
