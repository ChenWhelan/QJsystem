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
    
    
    //判断注册的账号是否符合规则
    boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "姓名不能为空！", "姓名为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "工号不能为空！", "工号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.college.equals("")) {
            JOptionPane.showMessageDialog(null, "学院不能为空！", "学院为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.subject.equals("")) {
            JOptionPane.showMessageDialog(null, "专业班级不能为空！", "专业班级为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.phone.equals("")) {
            JOptionPane.showMessageDialog(null, "联系方式不能为空！", "联系方式为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //符合规则，弹出注册成功的窗口，并将账号添加数据库
        JOptionPane.showMessageDialog(null, "注册成功");
        addStu();
        return true;
    }
    
    //向数据库添加顾客账户
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
    		System.out.println("创建数据库连接成功！");
    		
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
	       System.out.println("添加用户成功");
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("添加用户失败");
    	}
    	return conn;
    }
    	 
    }
  