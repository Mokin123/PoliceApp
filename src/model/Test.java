package model;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;    
import java.sql.*;
//public class Test{
//	 public static void main(String[] args) {    
////		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
//		   LocalDateTime now = LocalDateTime.now();  
//		   System.out.println(dtf.format(now)); 
//		  }    
//	
//	USE THE FOLLOWING TO COUNT THE TO COUNT THE TOTAL NUM OF ROWS
//	int rowCount = 0;
//    while (resultSet.next()) {
//         rowCount++;
//    }
	
//	
//	 private String url;
//	 private Connection connect() {  
//	        // SQLite connection string  
//	        url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/userInfoSQL.db";  
//	        Connection conn = null;  
//	        try {  
//	            conn = DriverManager.getConnection(url);  
//	        } catch (SQLException e) {  
//	            System.out.println(e.getMessage());  
//	        }  
//	        return conn;  
//	    }  
//	 public void selectAll(){  
//	        String sql = "SELECT * FROM userInfo";  
//	          
//	        try {  
//	            Connection conn = this.connect();  
//	            Statement stmt  = conn.createStatement();  
//	            ResultSet rs    = stmt.executeQuery(sql);  
//	              
//	            // loop through the result set  
//	            while (rs.next()) {  
//	                System.out.println(rs.getString("username") +  "\t" +   
//	                                   rs.getString("password") + "\t" +  
//	                                   rs.getBoolean("admin"));  
//	            }  
//	        } catch (SQLException e) {  
//	            System.out.println(e.getMessage());  
//	        }  
//	    }  
////	
// 
//    /** 
//     * @param args the command line arguments 
//     */  
//	
//	public static int binarySearch (String[] allLpNum, String target,int low,int high) {
////		Checks to see if the convergence between the low and high value has exceeded each other.
////		meaning that the target String is not in the array
//		if (low <= high) {
//			int mid = low + (high - low) / 2;
//
////        	target String found and returns the index of it 
//            if (allLpNum[mid].equals(target)) {
//                return mid; 
//            }
//// 			Target name is in the right half of the array, performs Recursion to continue the binary search\
//            else if (allLpNum[mid].compareTo(target) < 0) {
//                return binarySearch(allLpNum, target, mid + 1, high);
//            } 
//// 			Target name is in the left half of the array, performs Recursion to continue the binary search 
//            else {
//                return binarySearch(allLpNum, target, low, mid - 1);
//            }
//        }
////		target String not in the array
//        return -1; 
//    }
// public static void main(String[] args) {  
//	 String [] temp = {"A","B","C","D","E","F"};
//	 String[] temp3 = new String[10];
//	 temp3[9] = "4";
//	 int temp2 = binarySearch(temp,"A",0,5);
//	 System.out.println(temp3[9]);
// }  
import java.io.FileInputStream;
import java.io.IOException;
import model.UserManager;
import model.DB_connection;

public class Test {
    public static void main(String[] args) {
    		if (um.checkUser("test", "test") == true) {
    			System.out.println(true);
    		}
    		else {
    			System.out.println(false);
    		}
    		
//        String imagePath = "/Users/johnny/git/PoliceApp/image/HKPF_275.png"; // Replace with the actual path of your image file
//
//        try {
//            byte[] imageBytes = convertImageToByteArray(imagePath);
//            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
//        FileInputStream fis = null;
//        byte[] imageBytes = null;
//
//        try {
//            fis = new FileInputStream(imagePath);
//            imageBytes = new byte[fis.available()];
//            fis.read(imageBytes);
//        } finally {
//            if (fis != null) {
//                fis.close();
//            }
//        }
//
//        return imageBytes;
    	
//    	LinkedList<String> temp = new LinkedList<String>();
//    	temp.add("hello");
//    	System.out.println(temp.size());
//    	System.out.println(temp.get(0));
//    	public int binarySearch (LinkedList<String> allLpNum, String target,int low,int high) {
////    		
//    		if (low <= high) {
//    			int mid = low + (high - low) / 2;
//    			String middleString = allLpNum.get(mid);
//                if (middleString.equals(target)) {
//                    return mid+1; 
//                }
//                else if (middleString.compareTo(target) < 0) {
//                    return binarySearch(allLpNum, target, mid + 1, high);
//                } 
//                else {
//                    return binarySearch(allLpNum, target, low, mid - 1);
//                }
//            }
//            return -1; 
//        }
    }
}