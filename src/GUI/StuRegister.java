package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

/*
 * 注册界面
 * 
 */
public class StuRegister extends JFrame{

	StuRegister () {
		init();
		
		
	}
	void init() {
            JFrame frame = new JFrame("注册账号");
            frame.setResizable(false);
            frame.setTitle("\u6CE8\u518C\u8D26\u53F7");
            frame.getContentPane().setLayout(null);
           
            JLabel lblNewLabel = new JLabel("\u5B66\u751F\u6CE8\u518C\u754C\u9762");
            lblNewLabel.setForeground(Color.BLUE);
            lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 30));
            lblNewLabel.setBounds(161, 25, 191, 25);
            frame.getContentPane().add(lblNewLabel);
            
            
            JLabel collegeStr = new JLabel("\u5B66\u9662:");
            collegeStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            collegeStr.setBounds(116, 177, 100, 30);
            frame.getContentPane().add(collegeStr);
            
            JLabel phoneStr = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
            phoneStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            phoneStr.setBounds(116, 263, 100, 30);
            frame.getContentPane().add(phoneStr);


            frame.setBounds(400, 100, 518, 421);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            JLabel IDStr = new JLabel("\u5B66\u53F7:");
            IDStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            IDStr.setBounds(116, 63, 100, 25);
            frame.getContentPane().add(IDStr);
        
            JLabel nameStr = new JLabel("\u59D3\u540D:");
            nameStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            nameStr.setBounds(116, 101, 100, 25);
            frame.getContentPane().add(nameStr);

            JLabel passwordStr = new JLabel("密码:");
            passwordStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            passwordStr.setBounds(116, 139, 100, 25);
            frame.getContentPane().add(passwordStr);  
               
            JLabel classStr = new JLabel("\u4E13\u4E1A\u73ED\u7EA7:");
            classStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            classStr.setBounds(116, 220, 100, 30);
            frame.getContentPane().add(classStr);
            
            JTextField userID = new JTextField();
            userID.setBounds(221, 65, 150, 25);
            frame.getContentPane().add(userID);

            JTextField userName = new JTextField();
            userName.setBounds(221, 101, 150, 25);
            frame.getContentPane().add(userName);
            
            JTextField password = new JTextField();
            password.setBounds(221, 139, 150, 25);
            frame.getContentPane().add(password);
            

            
            JTextField college = new JTextField();
            college.setLocation(221, 182);
            college.setSize(150, 25);
            frame.getContentPane().add(college);
            
            JTextField subject = new JTextField();
            subject.setLocation(221, 225);
            subject.setSize(150, 25);
            frame.getContentPane().add(subject);
            
            JTextField phone = new JTextField();
            phone.setLocation(221, 268);
            phone.setSize(150, 25);
            frame.getContentPane().add(phone);
            
            JButton buttonregister = new JButton("注册");
            buttonregister.setFont(new Font("华文楷体", Font.PLAIN, 20));
            buttonregister.setBounds(116, 342, 100, 25);
            frame.getContentPane().add(buttonregister);
            
            JButton reset = new JButton("\u91CD\u7F6E");
            reset.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent arg0) {
            		userID.setText("");
            		userName.setText("");
            		password.setText("");
            		college.setText("");
            		subject.setText("");
            		phone.setText("");	
            	}
            });
            reset.setFont(new Font("华文楷体", Font.PLAIN, 20));
            reset.setBounds(274, 343, 97, 23);
            frame.getContentPane().add(reset);
            
          
          //为注册按钮增加监听器
            buttonregister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ID = userID.getText();
				String name = userName.getText();
				String passwd = password.getText();
				String college1=college.getText();
				String subject1=subject.getText();
				String phone1=phone.getText();
				
					SRegister sregister = new SRegister();
					sregister.setID(ID);
					sregister.setName(name);
					sregister.setPassword(passwd);
					sregister.setCollege(college1);
					sregister.setSubject(subject1);
					sregister.setPhone(phone1);
					// 如果注册成功，返回登录界面
					try {
						if (sregister.JudgeRegister()) {
							frame.setVisible(false);
							UserRegister ur=new UserRegister();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
                
            });
	}
}
