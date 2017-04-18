//test change
package DegreeTracker;

import java.sql.SQLException;
import java.util.Arrays;
public class Account {

	private String name;
	private String uName;
	private String password;

	private Driver driver;
	
	public Account() throws SQLException {
		driver = new Driver();
	}
	
	// Print student gpa
	public void printDegreeGPA(int id) throws SQLException {
		double gpa;
		gpa = driver.findAccountGPA(id);
		System.out.print("Current GPA: " + gpa + "\n");
	}
	
	public void printMainProgram(int id) throws SQLException {
		String program;
		program = driver.findMainProgram(id);
		System.out.print("Current Main Program: " + program + "\n");
	}
	
	public void showMainDegreeTree(int id) {
		
	}
	
	public void createAccount(String lastName, String firstName, int accountID, int password, String accountType, String email) {
		driver.createAccount(lastName, firstName, accountID, password, accountType, email);
	}
	
	public void createBasketWeavingCourse
	(String abbreviation, int courseNumber, String title, String req1abbreviation, int req1number, String req2abbreviation, int req2number) {
		driver.createBasketWeavingCourse(abbreviation, courseNumber, title, req1abbreviation, req1number, req2abbreviation, req2number);
	}
	
	public void alterAccountPassword(String lastName, int newPassword) {
		driver.alterAccountPassword(lastName, newPassword);
	}
	
	public void deleteAccount(int accountID) {
		driver.deleteAccount(accountID);
	}
	
	
}














