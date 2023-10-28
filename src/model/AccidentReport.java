package model;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;  

public class AccidentReport {
	private String accidentNum;
	private String date;
	private DB_connection db;
	
	public String getAccidentNum() {
		return accidentNum;
	}
	public void setAccidentNum(String accidentNum) {
		this.accidentNum = accidentNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String generateDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  
		String temp = dtf.format(now);  
		date = temp;
		return temp;
	}
	

	public String generateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		String temp = dtf.format(now);  
		date = temp;
		return temp;
	}
	
//	Uses Recursion to search through allLpNum array to find target String using binary search method
	public int binarySearch (LinkedList<String> allLpNum, String target,int low,int high) {
//		Checks to see if the convergence between the low and high value has exceeded each other.
//		meaning that the target String is not in the array
		if (low <= high) {
			int mid = low + (high - low) / 2;
			String middleString = allLpNum.get(mid);

//        	target String found and returns the index of it 
            if (middleString.equals(target)) {
                return mid+1; 
            }
// 			Target name is in the right half of the array, performs Recursion to continue the binary search\
            else if (middleString.compareTo(target) < 0) {
                return binarySearch(allLpNum, target, mid + 1, high);
            } 
// 			Target name is in the left half of the array, performs Recursion to continue the binary search 
            else {
                return binarySearch(allLpNum, target, low, mid - 1);
            }
        }
//		target String not in the array
        return -1; 
    }
	
	public int count (ResultSet rs ) {
		int count = 0;
		try {
			while (rs.next()) {
				count = count +1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
//	checks if the given lamp post number is in DB, and return the index for easier accessing in the future
	public int checkLP(String lpNum) throws SQLException {
		ResultSet rs = DB_connection.dbQuery("select LampPostNumber FROM lpInfo","lampost.db");
		LinkedList<String> allLpNum = new LinkedList<String>();
		
//     loops through the ResultSet and transfers data into array 
	   	while (rs.next()) {
			String lpNumTemp = rs.getString("LampPostNumber");
			allLpNum.add(lpNumTemp);
		}
	   	int high = allLpNum.size();
//		stores the result of the binary search (index of where lpNum is)
		int lpNumIndex = binarySearch(allLpNum, lpNum, 0, high);
		System.out.println(lpNumIndex);
		return lpNumIndex;
	}
}
