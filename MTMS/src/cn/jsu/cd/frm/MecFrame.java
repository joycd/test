package cn.jsu.cd.frm;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.jsu.cd.dao.impl.MechanicsDaoImpl;
import cn.jsu.cd.service.MechanicsService;
import cn.jsu.cd.service.PageService;
import cn.jsu.cd.service.UserService;
import cn.jsu.cd.service.impl.MechanicsServiceImpl;
import cn.jsu.cd.service.impl.UserServiceImpl;
import cn.jsu.cd.service.impl.PageServiceImpl;
import cn.jsu.cd.vo.NowString;
import cn.jsu.cd.vo.User;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MecFrame {

	private JFrame frame;
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private DefaultTableModel model1;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	private Vector<String> titles;
	Vector<Vector> bigList;
	int pagecount;
	int page;
	int pageNum;
	User user=new User();
	UserService userService=new UserServiceImpl();
	private JTextField textField;
	
	

	public JTextField getTxtKey() {
		return txtKey;
	}

	public void setTxtKey(JTextField txtKey) {
		this.txtKey = txtKey;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MecFrame window = new MecFrame();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);//窗体居中

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MecFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PageService pageservice=new PageServiceImpl();
		MechanicsService mecservice=new MechanicsServiceImpl();
		
		String sql="select * from Mechanics";
		bigList = mecservice.searchAll(sql);//获取第一页的数据
		int recode=bigList.size();//总行数
		System.out.println("总行数："+recode);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 82, 615, 210);// 设置大小与位置
		frame.getContentPane().add(scrollPane);
		
		
		
		
		
		JLabel lblKey = new JLabel("输入编号：");
		lblKey.setBounds(44, 44, 132, 25);
		frame.getContentPane().add(lblKey);
				
		txtKey = new JTextField();
		txtKey.setBounds(116, 45, 99, 21);
		frame.getContentPane().add(txtKey);
		txtKey.setColumns(10);
				
		//定义查找按钮
		JButton btnFind = new JButton("查找");
		btnFind.setBounds(229, 44, 95, 25);
		frame.getContentPane().add(btnFind);
				
				
				
				
				JButton btnNewButton = new JButton("上一页");
				btnNewButton.setBounds(44, 305, 113, 27);
				frame.getContentPane().add(btnNewButton);
				
				textField = new JTextField("1");
				textField.setBounds(158, 305, 57, 27);
				frame.getContentPane().add(textField);
				textField.setColumns(10);
				pageNum=Integer.parseInt(textField.getText().trim());//当前页
				System.out.println("当前页:"+pageNum);
				
				JButton btnNext = new JButton("下一页");
				btnNext.setBounds(217, 304, 113, 28);
				frame.getContentPane().add(btnNext);
				
				JLabel lblMsg = new JLabel("每页显示：");
				lblMsg.setBounds(447, 307, 105, 20);
				frame.getContentPane().add(lblMsg);
				
				
				
				//下拉框
				JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
				comboBox.setSelectedIndex(1);//设置下拉框默认值
				comboBox.setBounds(554, 305, 105, 23);
				frame.getContentPane().add(comboBox);
				pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());//每页显示多少条

				page=pageservice.getPage(pagecount, recode);//总页数
				
				JButton btnNewButton_1 = new JButton("删除");
				btnNewButton_1.setBounds(338, 44, 95, 25);
				frame.getContentPane().add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("添加机械");
				btnNewButton_2.setBounds(564, 44, 95, 25);
				frame.getContentPane().add(btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton("类型信息");
				btnNewButton_3.setBounds(332, 305, 113, 27);
				frame.getContentPane().add(btnNewButton_3);
				

				//表格				
				pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());
				pageNum=Integer.parseInt(textField.getText().trim());
				setTable(bigList, pageNum, pagecount);
				scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
				
				
				
				//下拉框
				comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
				public void itemStateChanged(ItemEvent e) {
					pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());//每页显示多少条
					page=pageservice.getPage(pagecount, recode);//总页数
					System.out.println("每页显示："+pagecount);
					System.out.println("总页数："+page);
						setTable(bigList, pageNum, pagecount);
						scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
					}
				});
				
				//上一页
				btnNewButton.addActionListener(new ActionListener() {//上一页单击事件
					@Override
					public void actionPerformed(ActionEvent e) {
						pageNum=pageservice.prePage(pageNum, page);
						setTable(bigList, pageNum, pagecount);
						textField.setText(pageNum+"");
						scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
					
					}
				});
				
				//页数框
				textField.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent arg0) {
						int pageNum1=Integer.parseInt(textField.getText().trim());//跳转页 
						if(pageNum1>page||pageNum1<=0){
							JOptionPane.showMessageDialog(null, "不存在该页面,页面范围：1-"+page+"页！");
							textField.setText(pageNum+"");
						}
						else {
							pageNum=pageNum1;
							setTable(bigList, pageNum, pagecount);
						textField.setText(pageNum+"");
						scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
						
			
						}
						
					   }    
					  });
				
				//下一页
				btnNext.addActionListener(new ActionListener() {//下一页单击事件
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("next");
						pageNum=pageservice.nextPage(pageNum, page);
						setTable(bigList, pageNum, pagecount);
						textField.setText(pageNum+"");
						scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
					
					}
				});
				
				JButton btn4 = new JButton("修改");
				btn4.setBounds(453, 44, 99, 25);
				frame.getContentPane().add(btn4);
				
				JLabel lblNewLabel = new JLabel("---重型机械信息---");
				lblNewLabel.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 18));
				lblNewLabel.setBounds(266, 0, 183, 45);
				frame.getContentPane().add(lblNewLabel);
				
				JButton btnNewButton_4 = new JButton("返回主页面");
				btnNewButton_4.setBounds(457, 345, 191, 27);
				frame.getContentPane().add(btnNewButton_4);
				//返回主页面
				btnNewButton_4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new First();
						First.main(null);
						frame.dispose();
					}
				});
				
				JButton btnNewButton_6 = new JButton("进入运输车管理系统");
				btnNewButton_6.setBounds(54, 345, 183, 27);
				frame.getContentPane().add(btnNewButton_6);
				
				JButton btnexcle = new JButton("导出为Excle");
				btnexcle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						File file=new File("./src/test1.xlsx");//定位要操作的excel文件
						mecservice.excleIn(bigList, file);
						JOptionPane.showMessageDialog(null, "导出成功");
					}
				});
				btnexcle.setBounds(285, 345, 113, 27);
				frame.getContentPane().add(btnexcle);
				btnNewButton_6.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						TraFrame.main(null);
						frame.dispose();
					}
				});
				//修改
			btn4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String key=txtKey.getText().trim();//获取输入关键字文本框的值
						if(key.length()==0){
							JOptionPane.showMessageDialog(null, "请输入编号!");
						}
						else{
							int id=Integer.parseInt(key);
							Vector<Vector> list=mecservice.searchById(id);
								if(list.size()!=0) {
									ModifyMec mMec=new ModifyMec();
									System.out.println(id);
									mMec.m_id(id);
									
									mMec.main(null);
								}else {
									JOptionPane.showMessageDialog(null, "请输入正确的编号!");
								}
						}
						
					}
				});
				
				//增加
				btnNewButton_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new AddMec();
						AddMec.main(null);
						frame.dispose();
					}
				});
				
				
				//类型
				btnNewButton_3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Mtype();
						Mtype.main(null);
						frame.dispose();
					}
				});
				
				//查找
				btnFind.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) { 
						String key=txtKey.getText().trim();//获取输入关键字文本框的值
						if(key.length()==0){
							JOptionPane.showMessageDialog(null, "请输入编号!");
						}
						else{
							int id=Integer.parseInt(key);
						Vector<Vector> list=mecservice.searchById(id);
								if(list.size()!=0) {
									setTable(list, 1, 1);
									scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
									
								}else {
									JOptionPane.showMessageDialog(null, "请输入正确的编号!");
								}
						}
					}
						
				});
				//删除
				btnNewButton_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String key=txtKey.getText().trim();//获取输入关键字文本框的值
						if(key.length()==0){
							JOptionPane.showMessageDialog(null, "请输入编号!");
						}
						else{
							int id=Integer.parseInt(key);
						Vector<Vector> list=mecservice.searchById(id);
								if(list.size()!=0) {
									mecservice.delete(id);
									JOptionPane.showMessageDialog(null, "删除成功!");
									bigList = mecservice.searchAll(sql);
									int recode=bigList.size();//总行数
									pagecount=Integer.parseInt(comboBox.getSelectedItem().toString());//每页显示多少条
									page=pageservice.getPage(pagecount, recode);//总页数
									textField.setText("1");
									pageNum=Integer.parseInt(textField.getText().trim());//当前页
									setTable(bigList, pageNum, pagecount);
									scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
								}else {
									JOptionPane.showMessageDialog(null, "请输入正确的编号!");
								}
						}
					}
				});
				
	
	}
	public void setTable(Vector<Vector> bigList,int pageNum,int pagecount){

		PageService pageservice=new PageServiceImpl();
		MechanicsService mecservice=new MechanicsServiceImpl();
		// 使用动态数组数据（列标题与行数据）
				titles = new Vector<String>();// 定义动态数组表示表格标题
				Collections.addAll(titles, "编号", "机械名", "重量(t)","所占面积(m2)","功能","出厂日期","类型编号","运输车编号");
			Vector<Vector> stuInfo1=pageservice.getPaegData(bigList, pageNum,pagecount);
			model1 = new DefaultTableModel(stuInfo1, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
				public Class getColumnClass(int column) {//获取列的类型
					Class returnValue;
					if ((column >= 0) && (column < getColumnCount())) {
						returnValue = getValueAt(0, column).getClass();
					} else {
						returnValue = Object.class;
					}
					return returnValue;
				}
			};
			table = new JTable(model1);// 使用DefaultTableModel数据模型实例化表格
			sorter = new TableRowSorter<DefaultTableModel>(model1);//设置排序器
			table.setAutoCreateRowSorter(true);;//设置表格自动排序
			
			
			
	}
}

	
	
