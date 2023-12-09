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
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return connect;  
    }
    
//	Gets all of the information from the DB, specifically from the userInfo table
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
	
	public static void updateDatabase(String url, String execute) {
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(execute)) {

            // Execute the query
            preparedStatement.executeUpdate();

            

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
