package cn.jsu.cd.frm;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.jsu.cd.service.MechanicsService;
import cn.jsu.cd.service.PageService;
import cn.jsu.cd.service.TransportService;
import cn.jsu.cd.service.UserService;
import cn.jsu.cd.service.impl.MechanicsServiceImpl;
import cn.jsu.cd.service.impl.PageServiceImpl;
import cn.jsu.cd.service.impl.TransportServiceImpl;
import cn.jsu.cd.service.impl.UserServiceImpl;
import cn.jsu.cd.vo.User;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class TraFrame {

	private JFrame frame;
	private JTable table;// ������
	private JTextField txtKey;//������ҹؼ����ı���
	private DefaultTableModel model1;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	private Vector<String> titles;
	Vector<Vector> bigList;
	int pagecount;
	int page;
	int pageNum;
	User user=new User();
	UserService userService=new UserServiceImpl();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraFrame window = new TraFrame();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TraFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PageService pageservice=new PageServiceImpl();
		TransportService traservice=new TransportServiceImpl();
		
		String sql="select * from Transport";
		bigList = traservice.searchAll(sql);//��ȡ��һҳ������
		int recode=bigList.size();//������
		System.out.println("��������"+recode);
		
		frame = new JFrame("���䳵");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TraFrame.class.getResource("/img/8.png")));
		frame.setBounds(100, 100, 801, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		
		
		
		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 82, 688, 246);// ���ô�С��λ��
		frame.getContentPane().add(scrollPane);
		
		
		
		
		
		JLabel lblKey = new JLabel("�����ţ�");
		lblKey.setBounds(44, 44, 132, 25);
		frame.getContentPane().add(lblKey);
				
		txtKey = new JTextField();
		txtKey.setBounds(116, 45, 123, 21);
		frame.getContentPane().add(txtKey);
		txtKey.setColumns(10);
				
		//������Ұ�ť
		JButton btnFind = new JButton("����");
		btnFind.setBounds(253, 44, 95, 25);
		frame.getContentPane().add(btnFind);
				
				
				
				
				JButton btnNewButton = new JButton("��һҳ");
				btnNewButton.setBounds(44, 345, 113, 27);
				frame.getContentPane().add(btnNewButton);
				
				textField = new JTextField("1");
				textField.setBounds(168, 345, 57, 27);
				frame.getContentPane().add(textField);
				textField.setColumns(10);
				pageNum=Integer.parseInt(textField.getText().trim());//��ǰҳ
				System.out.println("��ǰҳ:"+pageNum);
				
				JButton btnNext = new JButton("��һҳ");
				btnNext.setBounds(235, 344, 113, 28);
				frame.getContentPane().add(btnNext);
				
				JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
				lblMsg.setBounds(497, 348, 105, 20);
				frame.getContentPane().add(lblMsg);
				
				
				
				//������
				JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
				comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
				comboBox.setBounds(627, 347, 105, 23);
				frame.getContentPane().add(comboBox);
				pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());//ÿҳ��ʾ������

				page=pageservice.getPage(pagecount, recode);//��ҳ��
				
				JButton btnNewButton_1 = new JButton("ɾ��");
				btnNewButton_1.setBounds(374, 44, 95, 25);
				frame.getContentPane().add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("������䳵");
				btnNewButton_2.setBounds(607, 44, 125, 25);
				frame.getContentPane().add(btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton("������Ϣ");
				btnNewButton_3.setBounds(370, 345, 113, 27);
				frame.getContentPane().add(btnNewButton_3);
				

				//���				
				pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());
				pageNum=Integer.parseInt(textField.getText().trim());
				setTable(bigList, pageNum, pagecount);
				scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
				
				
				
				//������
				comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
				public void itemStateChanged(ItemEvent e) {
					pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());//ÿҳ��ʾ������
					page=pageservice.getPage(pagecount, recode);//��ҳ��
					System.out.println("ÿҳ��ʾ��"+pagecount);
					System.out.println("��ҳ����"+page);
						setTable(bigList, pageNum, pagecount);
						scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
					}
				});
				
				//��һҳ
				btnNewButton.addActionListener(new ActionListener() {//��һҳ�����¼�
					@Override
					public void actionPerformed(ActionEvent e) {
						pageNum=pageservice.prePage(pageNum, page);
						setTable(bigList, pageNum, pagecount);
						textField.setText(pageNum+"");
						scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
					
					}
				});
				
				//ҳ����
				textField.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent arg0) {
						int pageNum1=Integer.parseInt(textField.getText().trim());//��תҳ 
						if(pageNum1>page||pageNum1<=0){
							JOptionPane.showMessageDialog(null, "�����ڸ�ҳ��,ҳ�淶Χ��1-"+page+"ҳ��");
							textField.setText(pageNum+"");
						}
						else {
							pageNum=pageNum1;
							setTable(bigList, pageNum, pagecount);
						textField.setText(pageNum+"");
						scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
						
			
						}
						
					   }    
					  });
				
				//��һҳ
				btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("next");
						pageNum=pageservice.nextPage(pageNum, page);
						setTable(bigList, pageNum, pagecount);
						textField.setText(pageNum+"");
						scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
					
					}
				});
				
				JButton btn4 = new JButton("�޸�");
				btn4.setBounds(494, 44, 99, 25);
				frame.getContentPane().add(btn4);
				
				JLabel lblNewLabel = new JLabel("---���䳵��Ϣ---");
				lblNewLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 18));
				lblNewLabel.setBounds(266, 0, 183, 45);
				frame.getContentPane().add(lblNewLabel);
				
				JButton btnNewButton_4 = new JButton("������ҳ��");
				btnNewButton_4.setBounds(442, 400, 191, 27);
				frame.getContentPane().add(btnNewButton_4);
				//������ҳ��
				btnNewButton_4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new First();
						First.main(null);
						frame.dispose();
					}
				});
				
				JButton btnNewButton_6 = new JButton("�������ͻ�е����ϵͳ");
				btnNewButton_6.setBounds(158, 400, 183, 27);
				frame.getContentPane().add(btnNewButton_6);
				
				btnNewButton_6.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						MecFrame.main(null);
						frame.dispose();
					}
				});
				
				
				//�޸�
			btn4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String key=txtKey.getText().trim();//��ȡ����ؼ����ı����ֵ
						if(key.length()==0){
							JOptionPane.showMessageDialog(null, "��������!");
						}
						else{
							int id=Integer.parseInt(key);
							Vector<Vector> list=traservice.searchById(id);
								if(list.size()!=0) {
									ModifyTra mMec=new ModifyTra();
									mMec.t_id(id);
									
									mMec.main(null);
								}else {
									JOptionPane.showMessageDialog(null, "��������ȷ�ı��!");
								}
						}
						
					}
				});
				
				//����
				btnNewButton_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
//						new AddTra();
						AddTra.main(null);
						frame.dispose();
					}
				});
				
				
				//����
				btnNewButton_3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Ttype();
						Ttype.main(null);
						frame.dispose();
					}
				});
				
				//����
				btnFind.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) { 
						String key=txtKey.getText().trim();//��ȡ����ؼ����ı����ֵ
						if(key.length()==0){
							JOptionPane.showMessageDialog(null, "���������䳵���!");
						}
						else{
							int id=Integer.parseInt(key);
						Vector<Vector> list=traservice.searchById(id);
								if(list.size()!=0) {
									setTable(list, 1, 1);
									scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
									
								}else {
									JOptionPane.showMessageDialog(null, "��������ȷ�ı��!");
								}
						}
					}
						
				});
				//ɾ��
				btnNewButton_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String key=txtKey.getText().trim();//��ȡ����ؼ����ı����ֵ
						if(key.length()==0){
							JOptionPane.showMessageDialog(null, "��������!");
						}
						else{
							int id=Integer.parseInt(key);
						Vector<Vector> list=traservice.searchById(id);
								if(list.size()!=0) {
									traservice.delete(id);
									JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
									bigList = traservice.searchAll(sql);
									int recode=bigList.size();//������
									pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());//ÿҳ��ʾ������
									page=pageservice.getPage(pagecount, recode);//��ҳ��
									textField.setText("1");
									pageNum=Integer.parseInt(textField.getText().trim());//��ǰҳ
									setTable(bigList, pageNum, pagecount);
									scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
								}else {
									JOptionPane.showMessageDialog(null, "��������ȷ�ı��!");
								}
						}
					}
				});
	}
	
	public void setTable(Vector<Vector> bigList,int pageNum,int pagecount){

		PageService pageservice=new PageServiceImpl();
		TransportService traservice=new TransportServiceImpl();
		// ʹ�ö�̬�������ݣ��б����������ݣ�
				titles = new Vector<String>();// ���嶯̬�����ʾ������
				Collections.addAll(titles, "���ƺ�", "������ɫ", "�������(m2)","����Ʒ��","��Ӫ֤��","׼�ض���(t)","����״̬","��������");
				Vector<Vector> stuInfo1=pageservice.getPaegData(bigList, pageNum,pagecount);
				model1 = new DefaultTableModel(stuInfo1, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
//				public Class getColumnClass(int column) {//��ȡ�е�����
//					Class returnValue;
//					if ((column >= 0) && (column < getColumnCount())) {
//						returnValue = getValueAt(0, column).getClass();
//					} else {
//						returnValue = Object.class;
//					}
//					return returnValue;
//				}
			};
			table = new JTable(model1);// ʹ��DefaultTableModel����ģ��ʵ�������
			sorter = new TableRowSorter<DefaultTableModel>(model1);//����������
			table.setAutoCreateRowSorter(true);;//���ñ���Զ�����
			
			
			
	}

}
