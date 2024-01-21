package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.UserManager;
import model.DB_connection;

public class Admin extends User {
	UserManager um = new UserManager();
	static DB_connection db = new DB_connection();
	public Admin(String username, String password) {
        super(username, password);
    }
	
	public boolean getAdmin () {
		return true;
	}
	
	public void addUser(String username, String password,boolean admin) {
		um.createUserList();
		boolean check = um.checkUser(username,password);
		System.out.println("check user"+check);
		if (check == false) {
			
			String url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/userInfoSQL.db";
			
			String statement = "INSERT INTO userInfo (username,password,admin)"
			+ " VALUES ('"+username+"','"+password+"','"+admin+"')";
			
			db.addDatabase(url,statement);
			
		}
		else {
			JOptionPane.showMessageDialog(null,"User already exist",
                    "Add new user fail", 2);
		}
	}
	
	public static void deleteData(String username, String password) {
		String url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/userInfoSQL.db";
		
        String statement = "DELETE FROM users WHERE name = '"+username+"' AND password = '"+password+"'";
        
		db.removeUserDatabase(url,statement,username,password);

    }
	
}
