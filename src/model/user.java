package model;
public class User{
	
	private String username;
	private String password;
	private boolean admin;
	
	public boolean checkUser(String tUsername, String tPassword) {
		boolean state = false;
		if(username == tUsername && password == tPassword) {
			state = true;
		}
		return state;
	}
}
