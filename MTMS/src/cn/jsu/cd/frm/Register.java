package cn.jsu.cd.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import cn.jsu.cd.dao.UserDao;
import cn.jsu.cd.dao.impl.UserDaoImpl;
import cn.jsu.cd.service.UserService;
import cn.jsu.cd.service.impl.UserServiceImpl;
import cn.jsu.cd.vo.NowString;
import cn.jsu.cd.vo.User;
import cn.jsu.cd.vo.Verification;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Register {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private String ver;
	int count=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		User user=new User();
		UserService userService=new UserServiceImpl();
		
		frame = new JFrame("注册");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/img/9.png")));
		frame.setBounds(100, 100, 315, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎注册");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(41, 0, 87, 20);
		frame.getContentPane().add(lblNewLabel);
		
		
		//用户名
		JLabel lblName = new JLabel("用户名：");
		lblName.setBounds(41, 44, 72, 18);
		frame.getContentPane().add(lblName);
	
		textField = new JTextField();//用户名
		textField.setBounds(142, 41, 136, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblName1 = new JLabel();
//		JLabel lblName1 = new JLabel("6-10位字母、数字、下划线,不以数字开头");//用户名提示框
		lblName1.setBounds(41, 75, 237, 18);
		frame.getContentPane().add(lblName1);
		
//		textField.addFocusListener(new FocusListener() {
//			int flag=0;
//			public void focusLost(FocusEvent e) {
//				//失去焦点的时候
//				
//				if(checkAccount(textField.getText())){
//					lblName1.setText("用户名正确");
//					lblName1.setForeground(Color.green);
//					if(count==0) count=1;
//				}
//				else {
//					lblName1.setText("用户名不符合要求，请重新输入");
//					lblName1.setForeground(Color.red);
//					count=0;
//				}
////				lblName1.setText("输入结束....");
//				flag++;
//				
//			}
//			public void focusGained(FocusEvent e) {
//				if(flag>0)
//				lblName1.setText("6-15位字母、数字、下划线,不以数字开头");
//			}
//		});
		
		
		
		//密码
		JLabel lblNewLabel_2 = new JLabel("密码：");
		lblNewLabel_2.setBounds(41, 107, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 104, 136, 24);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("6-20位的字母、数字、下划线");
		lblNewLabel_6.setBounds(41, 138, 237, 18);
		frame.getContentPane().add(lblNewLabel_6);
		
		passwordField.addFocusListener(new FocusListener() {
			int flag=0;
			public void focusLost(FocusEvent e) {
				//失去焦点的时候
				if(checkPassword(passwordField.getText())){
					lblNewLabel_6.setText("密码正确");
					lblNewLabel_6.setForeground(Color.green);
					if(count==1) count=2;
				}
				else {
					lblNewLabel_6.setText("密码不符合要求，请重新输入");
					lblNewLabel_6.setForeground(Color.red);
					count =1;
				}
				flag++;
			}
			public void focusGained(FocusEvent e) {
				if(flag>0)
					lblNewLabel_6.setText("6-10位字母、数字、下划线");
			}
		});
		
		
		
		
		//确认密码
		JLabel lblNewLabel_3 = new JLabel("确认密码:");
		lblNewLabel_3.setBounds(41, 169, 86, 18);
		frame.getContentPane().add(lblNewLabel_3);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(142, 166, 136, 24);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_7 = new JLabel("请再次输入密码!");
		lblNewLabel_7.setBounds(41, 200, 237, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		passwordField_1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//失去焦点的时候
				if(passwordField.getText().equals(passwordField_1.getText())){
					if(passwordField_1.getText().equals("")){
						lblNewLabel_7.setText("请输入密码");
						lblNewLabel_7.setForeground(Color.red);
						
					}
					else{
					lblNewLabel_7.setText("密码正确");
					lblNewLabel_7.setForeground(Color.green);
					if(count==2) count=3;
					}
				}
				else {
					lblNewLabel_7.setText("两次密码不同，请重新输入");
					lblNewLabel_7.setForeground(Color.red);
					count=2;
				}
			}
			public void focusGained(FocusEvent e) {
					
			}
		});
		
		
		
	//验证码
		JButton btnVerification = new JButton("点击获取验证码");
		btnVerification.setBounds(41, 231, 237, 77);
		
		frame.getContentPane().add(btnVerification);
		btnVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver=new Verification().getCheckCode();
				btnVerification.setText(ver);
				btnVerification.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 25));
				btnVerification.setForeground(Color.orange);
			}
		});
		

		textField_1 = new JTextField();
		textField_1.setBounds(41, 321, 98, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel Verlab = new JLabel("请输入验证码");
		Verlab.setFont(new Font("新宋体", Font.ITALIC, 16));
		Verlab.setForeground(Color.black);
		Verlab.setBounds(142, 321, 136, 27);
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
		
		
		
		
		JButton btnRegister = new JButton("注册");
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setFont(new Font("微软雅黑", Font.ITALIC, 18));
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(41, 358, 237, 27);
		frame.getContentPane().add(btnRegister);
		

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==4){
					user.setUsername(textField.getText().trim());
					user.setPassword(passwordField.getText().trim());
					user.setTime(new NowString().getTime());
					userService.addUser(user);
					int id=userService.getNewId();
					if(id!=0)					{
						JOptionPane.showMessageDialog(null, "注册成功\r\n请记住您的ID用来登录："+id);
						Sign sign=new Sign();
						sign.main(null);
					frame.dispose();
					}
					
					else JOptionPane.showMessageDialog(null, "应系统原因，注册失败！请重新注册");
				}
				else {
					JOptionPane.showMessageDialog(null, "请填好信息再注册");
				}
			}
		});
		
	}
	
	
	private boolean checkAccount(String accountNumber) {
		String valicateAccount="^[^0-9][\\w_]{5,14}$";
		//必须是6-15位字母、数字、下划线,不能以数字开头
		Pattern pattern = Pattern.compile(valicateAccount);
		Matcher matcher = pattern.matcher(accountNumber);
		boolean matches = matcher.matches();
		if(matches) {
			return true;
		}else {
			return false;
		}
	}
	
	 private boolean checkPassword(String passWord) {
			String valicatePassword="^[\\w_]{6,20}$";
			//6-20位的字母、数字、下划线
			Pattern pattern = Pattern.compile(valicatePassword);
			Matcher matcher = pattern.matcher(passWord);
			boolean matches = matcher.matches();
			if(matches) {
				return true;
			}else {
				return false;
			}
		}
	 
	 

}
