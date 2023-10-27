package model;

import java.util.LinkedList;
import java.sql.*;



public class UserManager {
	private LinkedList<User> userList;
	private DB_connection connect;
	
	
	public LinkedList<User> getUserList() {
		return userList;
	}

	public void setUserList(LinkedList<User> userList) {
		this.userList = userList;
	}

	public UserManager() {
		connect = new DB_connection();
		userList = new LinkedList<User>();
		createUserList(DB_connection.selectAll("SELECT * FROM userInfo"));
	}
	
//	Adds a new user with the username, password and adminStatus parameters
	public void addNewUser(String userName, String password, boolean adminStatus) {
		//Creating the user
		User userToAdd = new User(userName, password, adminStatus);
		//Add to the linked list
		userList.add(userToAdd);
		
	}
	
//	Checks the LinkedList of userList to see if the inputed parameters of username and password exist
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
//  the method may encounter an error or exceptional condition during its execution, 
//	and it is indicating that it will not handle the exception itself, but instead, 
//	it will propagate the exception to the caller of the method.
	public void createUserList(ResultSet rs) {
		try {
			while (rs.next()) {
				String un = rs.getString("username");
				String pw = rs.getString("password");
				int admin = rs.getInt("admin");
				boolean adminStatus = false;
				if (admin == 1) {
					adminStatus = true;
				}
				addNewUser(un,pw,adminStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
