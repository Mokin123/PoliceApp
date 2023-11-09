package model;

import java.util.LinkedList;

public class AccidentReportManager {
	private LinkedList<AccidentReport> allReports;

	public LinkedList<AccidentReport> getAllReports() {
		return allReports;
	}

	public void setAllReports(LinkedList<AccidentReport> allReports) {
		this.allReports = allReports;
	}
	public AccidentReport getReport(int index) {
		return allReports.get(index);
	}
	public void addReport (AccidentReport newAccident) {
		allReports.add(newAccident);
	}
	
	public AccidentReport getRecent() {
		int size = allReports.size();
		return allReports.get(size-1);
	}
	
	public AccidentReportManager() {
		allReports = new LinkedList<AccidentReport>();
	}
}
