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
			JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "ѧ��Ϊ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.Sname.equals("")) {
			JOptionPane.showMessageDialog(null, "��������Ϊ��", "����Ϊ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.phone.equals("")) {
			JOptionPane.showMessageDialog(null, "�ֻ��Ų���Ϊ��", "�ֻ���Ϊ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.day.equals("")) {
			JOptionPane.showMessageDialog(null, "�����������Ϊ��", "�������Ϊ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (this.start.equals("")) {
			JOptionPane.showMessageDialog(null, "��ʼ���ڲ���Ϊ��", "��ʼ����Ϊ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (this.end.equals("")) {
			JOptionPane.showMessageDialog(null, "�������ڲ���Ϊ��", "��������Ϊ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (this.reason.equals("")) {
			JOptionPane.showMessageDialog(null, "���ԭ�򲻵�Ϊ��", "���ԭ��Ϊ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (this.Tname.equals("")) {
			JOptionPane.showMessageDialog(null, "��˸���Ա����Ϊ��", "��˸���ԱΪ��",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "�ɹ�");
		addQJ();
		number();
		return true;

	}

	public void addQJ() throws ClassNotFoundException, SQLException {
		String sql = "insert into qingjia (id, sname, phone,day,start,end,reason,tname,result) values (?,?,?,?,?,?,?,?,'δ���')";
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
			System.out.println("�������ʧ�ܣ�");
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
		System.out.println("�޸ĵ����ݿ�ɹ�");
	 	
	 }
}
