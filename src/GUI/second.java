package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




    public class second extends JFrame implements ActionListener{
  	private JButton button1 =  new  JButton("\u63D0\u4EA4");
	private JTextField id = new JTextField();
	private JTextField approver = new JTextField(); //审批人
	private JTextField name = new JTextField();
	private JTextField phone = new JTextField();
	private JTextField day = new JTextField();
	private JTextField startdate = new JTextField();
	private JTextField enddate = new JTextField();
	private JTextField reason = new JTextField();

	public static void main(String[] args) {
		new second();
		}
	
	public second() {
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("请假确认界面");
		this.setBounds(100,200,500,400);
		this.setVisible(true);
		
		//学号studentid
		JLabel labelid = new JLabel("学号：");
		labelid.setAlignmentY(CENTER_ALIGNMENT);
		labelid.setBounds(25, 20, 63, 47);//字的位置
		id.setBounds(70, 28, 150, 30);//框的位置
		this.getContentPane().add(labelid);
		this.getContentPane().add(id);		
		
		//审批人approver
		JLabel labelapprover = new JLabel("审批人：");
		labelapprover.setAlignmentY(CENTER_ALIGNMENT);
		labelapprover.setBounds(285, 20, 63, 47);//字的位置
		approver.setBounds(345, 28, 105, 30);//框的位置
		this.getContentPane().add(labelapprover);
		this.getContentPane().add(approver);	
		
		//姓名name
		JLabel labelname = new JLabel("姓名：");
		labelname.setAlignmentY(CENTER_ALIGNMENT);
		labelname.setBounds(25, 70, 63, 47);//字的位置
		name.setBounds(70, 78, 105, 30);//框的位置
		this.getContentPane().add(labelname);
		this.getContentPane().add(name);
		
		//联系方式phone
		JLabel labelphone = new JLabel("联系方式：");
		labelphone.setAlignmentY(CENTER_ALIGNMENT);
		labelphone.setBounds(25, 120, 83, 47);//字的位置
		phone.setBounds(106, 128, 125, 30);//框的位置
		this.getContentPane().add(labelphone);
		this.getContentPane().add(phone);
		
		//请假天数day
		JLabel labelday = new JLabel("请假天数：");
		labelday.setAlignmentY(CENTER_ALIGNMENT);
		labelday.setBounds(25, 170, 83, 47);//字的位置
		day.setBounds(106, 178, 125, 30);//框的位置
		this.getContentPane().add(labelday);
		this.getContentPane().add(day);
		
		//开始日期startdate
		JLabel labelstartdate = new JLabel("开始日期：");
		labelstartdate.setAlignmentY(CENTER_ALIGNMENT);
		labelstartdate.setBounds(25, 220, 83, 47);//字的位置
		startdate.setBounds(106, 228, 125, 30);//框的位置
		this.getContentPane().add(labelstartdate);
		this.getContentPane().add(startdate);
		
		//结束日期enddate
		JLabel labelenddate = new JLabel("结束日期：");
		labelenddate.setAlignmentY(CENTER_ALIGNMENT);
		labelenddate.setBounds(25, 270, 83, 47);//字的位置
		enddate.setBounds(106, 278, 125, 30);//框的位置
		this.getContentPane().add(labelenddate);
		this.getContentPane().add(enddate);
		
		//请假原因reason
		JLabel labelreason = new JLabel("请假原因：");
		labelreason.setAlignmentY(CENTER_ALIGNMENT);
		labelreason.setBounds(285, 70, 83, 47);//字的位置
		reason.setBounds(285, 117, 175, 100);//框的位置
		this.getContentPane().add(labelreason);
		this.getContentPane().add(reason);
		
		//确认按钮
		button1.setBounds(300, 273, 150, 40);
		this.getContentPane().add(button1);
		button1.addActionListener(this);
		
		
}
	
	//按钮功能修改如下
	@Override
	public void actionPerformed(ActionEvent e) {
		//成功付款窗口弹出
		String ID = id.getText();
		String Sname = name.getText();
		String Phone = phone.getText();
		String Day=day.getText();
		String Start = startdate.getText();
		String End=enddate.getText();
		String Approver=approver.getText();
		String Reason=reason.getText();
		
		
		if (e.getSource() == button1){
				// 弹出确认地址窗口
			StuQJ sqj=new StuQJ();
			sqj.setID(ID);
			sqj.setSname(Sname);
			sqj.setPhone(Phone);
			sqj.setDay(Day);
			sqj.setStart(Start);
			sqj.setEnd(End);
			sqj.setTname(Approver);
			sqj.setReason(Reason);
			try {
				if (sqj.check()) {
					new student();
					this.dispose();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//
				// 关闭当前窗口
				//this.dispose();
			}
	
		
	}	
	

	
}
