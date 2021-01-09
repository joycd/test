package cn.jsu.cd.frm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.jsu.cd.service.MtypeService;
import cn.jsu.cd.service.impl.MtypeserviceImpl;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Mtype extends JFrame{
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private DefaultTableModel model1;// ����������ģ��
	private JTextField txtKey;

	public static void main(String[] args) {
		Mtype frame = new Mtype();// ʵ��������
		frame.setLocationRelativeTo(null);// �������
		frame.setVisible(true);// ����ɼ�
	}

	/**
	 * Create the application.
	 */
	public Mtype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MtypeService mt=new MtypeserviceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 763, 378);
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(45, 89, 649, 219);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������
	
		// ʹ�ö�̬�������ݣ��б����������ݣ�
				Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
				Collections.addAll(titles, "���ͱ��", "��������", "������","��С����","������" ,"��С���");
				String sql="select * from Mtype";//�����ѯ���
				Vector<Vector> stuInfo = mt.searchAll(sql);// �����ݿ��ж�ȡ����������
				
//				ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
				model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
					public Class getColumnClass(int column) {//��ȡ�е�����
						Class returnValue;
						if ((column >= 0) && (column < getColumnCount())) {
							returnValue = getValueAt(0, column).getClass();
						} else {
							returnValue = Object.class;
						}
						return returnValue;
					}};
					table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
					
					scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
					
					JLabel lblKey = new JLabel("���������ͱ�ţ�");
					lblKey.setBounds(67, 26, 149, 36);
					contentPane.add(lblKey);
					
					txtKey = new JTextField();
					txtKey.setBounds(219, 33, 183, 21);
					contentPane.add(txtKey);
					txtKey.setColumns(10);
					
					JButton btnFind = new JButton("����");
					btnFind.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(txtKey.getText().equals("")){
								table = new JTable(model);
							scrollPane.setViewportView(table);
							
							}
							else{	
								int id = Integer.parseInt(txtKey.getText().trim());
							Vector row = mt.searchById(id);
							model1 = new DefaultTableModel(row, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
								public Class getColumnClass(int column) {//��ȡ�е�����
									Class returnValue;
									if ((column >= 0) && (column < getColumnCount())) {
										returnValue = getValueAt(0, column).getClass();
									} else {
										returnValue = Object.class;
									}
									return returnValue;
								}};
								table = new JTable(model1);
								scrollPane.setViewportView(table);}
					
//							setVisible(false);
							
						}
					});
					btnFind.setBounds(432, 32, 95, 25);
					contentPane.add(btnFind);
					
					JButton btnNewButton = new JButton("����");
					btnNewButton.setBounds(562, 31, 113, 27);
					contentPane.add(btnNewButton);
					
					btnNewButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							new MecFrame();
							MecFrame.main(null);
					
							setVisible(false);
							
						}
					});
	
	}
}
