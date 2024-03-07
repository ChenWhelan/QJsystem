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
	private JButton button1 = new JButton("查询");
	private JButton button2 = new JButton("请假");
	private JButton button3 = new JButton("销假");
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
		this.setTitle("学生请假界面");
		this.setBounds(100, 200, 712, 500);
		this.setVisible(true);

		// 学号studentid
		JLabel labelid = new JLabel("学号：");
		labelid.setAlignmentY(CENTER_ALIGNMENT);
		labelid.setBounds(55, 37, 45, 47);// 字的位置
		ID.setBounds(114, 45, 178, 30);// 框的位置
		this.getContentPane().add(labelid);
		this.getContentPane().add(ID);

		// 查询按钮
		button1.setBounds(315, 45, 100, 30);
		this.getContentPane().add(button1);
		button1.addActionListener(this);

		// 请假按钮
		button2.setBounds(182, 369, 100, 30);
		this.getContentPane().add(button2);
		button2.addActionListener(this);

		// 销假按钮
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

	// 按钮功能修改如下
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

					Object[][] info = SQJsearch.search(conn); // 将数据库数据转换为jtable表
					// 定义表头
					
					String[] title = { "学号", "姓名","联系方式", "请假日期", "开始日期","结束日期","请假原因"};

					this.tabDemo = new JTable(info, title);

					this.jth = this.tabDemo.getTableHeader();

					this.scpDemo.setViewportView(tabDemo);
					
					Object[][] info1 = SQJsearch1.search(conn1); // 将数据库数据转换为jtable表
					// 定义表头
					
					String[] title1 = { "审核辅导员","审核结果"};

					this.tabDemo1 = new JTable(info1, title1);

					this.jth = this.tabDemo1.getTableHeader();

					this.scpDemo_1.setViewportView(tabDemo1);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
						JOptionPane.ERROR_MESSAGE);

			}
		}

		if (e.getSource() == button2) {
			// 弹出确认请假窗口
			 new second();
			// 关闭当前窗口
			 this.dispose();
		}

		if (e.getSource() == button3) {

			xiaojia xj = new xiaojia();
			xj.setID(id);
			try {
				if (xj.delete()) {
					
					JOptionPane.showMessageDialog(null, "销假成功！");

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