package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class agree {
    String id;
    String advice;

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf8";
    private String user = "root";
    private String sqlpassword = "sql2000";
    

    void setID(String id) {
        this.id =id;
    }
    
    void setAdvice(String advice) {
        this.advice =advice;
    }
 boolean agree1() throws SQLException, ClassNotFoundException {
        
        if(this.id.equals("")) {
            JOptionPane.showMessageDialog(null, "要审核的学生的学号不得为空", "要审核的学生的学号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
       
       
       agree();

         return true;
}
 void agree() throws ClassNotFoundException, SQLException {
 	Class.forName(driver);
 	String sql = "update qingjia set result = '同意请假申请' where id ='"+id+"'";   
	
	try
	{
		Connection conn = DriverManager.getConnection(url, user, sqlpassword);
    	
		Statement state =conn.createStatement();
		state.executeUpdate(sql);
	        conn.close();
	} catch (SQLException e)
	{
		
		e.printStackTrace();
	}	
	System.out.println("修改到数据库成功");
 	
 }
}