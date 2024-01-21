package model;

import java.util.LinkedList;
import java.sql.*;
import model.Admin;


public class UserManager {
//	LinkedList chosen due to it being a dynamic data structure, as there is a possibility 
//	for admin to add a new user
	private LinkedList<User> userList;
	private User currUser;
	public User getCurrUser() {
		return currUser;
	}

	public void setCurrUser(User currUser) {
		this.currUser = currUser;
	}

	public LinkedList<User> getUserList() {
		return userList;
	}

	public void setUserList(LinkedList<User> userList) {
		this.userList = userList;
	}

	public void createUserList() {
		userList = new LinkedList<User>();
//									         DBquery to get all data   connect to this DB
		createUserList(DB_connection.dbQuery("SELECT * FROM userInfo","userInfoSQL.db"));
	}
	
//	Adds a new user with the username, password and adminStatus parameters
	public void addNewUser(String userName, String password,boolean admin) {
//		System.out.println(admin);
		if (admin == false) {
			//Creating the user
			User userToAdd = new User(userName, password);
			//Add to the linked list
			userList.add(userToAdd);
		}
		else {
			Admin userToAdd = new Admin(userName, password);
//			User nUser = userToAdd;
			//Add to the linked list
			userList.add(userToAdd);
			
			}
//			
		}
		
	
	
	
//	Checks the LinkedList of userList to see if the inputed parameters of username and password exist
	
	public boolean checkUser(String username,String password) {
		boolean check = false;
//		Loops though the entire userList to perform a check
		for (int i=0;i<userList.size();i++) {
			User user = userList.get(i);
//			if statement checks if both username and password of a user in userList is the same
			if (user.getUsername().equals(username) && user.checkPassword(password)==true) {
				check = true;
				currUser = user;
			}
		}
		return check;
	}
	
//  the method may encounter an error or exceptional condition during its execution, 
//	and it is indicating that it will not handle the exception itself, but instead, 
//	it will propagate the exception to the caller of the method.
	public void createUserList(ResultSet rs) {
		try {
//			while there is a next row in rs (the entire user information DB)
			while (rs.next()) {
				String un = rs.getString("username");
				String pw = rs.getString("password");
				int admin = rs.getInt("admin");
				boolean adminStatus = false;
				if (admin == 1) {
					adminStatus = true;
				}
//				Adds the user informaiton into a linked list easier checking 
//				System.out.println(adminStatus);
				addNewUser(un,pw,adminStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
