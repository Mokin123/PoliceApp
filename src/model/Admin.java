package model;

class Admin extends User {
	public Admin(String username, String password) {
        super(username, password);
    }
	public boolean getAdmin () {
		return true;
	}
	public void addUser(String username, String password) {
		
	}
}
