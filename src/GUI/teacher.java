package GUI;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;






public class teacher extends JFrame implements ActionListener{
	private JButton button1 =  new  JButton("��ѯ");
	private JButton button2 = new JButton("ͬ��");
	private JButton button3 = new JButton("�ܾ�");
	private JTextField tname = new JTextField();
	private JTextField id = new JTextField();
	private JTextField advice = new JTextField();
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	
	
	public static void main(String[] args) {
		new teacher();
		}
	
	public teacher() {
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("��ʦ��������");
		this.setBounds(100,200,807,504);
		this.setVisible(true);
		
		
	    //����name
		JLabel labelname = new JLabel("������");
		labelname.setAlignmentY(CENTER_ALIGNMENT);
		labelname.setBounds(25, 20, 70, 47);//�ֵ�λ��
		tname.setBounds(70, 30, 158, 30);//���λ��
		this.getContentPane().add(labelname);
		this.getContentPane().add(tname);
		
		//ѧ��id
		JLabel labelid = new JLabel("Ҫ�����ѧ��ѧ�ţ�");
		labelid.setAlignmentY(CENTER_ALIGNMENT);
		labelid.setBounds(45, 270, 183, 50);//�ֵ�λ��
		id.setBounds(180, 280, 240, 30);//���λ��
		this.getContentPane().add(labelid);
		this.getContentPane().add(id);
		
		//���advice
		JLabel labeladvice = new JLabel("\u5BA1\u6838\u610F\u89C1\r\n\uFF08\u540C\u610F\u53EF\u4EE5\u4E0D\u586B\u5199\uFF09\uFF1A");
		labeladvice.setAlignmentY(CENTER_ALIGNMENT);
		labeladvice.setBounds(45, 309, 210, 50);//�ֵ�λ��
		advice.setBounds(253, 323, 395, 74);//���λ��
		this.getContentPane().add(labeladvice);
		this.getContentPane().add(advice);
		
		
		//��ʾ�����Ϣ����
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(35, 73, 723, 192);
		getContentPane().add(scpDemo);

		

		//��ѯ��ť
		button1.setBounds(242, 28, 70, 30);
		this.getContentPane().add(button1);
		button1.addActionListener(this);
		
		//ͬ�ⰴť
		button2.setBounds(180, 426, 100, 30);
		this.getContentPane().add(button2);
		button2.addActionListener(this);
		
		//�ܾ���ť
		button3.setBounds(505, 426, 100, 30);
		this.getContentPane().add(button3);
		button3.addActionListener(this);
		
		this.setResizable(false);
		}
	


	//��ť�����޸�����
	@Override
	public void actionPerformed(ActionEvent e) {
		String Tname = tname.getText();
		if (e.getSource() == button1){
			Teasearch ts = new Teasearch();
			ts.setTname(Tname);
			try {
				Connection conn = Teasearch.getConnection();
				
				{

					Object[][] info = Teasearch.search(conn); // �����ݿ�����ת��Ϊjtable��
					// �����ͷ
					
					String[] title = { "ѧ��", "����","��ϵ��ʽ", "�������", "��ʼ����","��������","���ԭ��", "��˸���Ա","��˽��"};

					this.tabDemo = new JTable(info, title);

					this.jth = this.tabDemo.getTableHeader();

					this.scpDemo.setViewportView(tabDemo);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		
		if (e.getSource() == button2){
			String ID = id.getText();
			agree a=new agree();
			a.setID(ID);
			try {
				if (a.agree1()) {
					
					JOptionPane.showMessageDialog(null, "��ͬ�����������룡");
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
	
		if (e.getSource() == button3){
			String ID = id.getText();
			String Advice=advice.getText();
			deny d=new deny();
			d.setID(ID);
			d.setAdvice(Advice);
			try {
				if (d.deny1()) {
					
					JOptionPane.showMessageDialog(null, "�ѻؾ�����������룡");
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}		

	
}
