package cn.jsu.cd.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.jsu.cd.dao.UserDao;
import cn.jsu.cd.vo.User;
import cn.jsu.cd.service.UserService;
import cn.jsu.cd.service.impl.UserServiceImpl;

import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class First {

	private JFrame frame;
	static int id;
	/**
	 * Launch the application.
	 * @return 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();

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
	public void id(int userid){
		id=userid;
	}
	public First() {
		initialize() ;
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		UserService userService=new UserServiceImpl();
		
		User user=userService.serchId(id);
		
		frame = new JFrame("重型机械运输管理系统");
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(First.class.getResource("/img/4.png")));
		frame.setBounds(100, 100, 732, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("登录/注册");
		System.out.println(user.getUsername());
		button.setText(user.getUsername());
//		button.setIcon(new ImageIcon(First.class.getResource("/img/5.png")));
		button.setBounds(576, 0, 138, 27);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {// 窗体类中按钮单击事件

			public void actionPerformed(ActionEvent e) {
				Person per=new Person();
				per.id(id);
				per.main(null);
//				frame.dispose();
				
			}

			});
		
		//机械模块
		JLabel lblNewLabel = new JLabel("重型机械信息");
		lblNewLabel.setBounds(0, 4, 106, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("重型机械");
		btnNewButton.setIcon(new ImageIcon(First.class.getResource("/img/2.jpg")));
		btnNewButton.setBounds(93, 0, 113, 27);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MecFrame.main(null);
				frame.dispose();
				
				
			}
		});
		
		
		
		//运输车模块
		JButton btnSign = new JButton("运输车");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSign.setIcon(new ImageIcon(First.class.getResource("/img/3.png")));
		btnSign.setBounds(311, 0, 113, 27);
		frame.getContentPane().add(btnSign);
		btnSign.addActionListener(new ActionListener() {// 窗体类中按钮单击事件

			public void actionPerformed(ActionEvent e) {
				TraFrame.main(null);
				frame.dispose();
			}

			});


		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 27, 714, 303);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("欢迎使用");
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_3.setBounds(247, 32, 189, 208);
		panel.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("运输车信息");
		lblNewLabel_1.setBounds(234, 0, 91, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
	
	}
}
