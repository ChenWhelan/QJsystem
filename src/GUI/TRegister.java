package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TRegister {
	private static Connection conn = null;
    String name;
    String ID;
    String password;

    
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf-8";
    public String user = "root";
    public String sqlpassword = "sql2000";
    
    void setID(String ID) {
        this.ID = ID;
    }    
    void setName(String name) {
        this.name = name;
    }

    void setPassword(String password) {
        this.password = password;
    }

    
    
    //�ж�ע����˺��Ƿ���Ϲ���
    boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "���Ų���Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "��������Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        

        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        //���Ϲ��򣬵���ע��ɹ��Ĵ��ڣ������˺�������ݿ�
        JOptionPane.showMessageDialog(null, "ע��ɹ�");
        addTeacher();
        return true;
    }
    
    //�����ݿ���ӹ˿��˻�
    public Connection addTeacher() throws ClassNotFoundException, SQLException {
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
    		
    		String sql="insert into teacher (id, name, passw) values (?,?,?)";
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, this.ID);
	        ps.setString(2, this.name);
	        ps.setString(3, this.password);
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
  
    
