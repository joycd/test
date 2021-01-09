package cn.jsu.cd.frm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
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

public class ModifyTra {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private static int t_id=2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyTra window = new ModifyTra();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);//�������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void t_id(int id){
		System.out.println(id);
		this.t_id=id;
	}

	/**
	 * Create the application.
	 */
	public ModifyTra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if(t_id!=0){
			PageService pageservice=new PageServiceImpl();
			TransportService mecservice=new TransportServiceImpl();
			Vector<Vector> mec=mecservice.searchById(this.t_id);
			
			
			frame = new JFrame();
			frame.setBounds(100, 100, 532, 383);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel label = new JLabel("���䳵��ţ�");
			label.setBounds(48, 54, 86, 18);
			frame.getContentPane().add(label);
			
			textField = new JTextField();
			textField.setText(mec.get(0).get(0)+"");
			textField.setBounds(134, 51, 86, 24);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			textField.setEditable(false);
			
			JLabel lblNewLabel = new JLabel("������ɫ��");
			lblNewLabel.setBounds(288, 54, 86, 18);
			frame.getContentPane().add(lblNewLabel);
			
			textField_1 = new JTextField();
			textField_1.setBounds(388, 51, 86, 24);
			textField_1.setText(mec.get(0).get(1)+"");
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("���������");
			lblNewLabel_1.setBounds(48, 102, 72, 18);
			frame.getContentPane().add(lblNewLabel_1);
			
			textField_2 = new JTextField();
			textField_2.setBounds(134, 99, 86, 24);
			textField_2.setText(mec.get(0).get(2)+"");
			frame.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("�������ͣ�");
			lblNewLabel_2.setBounds(48, 145, 72, 18);
			frame.getContentPane().add(lblNewLabel_2);
			
			textField_3 = new JTextField();
			textField_3.setBounds(134, 145, 86, 24);
			textField_3.setText(mec.get(0).get(3)+"");
			frame.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("��Ӫ֤�ţ�");
			lblNewLabel_3.setBounds(48, 194, 72, 18);
			frame.getContentPane().add(lblNewLabel_3);
			
			textField_4 = new JTextField();
			textField_4.setBounds(134, 191, 340, 24);
			textField_4.setText(mec.get(0).get(4)+"");
			frame.getContentPane().add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("����������");
			lblNewLabel_4.setBounds(288, 151, 94, 18);
			frame.getContentPane().add(lblNewLabel_4);
			
			textField_5 = new JTextField();
			textField_5.setBounds(388, 148, 86, 24);
			textField_5.setText(mec.get(0).get(5)+"");
			frame.getContentPane().add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("�Ƿ��ɷ���");
			lblNewLabel_5.setBounds(288, 102, 94, 18);
			frame.getContentPane().add(lblNewLabel_5);
			
			textField_6 = new JTextField();
			textField_6.setBounds(388, 102, 86, 24);
			textField_6.setText(mec.get(0).get(6)+"");
			frame.getContentPane().add(textField_6);
			textField_6.setColumns(10);
			textField_6.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent arg0) {
					int k=Integer.parseInt(textField_6.getText());
					if((int)mec.get(0).get(6)==0){
						JOptionPane.showMessageDialog(null, "�޷��޸�\r\n�ɷ����䳵��ǰ����еģ�飡");
						textField_6.setText(mec.get(0).get(6)+"");
				   }
					else{
						if(k==0){
							JOptionPane.showMessageDialog(null, "�����������ɷ���");
						}else if(k==1){
							textField_6.setText(k+"");
						}else{
							JOptionPane.showMessageDialog(null, "����ȷ���룺"
									+ "\r\n�ǣ�1"+"\r\n��0");
						}
						
					}
					
				   }
				  });
			
			
			JLabel lblNewLabel_6 = new JLabel("����ʱ�䣺");
			lblNewLabel_6.setBounds(48, 235, 94, 18);
			frame.getContentPane().add(lblNewLabel_6);
			
			textField_7 = new JTextField();
			textField_7.setBounds(134, 228, 340, 24);
			textField_7.setText(mec.get(0).get(7)+"");
			frame.getContentPane().add(textField_7);
			textField_7.setColumns(10);
			
//			for (int i = 0; i < 8; i++) {
//				System.out.println(mec.get(0).get(i));	
//			}
			
			JButton btnNewButton = new JButton("�޸�");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(134, 285, 113, 27);
			frame.getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("����");
			btnNewButton_1.setBounds(285, 285, 113, 27);
			frame.getContentPane().add(btnNewButton_1);
			
			JLabel lblNewLabel_7 = new JLabel("---�޸����䳵��Ϣ---");
			lblNewLabel_7.setFont(new Font("����", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel_7.setBounds(134, 0, 264, 46);
			frame.getContentPane().add(lblNewLabel_7);
			
			//����
			btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			
			//�޸�
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int key=Integer.parseInt(textField_6.getText());
//					if(key==0)
					String sql="update Transport set t_color="+"'"+textField_1.getText()+"'"+
							",t_carry="+Float.parseFloat(textField_2.getText())+
							",t_brand="+"'"+textField_3.getText()+"'"+
							",t_license="+"'"+textField_4.getText()+"'"+
							",t_tonnage="+Float.parseFloat(textField_5.getText())+
							",t_flag="+Integer.parseInt(textField_6.getText())+
							",t_time="+"'"+textField_7.getText()+"'"+
							" where t_id = "+mec.get(0).get(0);
					
					mecservice.updata(sql);
					JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				}
			});
			
		}
		
	}

}
