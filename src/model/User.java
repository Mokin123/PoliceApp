package model;
public class User{
	
	private String username;
	private String password;
	private boolean admin;
	
	public User(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	public boolean checkPassword(String passToCheck) {
		boolean check = false;
		if(password.equals(passToCheck)) {
			check = true;
		}
		return check;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean getAdmin () {
		return admin;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
