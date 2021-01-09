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
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private DefaultTableModel model1;// 定义表格数据模型
	private JTextField txtKey;

	public static void main(String[] args) {
		Mtype frame = new Mtype();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 763, 378);
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(45, 89, 649, 219);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中
	
		// 使用动态数组数据（列标题与行数据）
				Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
				Collections.addAll(titles, "类型编号", "类型名称", "最大面积","最小重量","最大面积" ,"最小面积");
				String sql="select * from Mtype";//定义查询语句
				Vector<Vector> stuInfo = mt.searchAll(sql);// 从数据库中读取所有行数据
				
//				使用静态数据创建DefaultTableModel数据模型
				model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
					public Class getColumnClass(int column) {//获取列的类型
						Class returnValue;
						if ((column >= 0) && (column < getColumnCount())) {
							returnValue = getValueAt(0, column).getClass();
						} else {
							returnValue = Object.class;
						}
						return returnValue;
					}};
					table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
					
					scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
					
					JLabel lblKey = new JLabel("请输入类型编号：");
					lblKey.setBounds(67, 26, 149, 36);
					contentPane.add(lblKey);
					
					txtKey = new JTextField();
					txtKey.setBounds(219, 33, 183, 21);
					contentPane.add(txtKey);
					txtKey.setColumns(10);
					
					JButton btnFind = new JButton("查找");
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
							model1 = new DefaultTableModel(row, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
								public Class getColumnClass(int column) {//获取列的类型
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
					
					JButton btnNewButton = new JButton("返回");
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
