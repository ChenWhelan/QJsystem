package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SDelete {

    String id;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf8";
    private String user = "root";
    private String sqlpassword = "sql2000";
    
    void setID(String id) {
        this.id = id;
    }
  
  
 boolean check() throws SQLException, ClassNotFoundException {
        
        if(this.id.equals("")) {
            JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "ѧ��Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        delete();
       
         return true;
}
 void delete() throws ClassNotFoundException, SQLException {
 	Class.forName(driver);
 	String sql = "delete from student where id ='"+id+"'";   
	
	try
	{
		Connection conn = DriverManager.getConnection(url, user, sqlpassword);
    	
		Statement state =conn.createStatement();
		state.executeUpdate(sql);
	        conn.close();
	        System.out.println("ɾ�������ݿ�ɹ�");
	} catch (SQLException e)
	{
		System.out.println("ɾ�������ݿ�ʧ��");
		e.printStackTrace();
	}	
	
 	
 }
}
