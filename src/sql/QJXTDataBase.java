package sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.SUser;
import data.TUser;



public class QJXTDataBase {
	private static Connection conn = null;

// 取得数据库连接，本服务器程序仅使用这一个连接实例
public static Connection getConnection() {
	if (conn != null) {
		return conn;
	}

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

	private static String toSqlString(String str) {
		return new String(" '" + str + "' ");
	}
	
	public static SUser userQquery1(String accountName) {
		SUser user1= null;
		String sql = "select * from student where id = " + toSqlString(accountName);
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() == true) {
				user1= new SUser();
				user1.setId(rs.getLong(1));
				user1.setName(rs.getString(2));
				user1.setPwd(rs.getString(3));
			}
		} catch (SQLException sqle) {
			System.out.println("查询数据出现异常: " + sqle.getMessage());
		}

		return user1;
	}
	
	public static TUser userQquery2(String accountName) {
		TUser user2= null;
		String sql = "select * from teacher where id = " + toSqlString(accountName);
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() == true) {
				user2= new TUser();
				user2.setId(rs.getLong(1));
				user2.setName(rs.getString(2));
				user2.setPwd(rs.getString(3));
			}
		} catch (SQLException sqle) {
			System.out.println("查询数据出现异常: " + sqle.getMessage());
		}

		return user2;
	}
	public static int i=1;


}
