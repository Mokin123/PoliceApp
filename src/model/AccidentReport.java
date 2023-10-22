package model;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class AccidentReport {
	private String accidentNum;
	private String date;
	
	
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
}
