package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class StuQJ {
	String id;
	String Sname;
	String phone;
	String day;
	String start;
	String end;
	String reason;
	String Tname;

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/QJXT?useUnicode=true&characterEncoding=utf8";
	private String user = "root";
	private String sqlpassword = "sql2000";

	void setID(String id) {
		this.id = id;
	}

	void setSname(String Sname) {
		this.Sname = Sname;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}

	void setDay(String day) {
		this.day = day;
	}

	void setStart(String start) {
		this.start = start;
	}

	void setEnd(String end) {
		this.end = end;
	}

	void setReason(String reason) {
		this.reason = reason;
	}

	void setTname(String Tname) {
		this.Tname = Tname;
	}

	boolean check() throws SQLException, ClassNotFoundException {

		if (this.id.equals("")) {
			JOptionPane.showMessageDialog(null, "学号不得为空", "学号为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.Sname.equals("")) {
			JOptionPane.showMessageDialog(null, "姓名不得为空", "姓名为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.phone.equals("")) {
			JOptionPane.showMessageDialog(null, "手机号不得为空", "手机号为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.day.equals("")) {
			JOptionPane.showMessageDialog(null, "请假天数不得为空", "请假天数为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (this.start.equals("")) {
			JOptionPane.showMessageDialog(null, "开始日期不得为空", "开始日期为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.end.equals("")) {
			JOptionPane.showMessageDialog(null, "结束日期不得为空", "结束日期为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (this.reason.equals("")) {
			JOptionPane.showMessageDialog(null, "请假原因不得为空", "请假原因为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (this.Tname.equals("")) {
			JOptionPane.showMessageDialog(null, "审核辅导员不得为空", "审核辅导员为空",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "成功");
		addQJ();
		number();
		return true;

	}

	public void addQJ() throws ClassNotFoundException, SQLException {
		String sql = "insert into qingjia (id, sname, phone,day,start,end,reason,tname,result) values (?,?,?,?,?,?,?,?,'未审核')";
		Class.forName(driver);
		try {
			Connection conn = DriverManager.getConnection(url, user,
					sqlpassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.id);
			ps.setString(2, this.Sname);
			ps.setString(3, this.phone);
			ps.setString(4, this.day);
			ps.setString(5, this.start);
			ps.setString(6, this.end);
			ps.setString(7, this.reason);
			ps.setString(8, this.Tname);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException ex) {
			System.out.println("请假申请失败！");
		}

	}
	
	void number() throws ClassNotFoundException, SQLException {
	 	Class.forName(driver);
	 	String sql = "update student set number = number+1 where id ='"+id+"'";   
		
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
