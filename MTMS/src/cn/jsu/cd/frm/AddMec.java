package cn.jsu.cd.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import cn.jsu.cd.service.MechanicsService;
import cn.jsu.cd.service.impl.MechanicsServiceImpl;
import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.NowString;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMec {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMec window = new AddMec();
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
	public AddMec() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("重型机械添加");
		frame.setBounds(100, 100, 533, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("机械名：");
		lblNewLabel.setBounds(57, 41, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 38, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("重量：");
		lblNewLabel_1.setBounds(287, 41, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(373, 38, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("面积：");
		lblNewLabel_2.setBounds(57, 104, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 101, 86, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("功能：");
		lblNewLabel_3.setBounds(287, 104, 72, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(373, 101, 86, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("机械类型：");
		lblNewLabel_4.setBounds(57, 162, 86, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 159, 86, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.setBounds(287, 207, 113, 27);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MecFrame();
				MecFrame.main(null);
				frame.dispose();
			}
		});
		JButton btnNewButton_1 = new JButton("添加");
		btnNewButton_1.setBounds(116, 207, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		Mechanics mec=new Mechanics();
		
		MechanicsService mservice=new MechanicsServiceImpl();
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		
		if(textField_1.getText().equals("")||textField.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")){
			JOptionPane.showMessageDialog(null, "请输入相关信息");
		}
		else{
			mec.setM_name(textField_1.getText().trim());
			mec.setM_weight(Float.parseFloat(textField.getText().trim()));
			mec.setM_area(Float.parseFloat(textField_2.getText().trim()));
			mec.setM_function(textField_3.getText().trim());
			mec.setM_time(new NowString().getTime());
			mec.setTy_id(Integer.parseInt(textField_4.getText().trim()));
			JOptionPane.showMessageDialog(null, "添加成功：\r\n"
				+"编号："+(mservice.getNewId()+1)+"\r\n机械名称："+mec.getM_name()
				+"\r\n机械重量："+mec.getM_weight()
				+"t\r\n机械面积："+mec.getM_area()
				+"m^2\r\n功能："+mec.getM_function()
				+"\r\n出厂时间："+mec.getM_time()
				+"\r\n机械类型："+mec.getTy_id());
				mservice.add(mec);
				new MecFrame();
				MecFrame.main(null);
				frame.dispose();
				
		}
		
			}
		});
		
	}
}
