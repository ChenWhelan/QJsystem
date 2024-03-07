package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class xiaojia {

    String id;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf8";
    private String user = "root";
    private String sqlpassword = "sql2000";
    
    void setID(String id) {
        this.id = id;
    }
  
  
 boolean delete() throws SQLException, ClassNotFoundException {
        
        if(this.id.equals("")) {
            JOptionPane.showMessageDialog(null, "学号不得为空", "学号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        delete1();
       
         return true;
}
 void delete1() throws ClassNotFoundException, SQLException {
 	Class.forName(driver);
 	String sql = "delete from qingjia where id ='"+id+"'";   
	
	try
	{
		Connection conn = DriverManager.getConnection(url, user, sqlpassword);
    	
		Statement state =conn.createStatement();
		state.executeUpdate(sql);
	        conn.close();
	        System.out.println("删除到数据库成功");
	} catch (SQLException e)
	{
		System.out.println("删除到数据库失败");
		e.printStackTrace();
	}	
	
 	
 }
}

