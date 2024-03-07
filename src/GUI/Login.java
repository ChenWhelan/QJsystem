package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import sql.QJXTDataBase;
import data.SUser;
import data.TUser;





public class Login extends JFrame{


	private static final long serialVersionUID = 1L;


	public Login() {
		init();
		
	}
	//登录界面初始化
	public void init() {
		
	    JFrame frame = new JFrame("登录");
	    frame.setResizable(false);
	    frame.setTitle("南苑请假审批系统");
        frame.getContentPane().setLayout(null);
        
        JLabel nameStr = new JLabel("学号/工号:");
        nameStr.setForeground(new Color(0, 0, 0));
        nameStr.setFont(new Font("黑体", Font.PLAIN, 20));
        nameStr.setBounds(85, 150, 100, 25);
        frame.getContentPane().add(nameStr);
        
        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setForeground(new Color(0, 0, 0));
        passwordStr.setFont(new Font("黑体", Font.PLAIN, 20));
        passwordStr.setBounds(116, 211, 100, 25);
        frame.getContentPane().add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setFont(new Font("华文楷体", Font.PLAIN, 15));
        userID.setBounds(182, 150, 182, 25);
        frame.getContentPane().add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(182, 213, 182, 25);
        frame.getContentPane().add(password);
        
        JButton buttonlogin = new JButton("登录");
        buttonlogin.setFont(new Font("华文楷体", Font.PLAIN, 20));
        buttonlogin.setBounds(116, 300, 100, 25);
        frame.getContentPane().add(buttonlogin);
        
        JButton buttonregister = new JButton("管理");
        buttonregister.setFont(new Font("华文楷体", Font.PLAIN, 20));
        buttonregister.setBounds(293, 300, 100, 25);
        frame.getContentPane().add(buttonregister);  
        
        JRadioButton s_rdbtn = new JRadioButton("学生");
        s_rdbtn.setFont(new Font("华文楷体", Font.PLAIN, 18));
        s_rdbtn.setBounds(399, 223, 87, 25);
        frame.getContentPane().add(s_rdbtn);
        
        JRadioButton t_rdbtn = new JRadioButton("教师");
        t_rdbtn.setFont(new Font("华文楷体", Font.PLAIN, 18));
        t_rdbtn.setBounds(399, 198, 87, 23);
        frame.getContentPane().add(t_rdbtn);
        
        frame.setBounds(400, 100, 506, 408);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        ButtonGroup bgp=new ButtonGroup();
        bgp.add(s_rdbtn);
        bgp.add(t_rdbtn);
        
        
        ImageIcon ig = new ImageIcon("xx.jpg");
        JLabel label = new JLabel(ig);
        label.setBounds(0, 0, 500, 379);
        frame.getContentPane().add(label);

        
		//为登录按钮添加监听器
         buttonlogin.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
    			SUser s = QJXTDataBase.userQquery1(ID);
    			TUser t = QJXTDataBase.userQquery2(ID);
    			if (t != null && t.verifyPwd(passwd)&&t_rdbtn.isSelected()) {
    				teacher te=new teacher();
    				frame.setVisible(false);	
    				te.setVisible(true);
    				
    				
    			}
    				else if (s != null && s.verifyPwd(passwd)&&s_rdbtn.isSelected()) {
    					student st =new student();
    					frame.setVisible(false);	
        				st.setVisible(true);
    					
    			
    			} else {
    				JOptionPane.showMessageDialog(null, "登录失败,工号或密码输入错误");
    			}
    
          
            }

			   
        });

			
         
         //为注册按钮添加监听器
         buttonregister.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 String ID = userID.getText();
                 String passwd = new String (password.getPassword());
     			TUser t = QJXTDataBase.userQquery2(ID);
     			if (t != null && t.verifyPwd(passwd)&&t_rdbtn.isSelected()) {
    			frame.setVisible(false);
        		UserRegister ar = new UserRegister(); 	
        		ar.setVisible(true);
    			}else {
    				JOptionPane.showMessageDialog(null, "登录失败,工号或密码输入错误 ");
    			} 
        	 }
         });
	}


	public static void main(String []args) { 
       //主程序
       //登录窗口
   
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}
