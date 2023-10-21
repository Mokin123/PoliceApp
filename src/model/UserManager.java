package model;

import java.util.LinkedList;
import java.sql.*;



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
	
	
//	CODE MODIFIED FROM: https://www.javatpoint.com/java-sqlite
	
//	Initialize connection between app and SQlite database containing userInformation
//	Not needed in main but is needed to establish any sort of connection
	public static Connection connect() {  
        // SQLite connection string (Directory to DB location)
        String url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/userInfoSQL.db";  
        Connection connect = null;  
        try {  
            connect = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return connect;  
    }
    
//	Gets all of the information from the DB, specifically from the userInfo table
	public static ResultSet selectAll(){ 
//		Execution query to be sent to DB
        String sql = "SELECT * FROM userInfo";  
//      Return the results to be processed for GUI
        ResultSet toReturn = null;
        
        try {  
            Connection connect = connect();  
            Statement stmt  = connect.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
            toReturn = rs;
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return toReturn;
    }  
 
    /** 
     * @param args the command line arguments 
     */  
 public static void main(String[] args) {  
        selectAll();
  }  
}
