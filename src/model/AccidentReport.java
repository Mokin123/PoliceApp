package model;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.JTextArea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;  

public class AccidentReport {
	private String accidentNum;
	private String date;
	private String time;
	private String severity;
	private boolean [] partiesInvolved;
	private LinkedList<JTextArea> allTextArea;
	private LinkedList<String> texts;
	private LinkedList<byte[]> images;
	private int textSize;
	private int imageSize;
	
	
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
	public String getHour() {
		return time;
	}
	public void setHour(String hour) {
		this.time = hour;
	}
	public LinkedList<String> getTexts() {
		return texts;
	}
	public void setTexts(LinkedList<String> texts) {
		this.texts = texts;
	}
	public LinkedList<byte[]> getImages() {
		return images;
	}
	public void setImages(LinkedList<byte[]> images) {
		this.images = images;
	}
	private void addText(String text) {
		texts.add(text);
	}
	private void addImage(byte[]image) {
		images.add(image);
	}
	public boolean [] getPartiesInvolved() {
		return partiesInvolved;
	}
	public void setPartiesInvolved(boolean [] partiesInvolved) {
		this.partiesInvolved = partiesInvolved;
	}
	public int getTextSize() {
		return textSize;
	}
	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}
	public int getImageSize() {
		return imageSize;
	}
	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}
	public void addTextArea (JTextArea textArea) {
		allTextArea.add(textArea);
	}
	public AccidentReport() {
		this.partiesInvolved = new boolean[]{false,false,false,false,false,false,false,false,false,false};
		this.texts = new LinkedList<String>();
		this.images = new LinkedList<byte[]>();
		this.textSize = 0;
		this.imageSize = 0;
	}
	

	public AccidentReport(String accidentNum,String date,String hour,boolean[] partiesInvolved
						 ,LinkedList<String> texts, LinkedList<byte[]> images) {
		this.accidentNum = accidentNum;
		this.date = date;
		this.time = hour;
		this.partiesInvolved = partiesInvolved;
		this.texts = texts;
		this.images = images;
	}
	
	public String generateDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  
		String dateFormatted = dtf.format(now);  
		date = dateFormatted;
		return dateFormatted;
	}

	public String generateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		String hourFormatted = dtf.format(now);  
		time = hourFormatted;
		return hourFormatted;
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
	public LinkedList<JTextArea> getAllTextArea() {
		return allTextArea;
	}
	public void setAllTextArea(LinkedList<JTextArea> allTextArea) {
		this.allTextArea = allTextArea;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	
	
}
