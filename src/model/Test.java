package model;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;    
import java.sql.*;
public class Test{
//	 public static void main(String[] args) {    
////		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
//		   LocalDateTime now = LocalDateTime.now();  
//		   System.out.println(dtf.format(now)); 
//		  }    
//	public static void connect() {  
//      Connection conn = null;  
//      try {  
//          // db parameters  
//          String url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/userInfoSQL.db";  
//          // create a connection to the database  
//          conn = DriverManager.getConnection(url);  
//            
//          System.out.println("Connection to SQLite has been established.");  
//            
//      } catch (SQLException e) {  
//          System.out.println(e.getMessage());  
//      } finally {  
//          try {  
//              if (conn != null) {  
//                  conn.close();  
//              }  
//          } catch (SQLException ex) {  
//              System.out.println(ex.getMessage());  
//          }  
//      }  
//  } 
	
	
	 private String url;
	 private Connection connect() {  
	        // SQLite connection string  
	        url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/userInfoSQL.db";  
	        Connection conn = null;  
	        try {  
	            conn = DriverManager.getConnection(url);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return conn;  
	    }  
	 public void selectAll(){  
	        String sql = "SELECT * FROM userInfo";  
	          
	        try {  
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	              
	            // loop through the result set  
	            while (rs.next()) {  
	                System.out.println(rs.getString("username") +  "\t" +   
	                                   rs.getString("password") + "\t" +  
	                                   rs.getBoolean("admin"));  
	            }  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
//	
 
    /** 
     * @param args the command line arguments 
     */  
 public static void main(String[] args) {  
	 Test app = new Test();  
     app.selectAll();   
  }  

}
