package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_connection {
//	CODE MODIFIED FROM: https://www.javatpoint.com/java-sqlite
	
//	Initialize connection between app and SQlite database containing userInformation
//	Not needed in main but is needed to establish any sort of connection
//	"userInfoSQL.db"
//	"lampost.db"
	
	public static Connection connect(String dbName) {  
        // SQLite connection string (Directory to DB location)
        String url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/" + dbName;  
        Connection connect = null;  
        try {  
            connect = DriverManager.getConnection(url);  
        } 
        
        catch (SQLException e) {  
            System.out.println(e.getMessage());
            System.out.println("error");
        }  
        return connect;  
    }
    
	public static ResultSet dbQuery(String query, String dbName){ 
//		Execution query to be sent to DB
        String sql = query;  
//      Return the results to be processed for GUI
        ResultSet toReturn = null;
        try {  
//        	Connect to the SQlite DB
            Connection connect = connect(dbName);  
            Statement stmt = connect.createStatement(); 
//          Sends over the query to DB to be executed
            ResultSet rs = stmt.executeQuery(sql);  
            toReturn = rs;
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return toReturn;
    }  
	
	public void addDatabase(Connection connection, PreparedStatement ps) {
        try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public void addDatabase (String url, String execute) {
//		Connect to database
		try (Connection connection = DriverManager.getConnection(url);
//			create statement to be sent to databse
			PreparedStatement statement = connection.prepareStatement(execute)) {
//			executes the statement
			statement.executeUpdate();
		}catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void removeUserDatabase (String url, String execute,String username, String password) {
//		Connect to database
		try (Connection connection = DriverManager.getConnection(url);
//			create statement to be sent to databse
			PreparedStatement statement = connection.prepareStatement(execute)) {
//			sets values within the statement that was left as "?" in the String execute
			statement.setString(0, username);
			statement.setString(1, password);
//			executes the statement
			statement.executeUpdate();
		}catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
		}
	}
	
}
