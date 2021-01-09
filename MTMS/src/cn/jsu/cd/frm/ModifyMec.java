package cn.jsu.cd.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.jsu.cd.service.MechanicsService;
import cn.jsu.cd.service.PageService;
import cn.jsu.cd.service.TransportService;
import cn.jsu.cd.service.impl.MechanicsServiceImpl;
import cn.jsu.cd.service.impl.PageServiceImpl;
import cn.jsu.cd.service.impl.TransportServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class ModifyMec {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private static int m_id=2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ModifyMec window = new ModifyMec();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);//窗体居中

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void m_id(int id){
		System.out.println(id);
		this.m_id=id;
		System.out.println(m_id);
	}

	/**
	 * Create the application.
	 */
	public ModifyMec() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if(m_id!=0){
			PageService pageservice=new PageServiceImpl();
			MechanicsService mecservice=new MechanicsServiceImpl();
			TransportService tservice=new TransportServiceImpl();
			Vector<Vector> mec=mecservice.searchById(this.m_id);
			
			
			frame = new JFrame();
			frame.setBounds(100, 100, 532, 383);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddMec.class.getResource("/img/15.png")));

			
			JLabel label = new JLabel("机械编号：");
			label.setBounds(48, 54, 86, 18);
			frame.getContentPane().add(label);
			
			textField = new JTextField();
			textField.setText(mec.get(0).get(0)+"");
			textField.setBounds(134, 51, 86, 24);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			textField.setEditable(false);
			
			JLabel lblNewLabel = new JLabel("机械名称：");
			lblNewLabel.setBounds(288, 54, 86, 18);
			frame.getContentPane().add(lblNewLabel);
			
			textField_1 = new JTextField();
			textField_1.setBounds(388, 51, 86, 24);
			textField_1.setText(mec.get(0).get(1)+"");
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("重量：");
			lblNewLabel_1.setBounds(48, 102, 72, 18);
			frame.getContentPane().add(lblNewLabel_1);
			
			textField_2 = new JTextField();
			textField_2.setBounds(134, 99, 86, 24);
			textField_2.setText(mec.get(0).get(2)+"");
			frame.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("面积：");
			lblNewLabel_2.setBounds(48, 145, 72, 18);
			frame.getContentPane().add(lblNewLabel_2);
			
			textField_3 = new JTextField();
			textField_3.setBounds(134, 145, 86, 24);
			textField_3.setText(mec.get(0).get(3)+"");
			frame.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("功能：");
			lblNewLabel_3.setBounds(48, 194, 72, 18);
			frame.getContentPane().add(lblNewLabel_3);
			
			textField_4 = new JTextField();
			textField_4.setBounds(134, 191, 340, 24);
			textField_4.setText(mec.get(0).get(4)+"");
			frame.getContentPane().add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("出厂日期：");
			lblNewLabel_4.setBounds(48, 235, 94, 18);
			frame.getContentPane().add(lblNewLabel_4);
			
			textField_5 = new JTextField();
			textField_5.setBounds(134, 228, 340, 24);
			textField_5.setText(mec.get(0).get(5)+"");
			frame.getContentPane().add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("类型编号：");
			lblNewLabel_5.setBounds(288, 102, 94, 18);
			frame.getContentPane().add(lblNewLabel_5);
			
			textField_6 = new JTextField();
			textField_6.setBounds(388, 102, 86, 24);
			textField_6.setText(mec.get(0).get(6)+"");
			frame.getContentPane().add(textField_6);
			textField_6.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("运输车编号：");
			lblNewLabel_6.setBounds(288, 151, 94, 18);
			frame.getContentPane().add(lblNewLabel_6);
			
			textField_7 = new JTextField();
			textField_7.setBounds(388, 148, 86, 24);
			textField_7.setText(mec.get(0).get(7)+"");
			frame.getContentPane().add(textField_7);
			textField_7.setColumns(10);
			
//			for (int i = 0; i < 8; i++) {
//				System.out.println(mec.get(0).get(i));	
//			}
			
			JButton btnNewButton = new JButton("修改");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(134, 285, 113, 27);
			frame.getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("返回");
			btnNewButton_1.setBounds(285, 285, 113, 27);
			frame.getContentPane().add(btnNewButton_1);
			
			JLabel lblNewLabel_7 = new JLabel("---修改重型机械信息---");
			lblNewLabel_7.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel_7.setBounds(134, 0, 264, 46);
			frame.getContentPane().add(lblNewLabel_7);
			
			//返回
			btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			
			//修改
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int t_id=Integer.parseInt(textField_7.getText());
					Vector<Vector> tra=tservice.searchById(t_id);
					
						if(tra.size()!=0){
							int k=(int) tra.get(0).get(6);
							System.out.println(k);
							if(k==0){
								String sql="update Mechanics set m_name="+"'"+textField_1.getText()+"'"+
								",m_weight="+Float.parseFloat(textField_2.getText())+
								",m_area="+Float.parseFloat(textField_3.getText())+
								",m_function="+"'"+textField_4.getText()+"'"+
								",m_time="+"'"+textField_5.getText()+"'"+
								",ty_id="+Integer.parseInt(textField_6.getText())+
								",t_id="+Integer.parseInt(textField_7.getText())+
								" where m_id = "+mec.get(0).get(0);
							
							
						
							String sql1="update Transport set t_flag=1 where t_id="+textField_7.getText().trim();
							mecservice.updata(sql);
							
							JOptionPane.showMessageDialog(null, "重型机械修改成功！");
							tservice.updata(sql1);
							JOptionPane.showMessageDialog(null, "运输车同步成功！");
							}else {
								JOptionPane.showMessageDialog(null, "运输车正在运输中！");
							}
						}else {
							JOptionPane.showMessageDialog(null, "运输车信息填写错误！");
						
					}
					
					
					
				}
			});
			
		}
		
	}
}
