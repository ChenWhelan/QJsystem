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
	private JTextField approver = new JTextField(); //������
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
		this.setTitle("���ȷ�Ͻ���");
		this.setBounds(100,200,500,400);
		this.setVisible(true);
		
		//ѧ��studentid
		JLabel labelid = new JLabel("ѧ�ţ�");
		labelid.setAlignmentY(CENTER_ALIGNMENT);
		labelid.setBounds(25, 20, 63, 47);//�ֵ�λ��
		id.setBounds(70, 28, 150, 30);//���λ��
		this.getContentPane().add(labelid);
		this.getContentPane().add(id);		
		
		//������approver
		JLabel labelapprover = new JLabel("�����ˣ�");
		labelapprover.setAlignmentY(CENTER_ALIGNMENT);
		labelapprover.setBounds(285, 20, 63, 47);//�ֵ�λ��
		approver.setBounds(345, 28, 105, 30);//���λ��
		this.getContentPane().add(labelapprover);
		this.getContentPane().add(approver);	
		
		//����name
		JLabel labelname = new JLabel("������");
		labelname.setAlignmentY(CENTER_ALIGNMENT);
		labelname.setBounds(25, 70, 63, 47);//�ֵ�λ��
		name.setBounds(70, 78, 105, 30);//���λ��
		this.getContentPane().add(labelname);
		this.getContentPane().add(name);
		
		//��ϵ��ʽphone
		JLabel labelphone = new JLabel("��ϵ��ʽ��");
		labelphone.setAlignmentY(CENTER_ALIGNMENT);
		labelphone.setBounds(25, 120, 83, 47);//�ֵ�λ��
		phone.setBounds(106, 128, 125, 30);//���λ��
		this.getContentPane().add(labelphone);
		this.getContentPane().add(phone);
		
		//�������day
		JLabel labelday = new JLabel("���������");
		labelday.setAlignmentY(CENTER_ALIGNMENT);
		labelday.setBounds(25, 170, 83, 47);//�ֵ�λ��
		day.setBounds(106, 178, 125, 30);//���λ��
		this.getContentPane().add(labelday);
		this.getContentPane().add(day);
		
		//��ʼ����startdate
		JLabel labelstartdate = new JLabel("��ʼ���ڣ�");
		labelstartdate.setAlignmentY(CENTER_ALIGNMENT);
		labelstartdate.setBounds(25, 220, 83, 47);//�ֵ�λ��
		startdate.setBounds(106, 228, 125, 30);//���λ��
		this.getContentPane().add(labelstartdate);
		this.getContentPane().add(startdate);
		
		//��������enddate
		JLabel labelenddate = new JLabel("�������ڣ�");
		labelenddate.setAlignmentY(CENTER_ALIGNMENT);
		labelenddate.setBounds(25, 270, 83, 47);//�ֵ�λ��
		enddate.setBounds(106, 278, 125, 30);//���λ��
		this.getContentPane().add(labelenddate);
		this.getContentPane().add(enddate);
		
		//���ԭ��reason
		JLabel labelreason = new JLabel("���ԭ��");
		labelreason.setAlignmentY(CENTER_ALIGNMENT);
		labelreason.setBounds(285, 70, 83, 47);//�ֵ�λ��
		reason.setBounds(285, 117, 175, 100);//���λ��
		this.getContentPane().add(labelreason);
		this.getContentPane().add(reason);
		
		//ȷ�ϰ�ť
		button1.setBounds(300, 273, 150, 40);
		this.getContentPane().add(button1);
		button1.addActionListener(this);
		
		
}
	
	//��ť�����޸�����
	@Override
	public void actionPerformed(ActionEvent e) {
		//�ɹ�����ڵ���
		String ID = id.getText();
		String Sname = name.getText();
		String Phone = phone.getText();
		String Day=day.getText();
		String Start = startdate.getText();
		String End=enddate.getText();
		String Approver=approver.getText();
		String Reason=reason.getText();
		
		
		if (e.getSource() == button1){
				// ����ȷ�ϵ�ַ����
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
				// �رյ�ǰ����
				//this.dispose();
			}
	
		
	}	
	

	
}
