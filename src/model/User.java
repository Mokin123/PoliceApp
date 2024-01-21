package model;

public class User{
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getAdmin() {
		return false;
	}
	
//	encapsulation of password
	
	public boolean checkPassword(String passToCheck) {
		boolean check = false;
//		check if password == parameter password
		if(password.equals(passToCheck)) {
			check = true;
		}
		return check;
	}
	
	
	
}
