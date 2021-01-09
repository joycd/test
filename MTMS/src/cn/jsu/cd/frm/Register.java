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
					window.frame.setLocationRelativeTo(null);//�������
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
		
		frame = new JFrame("ע��");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/img/9.png")));
		frame.setBounds(100, 100, 315, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��ӭע��");
		lblNewLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(41, 0, 87, 20);
		frame.getContentPane().add(lblNewLabel);
		
		
		//�û���
		JLabel lblName = new JLabel("�û�����");
		lblName.setBounds(41, 44, 72, 18);
		frame.getContentPane().add(lblName);
	
		textField = new JTextField();//�û���
		textField.setBounds(142, 41, 136, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblName1 = new JLabel();
//		JLabel lblName1 = new JLabel("6-10λ��ĸ�����֡��»���,�������ֿ�ͷ");//�û�����ʾ��
		lblName1.setBounds(41, 75, 237, 18);
		frame.getContentPane().add(lblName1);
		
//		textField.addFocusListener(new FocusListener() {
//			int flag=0;
//			public void focusLost(FocusEvent e) {
//				//ʧȥ�����ʱ��
//				
//				if(checkAccount(textField.getText())){
//					lblName1.setText("�û�����ȷ");
//					lblName1.setForeground(Color.green);
//					if(count==0) count=1;
//				}
//				else {
//					lblName1.setText("�û���������Ҫ������������");
//					lblName1.setForeground(Color.red);
//					count=0;
//				}
////				lblName1.setText("�������....");
//				flag++;
//				
//			}
//			public void focusGained(FocusEvent e) {
//				if(flag>0)
//				lblName1.setText("6-15λ��ĸ�����֡��»���,�������ֿ�ͷ");
//			}
//		});
		
		
		
		//����
		JLabel lblNewLabel_2 = new JLabel("���룺");
		lblNewLabel_2.setBounds(41, 107, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 104, 136, 24);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("6-20λ����ĸ�����֡��»���");
		lblNewLabel_6.setBounds(41, 138, 237, 18);
		frame.getContentPane().add(lblNewLabel_6);
		
		passwordField.addFocusListener(new FocusListener() {
			int flag=0;
			public void focusLost(FocusEvent e) {
				//ʧȥ�����ʱ��
				if(checkPassword(passwordField.getText())){
					lblNewLabel_6.setText("������ȷ");
					lblNewLabel_6.setForeground(Color.green);
					if(count==1) count=2;
				}
				else {
					lblNewLabel_6.setText("���벻����Ҫ������������");
					lblNewLabel_6.setForeground(Color.red);
					count =1;
				}
				flag++;
			}
			public void focusGained(FocusEvent e) {
				if(flag>0)
					lblNewLabel_6.setText("6-10λ��ĸ�����֡��»���");
			}
		});
		
		
		
		
		//ȷ������
		JLabel lblNewLabel_3 = new JLabel("ȷ������:");
		lblNewLabel_3.setBounds(41, 169, 86, 18);
		frame.getContentPane().add(lblNewLabel_3);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(142, 166, 136, 24);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_7 = new JLabel("���ٴ���������!");
		lblNewLabel_7.setBounds(41, 200, 237, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		passwordField_1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//ʧȥ�����ʱ��
				if(passwordField.getText().equals(passwordField_1.getText())){
					if(passwordField_1.getText().equals("")){
						lblNewLabel_7.setText("����������");
						lblNewLabel_7.setForeground(Color.red);
						
					}
					else{
					lblNewLabel_7.setText("������ȷ");
					lblNewLabel_7.setForeground(Color.green);
					if(count==2) count=3;
					}
				}
				else {
					lblNewLabel_7.setText("�������벻ͬ������������");
					lblNewLabel_7.setForeground(Color.red);
					count=2;
				}
			}
			public void focusGained(FocusEvent e) {
					
			}
		});
		
		
		
	//��֤��
		JButton btnVerification = new JButton("�����ȡ��֤��");
		btnVerification.setBounds(41, 231, 237, 77);
		
		frame.getContentPane().add(btnVerification);
		btnVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver=new Verification().getCheckCode();
				btnVerification.setText(ver);
				btnVerification.setFont(new Font("����", Font.BOLD | Font.ITALIC, 25));
				btnVerification.setForeground(Color.orange);
			}
		});
		

		textField_1 = new JTextField();
		textField_1.setBounds(41, 321, 98, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel Verlab = new JLabel("��������֤��");
		Verlab.setFont(new Font("������", Font.ITALIC, 16));
		Verlab.setForeground(Color.black);
		Verlab.setBounds(142, 321, 136, 27);
		frame.getContentPane().add(Verlab);
		

		textField_1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//ʧȥ�����ʱ��
				if(btnVerification.getText().equals(textField_1.getText())){
					Verlab.setText("��֤����ȷ");
					Verlab.setForeground(Color.green);
					if(count==3) count = 4;
				}
				else {
					Verlab.setText("��֤�����!");
					Verlab.setForeground(Color.red);
					count=3;
				}
			}
			public void focusGained(FocusEvent e) {
					
			}
		});
		
		
		
		
		JButton btnRegister = new JButton("ע��");
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setFont(new Font("΢���ź�", Font.ITALIC, 18));
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
						JOptionPane.showMessageDialog(null, "ע��ɹ�\r\n���ס����ID������¼��"+id);
						Sign sign=new Sign();
						sign.main(null);
					frame.dispose();
					}
					
					else JOptionPane.showMessageDialog(null, "Ӧϵͳԭ��ע��ʧ�ܣ�������ע��");
				}
				else {
					JOptionPane.showMessageDialog(null, "�������Ϣ��ע��");
				}
			}
		});
		
	}
	
	
	private boolean checkAccount(String accountNumber) {
		String valicateAccount="^[^0-9][\\w_]{5,14}$";
		//������6-15λ��ĸ�����֡��»���,���������ֿ�ͷ
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
			//6-20λ����ĸ�����֡��»���
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
