package model;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;  

public class AccidentReport {
	private String accidentNum;
	private String date;
	private String time;
	private String lampPost;
	private double lat;
	private double lon;
	private int severity;
	private boolean [] partiesInvolved;
	private int pedestrian;
	private int cyclist;
	private int publicBus;
	private int privateBus;
	private int motorCycle;
	private int privateCar;
	private int taxi;
	private int lgv;
	private int hgv;
	private int properties;
	private LinkedList<JTextArea> allTextArea;
//	private LinkedList<String> texts;
//	private LinkedList<byte[]> images;
	private String allText;
	private int textSize;
	private int imageSize;
	public DB_connection db = new DB_connection();
	
	public String getAllText() {
		return allText;
	}
	public void setAllText(String allText) {
		this.allText = allText;
	}
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
	public String getTime() {
		return time;
	}
	public void setTime(String hour) {
		this.time = hour;
	}
	
//	public LinkedList<byte[]> getImages() {
//		return images;
//	}
//	public void setImages(LinkedList<byte[]> images) {
//		this.images = images;
//	}
	
	
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
		this.allTextArea.add(textArea);
	}
	public LinkedList<JTextArea> getAllTextArea() {
		return allTextArea;
	}
	public void setAllTextArea(LinkedList<JTextArea> allTextArea) {
		this.allTextArea = allTextArea;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public String getLampPost() {
		return lampPost;
	}
	public void setLampPost(String lampPost) {
		this.lampPost = lampPost;
	}
	
	public AccidentReport() {
		this.partiesInvolved = new boolean[]{false,false,false,false,false,false,false,false,false,false};
		this.allTextArea = new LinkedList<JTextArea>();
		this.textSize = 0;
		this.imageSize = 0;
		this.allText = "";
	}
	

//	public AccidentReport(String accidentNum,String date,String hour,boolean[] partiesInvolved
//						 ,LinkedList<String> texts, LinkedList<byte[]> images) {
//		this.accidentNum = accidentNum;
//		this.date = date;
//		this.time = hour;
//		this.partiesInvolved = partiesInvolved;
//		
//	}
	
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
            if (middleString.equalsIgnoreCase(target)) {
                return mid+1; 
            }
// 			Target name is in the right half of the array, performs Recursion to continue the binary search\
            else if (middleString.compareToIgnoreCase(target) < 0) {
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
//		System.out.println(lpNumIndex);
		return lpNumIndex;
	}
	public boolean checkEssential(String aN, String date,String hour,  JRadioButton[] severityGroup, String lp) {
		boolean check = true;
		boolean severityCheck = false;
		for (int i=0; i<severityGroup.length;i++) {
			if (severityCheck == false) {
				severityCheck = severityGroup[i].isSelected();
			}
		}
		if (aN.equals("")) {
			JOptionPane.showMessageDialog(null,"Enter a Accident Number",
                    "Upload Failed", 2);
			check = false;
		}
		if (date.equals("YYYY/MM/DD")) {
			JOptionPane.showMessageDialog(null,"Enter a Date",
                    "Upoad Failed", 2);
			check = false;
		}
		if (hour.equals("HH:mm")) {
			JOptionPane.showMessageDialog(null,"Enter a Time",
                    "Upoad Failed", 2);
			check = false;
		}
		if (severityCheck == false) {
			JOptionPane.showMessageDialog(null,"Select a severity",
                    "Upoad Failed", 2);
			check = false;
		}
		try {
			if (checkLP(lp)== -1) {
				JOptionPane.showMessageDialog(null,"Enter a Lamp Post Number",
	                    "Upoad Failed", 2);	
				check = false;
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return check;
	}
	
	public int[] convertPartiesInvolved(JCheckBox[] parties) {
		int[] checkBox = new int[10];
//		Fill array with all 0 (false)
		Arrays.fill(checkBox,0);
		for (int i=0; i<parties.length;i++) {
			if (parties[i].isSelected() == true) {
				checkBox[i] = 1;
			}
		}
		return checkBox;
	}
	public double searchLatLon(int lpIndex,int type) {
		if (type == 1) {
			double lati =  0;
			ResultSet rs = DB_connection.dbQuery("select Latitude FROM lpInfo WHERE rowid = "+ Integer.toBinaryString(lpIndex),"lampost.db");
			try {
				lati =  rs.getDouble("Latitude");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lati;
		}
		else {
			double longi =  0;
			ResultSet rs = DB_connection.dbQuery("select Longitude FROM lpInfo WHERE rowid = "+ Integer.toBinaryString(lpIndex),"lampost.db");
			try {
				longi =  rs.getDouble("Longitude");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return longi;
		}
	}
	
	public int findSeverity(JRadioButton[] severityGroup) {
		int toReturn = 0;
		for (int i=0; i<severityGroup.length;i++) {
			JRadioButton temp = severityGroup[i];
			if (temp.isSelected()) {
				toReturn = i;
			}	
		}
		return toReturn;
	}
	
	public void updateInfo (String aN, String date, String hour, String lp,JRadioButton[] severityGroup,int[] returnedConversion) {
		this.accidentNum = aN;
		this.date = date;
		this.time = hour;
		this.lampPost = lp;
		int lpIndex = 0;
		try {
			lpIndex = checkLP(lp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.lat = searchLatLon(lpIndex,1);
		this.lon = searchLatLon(lpIndex,0);
		this.severity = findSeverity(severityGroup);
		this.pedestrian = returnedConversion [0];
		this.cyclist = returnedConversion [1];
		this.motorCycle = returnedConversion [2];
		this.privateCar = returnedConversion [3];
		this.taxi = returnedConversion [4];
		this.lgv = returnedConversion [5];
		this.hgv = returnedConversion[6];
		this.publicBus = returnedConversion[7];
		this.privateBus = returnedConversion[8];
		this.properties = returnedConversion[9];
		for (int i=0; i< allTextArea.size();i++) {
			JTextArea temp = allTextArea.get(i);
//			System.out.println(temp.getText());
			this.allText = this.allText + temp.getText() + "||||||||||";
			
		}
		System.out.println(allText);
	}
	public void uploadInfo() {
		String url = "jdbc:sqlite:/Users/johnny/git/PoliceApp/src/model/accidentReport.db";
		String execute = "INSERT INTO accidentReport (accidentNum,date,time,lampPost,lat,lon,severity,pedestrian,cyclist,publicBus,privateBus,motorCycle,privateCar,taxi,lgv,hgv,properties,text)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 try (Connection connection = DriverManager.getConnection(url);
				 PreparedStatement statement = connection.prepareStatement(execute)) {
				 statement.setString(1, accidentNum);
				 statement.setString(2, date);
				 statement.setString(3, time);
				 statement.setString(4, lampPost);
				 statement.setDouble(5, lat);
				 statement.setDouble(6, lon);
				 statement.setInt(7, severity);
				 statement.setInt(8, pedestrian);
				 statement.setInt(9, cyclist);
				 statement.setInt(10, publicBus);
				 statement.setInt(11, privateBus);
				 statement.setInt(12, motorCycle);
				 statement.setInt(13, privateCar);
				 statement.setInt(14, taxi);
				 statement.setInt(15, lgv);
				 statement.setInt(16, hgv);
				 statement.setInt(17, properties);
				 statement.setString(18, allText);
		         db.addDatabase(connection, statement);
			}catch (SQLException e) {
		            System.out.println("Error: " + e.getMessage());
		    }
	
	
	
	}
}
