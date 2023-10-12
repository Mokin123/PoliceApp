package model;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Test{
	 public static void main(String[] args) {    
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		  }    

}
