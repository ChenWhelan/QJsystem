package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import javax.swing.JTextField;

import java.awt.Font;

import java.awt.Color;

/*
 * 注册界面
 * 
 */
public class TeaRegister extends JFrame{


	TeaRegister () {
		init();
		
		
	}
	void init() {
            JFrame frame = new JFrame("注册账号");
            frame.setResizable(false);
            frame.setTitle("\u6CE8\u518C\u8D26\u53F7");
            frame.getContentPane().setLayout(null);
           
            
            JLabel IDStr = new JLabel("\u5DE5\u53F7:");
            IDStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            IDStr.setBounds(116, 116, 100, 25);
            frame.getContentPane().add(IDStr);
        
            JLabel nameStr = new JLabel("\u59D3\u540D:");
            nameStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            nameStr.setBounds(116, 171, 100, 25);
            frame.getContentPane().add(nameStr);

            JLabel passwordStr = new JLabel("密码:");
            passwordStr.setFont(new Font("华文楷体", Font.PLAIN, 20));
            passwordStr.setBounds(116, 227, 100, 25);
            frame.getContentPane().add(passwordStr);
            
            JTextField userID = new JTextField();
            userID.setBounds(221, 118, 150, 25);
            frame.getContentPane().add(userID);

            JTextField userName = new JTextField();
            userName.setBounds(221, 173, 150, 25);
            frame.getContentPane().add(userName);
            
            JButton buttonregister = new JButton("注册");
            buttonregister.setFont(new Font("华文楷体", Font.PLAIN, 20));
            buttonregister.setBounds(116, 311, 100, 25);
            frame.getContentPane().add(buttonregister);
            
            JTextField password = new JTextField();
            password.setBounds(221, 229, 150, 25);
            frame.getContentPane().add(password);
            
            JButton reset = new JButton("\u91CD\u7F6E");
            reset.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent arg0) {
            		
            		userID.setText(" ");
            		userName.setText(" ");
            		password.setText(" ");	
            		
            	}
            });
            reset.setFont(new Font("华文楷体", Font.PLAIN, 20));
            reset.setBounds(274, 312, 97, 23);
            frame.getContentPane().add(reset);
            
            JLabel lblNewLabel = new JLabel("\u6559\u5E08\u6CE8\u518C\u754C\u9762");
            lblNewLabel.setForeground(Color.BLUE);
            lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 30));
            lblNewLabel.setBounds(160, 46, 191, 25);
            frame.getContentPane().add(lblNewLabel);
            

            frame.setBounds(400, 100, 518, 421);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
          //为注册按钮增加监听器
            buttonregister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = userID.getText();
				String ID = userName.getText();
				String passwd = password.getText();
					TRegister tregister = new TRegister();
					tregister.setID(ID);
					tregister.setName(name);
					tregister.setPassword(passwd);
					try {
						if (tregister.JudgeRegister()) {
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
