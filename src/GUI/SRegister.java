package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SRegister {
	private static Connection conn = null;
    String name;
    String ID;
    String password;
    String college;
    String subject;
    String phone;

    
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf-8";
    public String user = "root";
    public String sqlpassword = "sql2000";
    
    void setName(String name) {
        this.name = name;
    }
    void setID(String ID) {
        this.ID = ID;
    }
    void setPassword(String password) {
        this.password = password;
    }
    void setCollege(String college) {
        this.college = college;
    }
    void setSubject(String subject) {
        this.subject = subject;
    }
    
    void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    //�ж�ע����˺��Ƿ���Ϲ���
    boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "��������Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "���Ų���Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.college.equals("")) {
            JOptionPane.showMessageDialog(null, "ѧԺ����Ϊ�գ�", "ѧԺΪ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.subject.equals("")) {
            JOptionPane.showMessageDialog(null, "רҵ�༶����Ϊ�գ�", "רҵ�༶Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.phone.equals("")) {
            JOptionPane.showMessageDialog(null, "��ϵ��ʽ����Ϊ�գ�", "��ϵ��ʽΪ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //���Ϲ��򣬵���ע��ɹ��Ĵ��ڣ������˺�������ݿ�
        JOptionPane.showMessageDialog(null, "ע��ɹ�");
        addStu();
        return true;
    }
    
    //�����ݿ���ӹ˿��˻�
    public Connection  addStu() throws ClassNotFoundException, SQLException {
    	Class.forName(driver);
    	Connection conn = DriverManager.getConnection(url, user, sqlpassword);

    	String driver_MySQL = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf-8";
    	String account_MySQL = "root";
    	String password_MySQL = "sql2000";

    	try {
    		Class.forName(driver_MySQL);
    		conn = DriverManager.getConnection(url, account_MySQL,
    				password_MySQL);
    		System.out.println("�������ݿ����ӳɹ���");
    		
    		String sql="insert into student (id, name, password,college,subject,phone,number) values (?,?,?,?,?,?,'0')";
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, this.ID);
	        ps.setString(2, this.name);
	        ps.setString(3, this.password);
	        ps.setString(4, this.college);
	        ps.setString(5, this.subject);
	        ps.setString(6, this.phone);
	        ps.executeUpdate();
	        ps.close();	
	       conn.close();
	       System.out.println("����û��ɹ�");
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("����û�ʧ��");
    	}
    	return conn;
    }
    	 
    }
  