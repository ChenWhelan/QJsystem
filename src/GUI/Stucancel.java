package GUI;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Stucancel extends JFrame implements ActionListener {
	private JButton button = new JButton("��ѯ");
	private JButton button1 = new JButton("\u6CE8\u9500");
	private JTableHeader jth;
	private JTable tabDemo;
	private JScrollPane scpDemo;
	private JLabel l = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u6CE8\u9500\u7684\u5B66\u53F7\uFF1A");
	private JTextField ID = new JTextField();
	private JButton button_1;
	int numClicks = 0;
	int credit=100;

	public static void main(String[] args) {
		new Stucancel();
	}

	public Stucancel() {
		setBackground(SystemColor.info);
		setResizable(false);
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("\u5B66\u751F\u8D26\u53F7\u6CE8\u9500\u754C\u9762");
		this.setBounds(100, 200, 997, 696);
		this.setVisible(true);
		button.setBackground(Color.PINK);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("����", Font.PLAIN, 25));

		// �˵���ť
		button.setBounds(241, 449, 157, 60);
		this.getContentPane().add(button);
		button.addActionListener(this);
		button1.setFont(new Font("����", Font.PLAIN, 24));
		button1.setBackground(Color.CYAN);

		// ȷ�϶�����ť
		button1.setBounds(690, 550, 157, 60);
		this.getContentPane().add(button1);
		button1.addActionListener(this);

		// ��������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(181, 52, 636, 373);
		getContentPane().add(scpDemo);
		l.setFont(new Font("΢���ź�", Font.PLAIN, 18));

		this.getContentPane().add(l);
		l.setBounds(128, 550, 214, 60);

		this.getContentPane().add(ID);
		ID.setBounds(326, 557, 300, 46);
		button1.setMnemonic(KeyEvent.VK_I); //���ð�ť���ȼ�Ϊ'I'

		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(this);
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("����", Font.PLAIN, 25));
		button_1.setBackground(Color.PINK);
		button_1.setBounds(602, 449, 157, 60);
		getContentPane().add(button_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_1) {
			this.dispose();
			UserRegister ur=new UserRegister();
			ur.setVisible(true);
		}
		String id = ID.getText();
		if (e.getSource() == button) {
			Ssearch ss = new Ssearch();
			try {
				Connection conn = Ssearch.getConnection();
				{

					Object[][] info = Ssearch.search(conn); // �����ݿ�����ת��Ϊjtable��
					// �����ͷ
					String[] title = { "ѧ��", "����", "ѧԺ", "רҵ�༶", "��ϵ��ʽ" };

					this.tabDemo = new JTable(info, title);

					this.jth = this.tabDemo.getTableHeader();

					this.scpDemo.setViewportView(tabDemo);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		if (e.getSource() == button1) {
			SDelete d = new SDelete();
			d.setID(id);
			try {
				if (d.check()) {
					
					JOptionPane.showMessageDialog(null, "�˺�ע���ɹ���");

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

	private void Stucancel() {
		// TODO Auto-generated method stub
		
	}
}
