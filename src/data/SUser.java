package data;

import java.io.Serializable;

public class SUser  implements Serializable {
	// ID
	private long id = -1;
	// �û���
	private String name = new String();
	// ����
	private String pwd = new String();

	
	public SUser(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public boolean verifyPwd(String pwd) {
		if (! this.pwd.equals(pwd)){
			return false; 
		}
		
		return true;
	}
	public void show(){
		System.out.println("=== Use Information ===");
		System.out.println("*** ID     : \t" + id);
		System.out.println("*** Name   : \t" + name);
		System.out.println();
	}
}
