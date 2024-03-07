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

public class number extends JFrame implements ActionListener {
	private JButton button = new JButton("查询");
	private JTableHeader jth;
	private JTable tabDemo;
	private JScrollPane scpDemo;
	private JButton button_1;

	public static void main(String[] args) {
		new number();
	}

	public number() {
		setResizable(false);
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("\u67E5\u8BE2\u5B66\u751F\u8BF7\u5047\u6B21\u6570");
		this.setBounds(100, 200, 500, 696);
		this.setVisible(true);
		button.setBackground(Color.PINK);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("宋体", Font.PLAIN, 25));

		
		button.setBounds(14, 543, 157, 60);
		this.getContentPane().add(button);
		button.addActionListener(this);

		
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(14, 13, 466, 490);
		getContentPane().add(scpDemo);
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(this);
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBackground(Color.PINK);
		button_1.setBounds(323, 543, 157, 60);
		getContentPane().add(button_1);

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_1) {
			this.dispose();
			UserRegister ur=new UserRegister();
			ur.setVisible(true);
			
		}
		
		if (e.getSource() == button) {
			count c = new count();
			try {
				Connection conn = count.getConnection();
				{

					Object[][] info = count.search(conn); // 将数据库数据转换为jtable表
					// 定义表头
					String[] title = { "学号", "姓名","请假次数" };

					this.tabDemo = new JTable(info, title);

					this.jth = this.tabDemo.getTableHeader();

					this.scpDemo.setViewportView(tabDemo);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		
	}



}
