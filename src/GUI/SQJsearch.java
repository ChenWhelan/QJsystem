package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQJsearch {
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
			System.out.println("�������ݿ����ӳɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�����ʧ�ܣ�");
		}
		return conn;
	}

	void setID(String id) {
		this.id = id;
	}

	public static Object[][] search(Connection conn) throws SQLException {
    	String sql1 = "select * from stuQJ where id ='"+id+"'";   
    	java.sql.PreparedStatement pstm =null;
		try
		{
			pstm = conn.prepareStatement(sql1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    	// ִ�в�ѯ  
    	ResultSet rs = pstm.executeQuery();  
    	// �����ж�������¼  
    	int count = 0;  
    	
    	while(rs.next()){  
    	count++;  
    	}  
    	rs = pstm.executeQuery();  
    	Object[][] info = new Object[count][7];  
    	count = 0;  
    	while(rs.next()){   
    	 	info[count][0] = rs.getString("id");  
    	 	info[count][1] = rs.getString("sname") ;  
    	 	info[count][2] = rs.getString("phone");  
    	 	info[count][3] = rs.getString("day");
    	 	info[count][4] = rs.getString("start");
    	 	info[count][5] = rs.getString("end") ;  
    	 	info[count][6] = rs.getString("reason");  

    	count++;  
    	}  
    	
    	return info;
    	  
    }

}
