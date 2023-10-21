package model;

import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
	public static void connect() {  
        Connection conn = null;  
        try {  
            // db parameters  
            String url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/userInfoSQL.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
               
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    } 
 
    /** 
     * @param args the command line arguments 
     */  
 public static void main(String[] args) {  
        connect();  
  }  
}
