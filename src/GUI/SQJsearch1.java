package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SQJsearch1 {
    static String id;
    
	public static Connection getConnection() {
		Connection conn = null;
		String driver_MySQL = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf-8";
		String account_MySQL = "root";
		String password_MySQL = "sql2000";

		try {
			Class.forName(driver_MySQL);
			conn = DriverManager.getConnection(url, account_MySQL,
					password_MySQL);
			System.out.println("创建数据库连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建数据库连接失败！");
		}
		return conn;
	}
    void setID(String id) {
        this.id = id;
    }
    
 
 public static Object[][] search(Connection conn) throws SQLException {
 	String sql1 = "select * from qingjia where id ='"+id+"'";   
 	java.sql.PreparedStatement pstm =null;
 	try
		{
			pstm = conn.prepareStatement(sql1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 	// 执行查询  
 	ResultSet rs = pstm.executeQuery();  
 	// 计算有多少条记录  
 	int count = 0;  
 	
 	while(rs.next()){  
 	count++;  
 	}  
 	rs = pstm.executeQuery();  
 	Object[][] info1 = new Object[count][2];  
 	count = 0;  
 	while(rs.next()){  
 	info1[count][0] = rs.getString("tname");  
 	info1[count][1] = rs.getString("result") ;  
 	count++;  
 	}  
 	
 	return info1;
 	  
 }

 	
 }
