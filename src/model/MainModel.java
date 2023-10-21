package model;

import java.sql.SQLException;

public class MainModel {
	private UserManager um;
	
	public MainModel() throws SQLException {
		um = new UserManager();
	}
}
