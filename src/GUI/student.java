package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;

public class student extends JFrame implements ActionListener {
	private JButton button1 = new JButton("��ѯ");
	private JButton button2 = new JButton("���");
	private JButton button3 = new JButton("����");
	private JTextField ID = new JTextField();
	
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JScrollPane scpDemo_1;
	private JTableHeader jth1;
	private JTable tabDemo1;
	

	public static void main(String[] args) {
		new student();
	}

	public student() {
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ѧ����ٽ���");
		this.setBounds(100, 200, 712, 500);
		this.setVisible(true);

		// ѧ��studentid
		JLabel labelid = new JLabel("ѧ�ţ�");
		labelid.setAlignmentY(CENTER_ALIGNMENT);
		labelid.setBounds(55, 37, 45, 47);// �ֵ�λ��
		ID.setBounds(114, 45, 178, 30);// ���λ��
		this.getContentPane().add(labelid);
		this.getContentPane().add(ID);

		// ��ѯ��ť
		button1.setBounds(315, 45, 100, 30);
		this.getContentPane().add(button1);
		button1.addActionListener(this);

		// ��ٰ�ť
		button2.setBounds(182, 369, 100, 30);
		this.getContentPane().add(button2);
		button2.addActionListener(this);

		// ���ٰ�ť
		button3.setBounds(434, 369, 100, 30);
		this.getContentPane().add(button3);
		
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(56, 99, 592, 123);
		getContentPane().add(scpDemo);
		
		this.scpDemo_1 = new JScrollPane();
		this.scpDemo_1.setBounds(56, 249, 359, 75);
		getContentPane().add(scpDemo_1);
		
		button3.addActionListener(this);

		this.setResizable(false);
	}

	// ��ť�����޸�����
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id = ID.getText();

		if (e.getSource() == button1) {
			SQJsearch sqj = new SQJsearch();
			SQJsearch1 sqj1 = new SQJsearch1();
			sqj.setID(id);
			sqj1.setID(id);
			try {
				Connection conn = SQJsearch.getConnection();
				Connection conn1 = SQJsearch1.getConnection();
				{

					Object[][] info = SQJsearch.search(conn); // �����ݿ�����ת��Ϊjtable��
					// �����ͷ
					
					String[] title = { "ѧ��", "����","��ϵ��ʽ", "�������", "��ʼ����","��������","���ԭ��"};

					this.tabDemo = new JTable(info, title);

					this.jth = this.tabDemo.getTableHeader();

					this.scpDemo.setViewportView(tabDemo);
					
					Object[][] info1 = SQJsearch1.search(conn1); // �����ݿ�����ת��Ϊjtable��
					// �����ͷ
					
					String[] title1 = { "��˸���Ա","��˽��"};

					this.tabDemo1 = new JTable(info1, title1);

					this.jth = this.tabDemo1.getTableHeader();

					this.scpDemo_1.setViewportView(tabDemo1);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
						JOptionPane.ERROR_MESSAGE);

			}
		}

		if (e.getSource() == button2) {
			// ����ȷ����ٴ���
			 new second();
			// �رյ�ǰ����
			 this.dispose();
		}

		if (e.getSource() == button3) {

			xiaojia xj = new xiaojia();
			xj.setID(id);
			try {
				if (xj.delete()) {
					
					JOptionPane.showMessageDialog(null, "���ٳɹ���");

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