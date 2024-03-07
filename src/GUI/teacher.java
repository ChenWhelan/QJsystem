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
	private JButton button1 =  new  JButton("查询");
	private JButton button2 = new JButton("同意");
	private JButton button3 = new JButton("拒绝");
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
		this.setTitle("教师审批界面");
		this.setBounds(100,200,807,504);
		this.setVisible(true);
		
		
	    //姓名name
		JLabel labelname = new JLabel("姓名：");
		labelname.setAlignmentY(CENTER_ALIGNMENT);
		labelname.setBounds(25, 20, 70, 47);//字的位置
		tname.setBounds(70, 30, 158, 30);//框的位置
		this.getContentPane().add(labelname);
		this.getContentPane().add(tname);
		
		//学号id
		JLabel labelid = new JLabel("要处理的学生学号：");
		labelid.setAlignmentY(CENTER_ALIGNMENT);
		labelid.setBounds(45, 270, 183, 50);//字的位置
		id.setBounds(180, 280, 240, 30);//框的位置
		this.getContentPane().add(labelid);
		this.getContentPane().add(id);
		
		//意见advice
		JLabel labeladvice = new JLabel("\u5BA1\u6838\u610F\u89C1\r\n\uFF08\u540C\u610F\u53EF\u4EE5\u4E0D\u586B\u5199\uFF09\uFF1A");
		labeladvice.setAlignmentY(CENTER_ALIGNMENT);
		labeladvice.setBounds(45, 309, 210, 50);//字的位置
		advice.setBounds(253, 323, 395, 74);//框的位置
		this.getContentPane().add(labeladvice);
		this.getContentPane().add(advice);
		
		
		//显示请假信息界面
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(35, 73, 723, 192);
		getContentPane().add(scpDemo);

		

		//查询按钮
		button1.setBounds(242, 28, 70, 30);
		this.getContentPane().add(button1);
		button1.addActionListener(this);
		
		//同意按钮
		button2.setBounds(180, 426, 100, 30);
		this.getContentPane().add(button2);
		button2.addActionListener(this);
		
		//拒绝按钮
		button3.setBounds(505, 426, 100, 30);
		this.getContentPane().add(button3);
		button3.addActionListener(this);
		
		this.setResizable(false);
		}
	


	//按钮功能修改如下
	@Override
	public void actionPerformed(ActionEvent e) {
		String Tname = tname.getText();
		if (e.getSource() == button1){
			Teasearch ts = new Teasearch();
			ts.setTname(Tname);
			try {
				Connection conn = Teasearch.getConnection();
				
				{

					Object[][] info = Teasearch.search(conn); // 将数据库数据转换为jtable表
					// 定义表头
					
					String[] title = { "学号", "姓名","联系方式", "请假日期", "开始日期","结束日期","请假原因", "审核辅导员","审核结果"};

					this.tabDemo = new JTable(info, title);

					this.jth = this.tabDemo.getTableHeader();

					this.scpDemo.setViewportView(tabDemo);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		
		if (e.getSource() == button2){
			String ID = id.getText();
			agree a=new agree();
			a.setID(ID);
			try {
				if (a.agree1()) {
					
					JOptionPane.showMessageDialog(null, "已同意该生请假申请！");
					
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
					
					JOptionPane.showMessageDialog(null, "已回绝该生请假申请！");
					
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
