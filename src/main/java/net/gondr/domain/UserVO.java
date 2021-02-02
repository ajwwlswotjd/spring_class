package net.gondr.domain;

public class UserVO {
	
	private String userid;
	private String password;
	private String username;
	private String password_check; 
	
	public String getPassword_check() {
		return password_check;
	}
	public void setPassword_check(String password_check) {
		this.password_check = password_check;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
