package cn.jsu.cd.frm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.jsu.cd.service.UserService;
import cn.jsu.cd.service.impl.UserServiceImpl;
import cn.jsu.cd.vo.User;

import javax.swing.JButton;

public class Person {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Person window = new Person();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);//窗体居中

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void id(int userid){
		
		this.id=userid;
	}
	/**
	 * Create the application.
	 */
	public Person() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("2:"+this.id);
		UserService userService=new UserServiceImpl();
		
		User user=userService.serchId(this.id);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("---管理员信息---");
		lblNewLabel.setBounds(164, 0, 143, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("编号:");
		lblNewLabel_1.setBounds(75, 54, 106, 18);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(234, 51, 113, 24);
		textField.setText(user.getId()+"");
		textField.setEnabled(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("用户名：");
		lblNewLabel_2.setBounds(75, 118, 106, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 115, 113, 24);
		textField_1.setText(user.getUsername());
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("切换账号");
		btnNewButton.setBounds(68, 169, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setBounds(234, 169, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		//切换登录
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sign();
				Sign.main(null);
			}
		});
		//返回
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new First().main(null);
				frame.dispose();
			}
		});
	}
}
