package model;

import java.util.LinkedList;


public class UserManager {
	private LinkedList<User> userList;
	
	public UserManager() {
		userList = new LinkedList<User>();
		test();
	}
	
//	Adds a test case to the LinkedList
	public void test() {
		String un = "test";
		String pw = "test";
		boolean admin = true;
		addNewUser(un,pw,admin);
	}
	
//	Adds a new user with the username, password and adminStatus parameters
	public void addNewUser(String userName, String password, boolean adminStatus) {
		//Creating the user
		User userToAdd = new User(userName, password, adminStatus);
		//Add to the linked list
		userList.add(userToAdd);
		
	}
	public boolean checkUser(String username,String password) {
		boolean check = false;
		for (int i=0;i<userList.size();i++) {
			User user = userList.get(i);
			if (user.getUsername().equals(username)&&user.checkPassword(password)==true) {
				check = true;
			}
			
		}
		return check;
	}
}
