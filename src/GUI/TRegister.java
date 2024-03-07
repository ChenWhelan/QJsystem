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

    
    
    //判断注册的账号是否符合规则
    boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "工号不能为空！", "工号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "姓名不能为空！", "姓名为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        

        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        //符合规则，弹出注册成功的窗口，并将账号添加数据库
        JOptionPane.showMessageDialog(null, "注册成功");
        addTeacher();
        return true;
    }
    
    //向数据库添加顾客账户
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
    		System.out.println("创建数据库连接成功！");
    		
    		String sql="insert into teacher (id, name, passw) values (?,?,?)";
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, this.ID);
	        ps.setString(2, this.name);
	        ps.setString(3, this.password);
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
  
    
