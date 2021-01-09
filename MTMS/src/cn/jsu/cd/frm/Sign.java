package cn.jsu.cd.frm;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.jsu.cd.service.UserService;
import cn.jsu.cd.service.impl.UserServiceImpl;
import cn.jsu.cd.vo.NowString;
import cn.jsu.cd.vo.User;
import cn.jsu.cd.vo.Verification;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class Sign {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textid;
	private String ver;
	int count=0;
	User user=new User();
	UserService userService=new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign window = new Sign();
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
	public Sign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("登录");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Sign.class.getResource("/img/9.png")));
		frame.setBounds(100, 100, 329, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		JLabel label = new JLabel("欢迎使用");
		label.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(120, 10, 161, 40);
		frame.getContentPane().add(label);
		
		
		//id

		JLabel labid = new JLabel("ID:");
		labid.setBounds(34, 50, 72, 18);
		frame.getContentPane().add(labid);
		
		textid = new JTextField();
		textid.setBounds(112, 47, 169, 24);
		frame.getContentPane().add(textid);
		textid.setColumns(10);
		
		JLabel labid1 = new JLabel("请输入您的id号");
		labid1.setBounds(34, 86, 247, 18);
		frame.getContentPane().add(labid1);
		
		textid.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//失去焦点的时候
				int id1=Integer.parseInt(textid.getText());
				user=userService.serchId(id1);
				if(user.getId()!=0){
					labid1.setText("ID正确");
					labid1.setForeground(Color.green);
					if(count==0) count = 1;
				}
				else {
					labid1.setText("ID错误，请重新输入");
					labid1.setForeground(Color.red);
					count=1;
				}
			}
			public void focusGained(FocusEvent e) {
				labid1.setText("请输入您的ID号");
			}
		});
		
		//用户名
		JLabel lblUser = new JLabel("用户名：");
		lblUser.setBounds(34, 120, 72, 18);
		frame.getContentPane().add(lblUser);
		
		textField = new JTextField();
		textField.setBounds(112, 117, 169, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("请输入您的用户名");
		lblNewLabel_1.setBounds(34, 151, 247, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//失去焦点的时候
				if(user.getUsername().compareTo(textField.getText())==0){
					lblNewLabel_1.setText("用户名正确");
					lblNewLabel_1.setForeground(Color.green);
					if(count==1) count = 2;
				}
				else {
					lblNewLabel_1.setText("用户名错误，请重新输入");
					lblNewLabel_1.setForeground(Color.red);
					count=1;
				}
			}
			public void focusGained(FocusEvent e) {
			}
		});
		
		//密码
		
		JLabel lblPassword = new JLabel("密码：");
		lblPassword.setBounds(34, 182, 72, 18);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 182, 169, 21);
		frame.getContentPane().add(passwordField);
		JLabel lblNewLabel_4 = new JLabel("请输入密码");
		
		lblNewLabel_4.setBounds(34, 213, 247, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		passwordField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//失去焦点的时候
				if(user.getPassword().compareTo(passwordField.getText())==0){
					lblNewLabel_4.setText("密码正确");
					lblNewLabel_4.setForeground(Color.green);
					if(count==2) count = 3;
				}
				else {
					lblNewLabel_4.setText("密码错误，请重新输入");
					lblNewLabel_4.setForeground(Color.red);
					count = 3;
				}
			}
			public void focusGained(FocusEvent e) {
			}
		});
		
		//验证码
				JButton btnVerification = new JButton("点击获取验证码");
				btnVerification.setBounds(34, 244, 237, 77);
				
				frame.getContentPane().add(btnVerification);
				btnVerification.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ver=new Verification().getCheckCode();
						btnVerification.setText(ver);
						btnVerification.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 30));
						btnVerification.setForeground(Color.orange);
					}
				});
				

				textField_1 = new JTextField();
				textField_1.setBounds(34, 334, 98, 24);
				frame.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				
				JLabel Verlab = new JLabel("请输入验证码");
				Verlab.setFont(new Font("新宋体", Font.ITALIC, 16));
				Verlab.setForeground(Color.black);
				Verlab.setBounds(145, 334, 136, 27);
				frame.getContentPane().add(Verlab);
				

				textField_1.addFocusListener(new FocusListener() {
					public void focusLost(FocusEvent e) {
						//失去焦点的时候
						if(btnVerification.getText().equals(textField_1.getText())){
							Verlab.setText("验证码正确");
							Verlab.setForeground(Color.green);
							if(count==3) count = 4;
						}
						else {
							Verlab.setText("验证码错误!");
							Verlab.setForeground(Color.red);
							count=3;
						}
					}
					public void focusGained(FocusEvent e) {
							
					}
				});
				
		//登录
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(34, 382, 113, 27);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {// 窗体类中按钮单击事件
			public void actionPerformed(ActionEvent e) {
				if(count==4){
					JOptionPane.showMessageDialog(null, "登录成功");
					String time=new NowString().getTime();
					String username=textField.getText().trim();
					String idname=textid.getText().trim();
					userService.In(idname, username, time);
					int id1=Integer.parseInt(textid.getText().trim());
					First fir=new First();
					fir.id(id1);
					fir.main(null);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "请填好信息再登录");
					}
			}
		});
		//注册
		JButton btnRegister = new JButton("注册");
		btnRegister.setBounds(166, 382, 115, 27);
		frame.getContentPane().add(btnRegister);
		
		btnRegister.addActionListener(new ActionListener() {// 窗体类中按钮单击事件
			public void actionPerformed(ActionEvent e) {
				new Register();
				Register.main(null);
				frame.dispose();
				
			}

			});
	}
}
