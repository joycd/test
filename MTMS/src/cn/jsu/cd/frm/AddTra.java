package cn.jsu.cd.frm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.jsu.cd.service.MechanicsService;
import cn.jsu.cd.service.TransportService;
import cn.jsu.cd.service.impl.MechanicsServiceImpl;
import cn.jsu.cd.service.impl.TransportServiceImpl;
import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.NowString;
import cn.jsu.cd.vo.Transport;

import java.awt.Font;
import java.awt.Toolkit;

public class AddTra {


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
					AddTra window = new AddTra();
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
	public AddTra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("���ͻ�е���");
		frame.setBounds(100, 100, 533, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TraFrame.class.getResource("/img/8.png")));

		JLabel lblNewLabel = new JLabel("���䳵��ɫ��");
		lblNewLabel.setBounds(57, 41, 106, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 38, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("���������");
		lblNewLabel_1.setBounds(287, 41, 113, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(397, 38, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("�������ͣ�");
		lblNewLabel_2.setBounds(57, 104, 106, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(165, 101, 86, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("��Ӫ֤�ţ�");
		lblNewLabel_3.setBounds(287, 104, 113, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(397, 101, 86, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("����������");
		lblNewLabel_4.setBounds(57, 162, 86, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(165, 159, 86, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.setBounds(287, 207, 113, 27);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TraFrame.main(null);
				frame.dispose();
			}
		});
		JButton btnNewButton_1 = new JButton("���");
		btnNewButton_1.setBounds(116, 207, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("---�������䳵---");
		lblNewLabel_5.setFont(new Font("����", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(186, 7, 170, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		
		Transport tra=new Transport();
		
		TransportService mservice=new TransportServiceImpl();
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		
		if(textField_1.getText().equals("")||textField.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")){
			JOptionPane.showMessageDialog(null, "�����������Ϣ");
		}
		else{
			tra.setT_color(textField_1.getText().trim());
			tra.setT_carry(Float.parseFloat(textField.getText().trim()));
			tra.setT_brand(textField_2.getText().trim());
			tra.setT_license(textField_3.getText().trim());
			tra.setT_tonnage(Float.parseFloat(textField_4.getText().trim()));
			tra.setT_time(new NowString().getTime());
			JOptionPane.showMessageDialog(null, "��ӳɹ���\r\n"
				+"��ţ�"+(mservice.getNewId()+1)+"\r\n������ɫ��"+tra.getT_color()
				+"\r\n���������"+tra.getT_carry()
				+"m2\r\n�������ͣ�"+tra.getT_brand()
				+"\r\n��Ӫ֤�ţ�"+tra.getT_license()
				+"\r\n����������"+tra.getT_tonnage()
				+"t\r\n����ʱ�䣺"+tra.getT_time());
				mservice.add(tra);
				new TraFrame();
				TraFrame.main(null);
				frame.dispose();
				
		}
		
			}
		});
	}
}
