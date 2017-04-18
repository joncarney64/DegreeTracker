package DegreeTracker;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {
	private String url;
	private String user;
	private String password;
	private Connection conn;
	private java.sql.Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rS;
	

	public Driver() throws SQLException {
		url = "jdbc:mysql://localhost:3306/degreetrackerdb"; 
		user = "root";
		password = "mysql1002405";	
		conn = null;
		stmt = null;
		pStmt = null;
		rS = null;
		
		// Setting up connection with DegreeTracker MySQL Database
		try {
			// Establishing connection
			conn = DriverManager.getConnection(url, user, password);		
			// Create a statement
			stmt = conn.createStatement();
			/* Print tables
			rS = stmt.executeQuery("select * from account");
			
			while (rS.next()) {
				System.out.println(rS.getString("last_name") + ", " + rS.getString("first_name"));
			}
			*/
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	public String getAccountType(int id) throws SQLException {
		ResultSet rS = null;
		rS = stmt.executeQuery("select * from account");
		String accountType = null;
		try {
			while (rS.next()) {
				if (rS.getInt("accountID") == id) {
					accountType = rS.getString("accountType");
					break;
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return accountType;
	}
	
	// Create an account
	public void createAccount(String lastName, String firstName, int accountID, int password, String accountType, String email) {
		ResultSet rS = null;
		try {
			pStmt = conn.prepareStatement("insert into account" + " (last_name, first_name, accountID, password, accountType email) " + " values (?, ?, ?, ?, ?, ?)");
			pStmt.setString(1, lastName);
			pStmt.setString(2, firstName);
			pStmt.setInt(3, accountID);
			pStmt.setInt(4, password);
			pStmt.setString(5, accountType);	
			pStmt.setString(6, email);			
			int rowsAffected = pStmt.executeUpdate();			
			System.out.println("Account created");		
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	// Create a Basket Weaving Course
	public void createBasketWeavingCourse
			(String abbreviation, int courseNumber, String title, String req1abbreviation, int req1number, String req2abbreviation, int req2number) {
		ResultSet rS = null;
		try {
			pStmt = conn.prepareStatement("insert into basketweaving" + " (abbreviation, coursenumber, title, req1abbreviation, req1number, req2abbreviation, req2number)"
					+ "" + " values (?, ?, ?, ?, ?, ?, ?)");
			pStmt.setString(1,abbreviation);
			pStmt.setInt(2, courseNumber);
			pStmt.setString(3, title);
			pStmt.setString(4, req1abbreviation);
			pStmt.setInt(5, req1number);
			pStmt.setString(6, req2abbreviation);
			pStmt.setInt(7, req2number);
			int rowsAffected = pStmt.executeUpdate();			
			System.out.println("Course created");		
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	// Change an Account password
	public void alterAccountPassword(String lastName, int newPassword) {
		ResultSet rS = null;
		try {
			pStmt = conn.prepareStatement("update account " + " set password= ? " + " where last_name= ?");
			pStmt.setInt(1, newPassword);
			pStmt.setString(2, lastName);			
			int rowsAffected = pStmt.executeUpdate();		
			System.out.println("Account changed");	
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	// Delete an Account by its id from the database
	public void deleteAccount(int accountID) {
		ResultSet rs = null;
		try {
			pStmt = conn.prepareStatement("delete from account where accountID= ?");
			pStmt.setInt(1, accountID);		
			int rowsAffect = pStmt.executeUpdate();		
			System.out.println("Account " + accountID + " " + "Deleted");	
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	// Find an Account by id and password  within the database
	public boolean findAccountID(int id, int password) throws SQLException {
		boolean result = false;
		ResultSet rS = null;
		rS = stmt.executeQuery("select * from account");
		try {
			while (rS.next()) {
				if ( (rS.getInt("accountID") == id) && (rS.getInt("password") == password) ) {
					result = true;
					break;
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return result;
	}
	
	public double findAccountGPA(int id) throws SQLException {
		ResultSet rS = null;
		rS = stmt.executeQuery("select * from account");
		double gpa = 0.0;
		try {
			while (rS.next()) {
				if (rS.getInt("accountID") == id) {
					gpa = rS.getInt("gpa");
					break;
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return gpa;
	}
	
	public String findMainProgram(int id) throws SQLException {
		ResultSet rS = null;
		rS = stmt.executeQuery("select * from account");
		String program = "";
		try {
			while (rS.next()) {
				if (rS.getInt("accountID") == id) {
					program = rS.getString("mainProgram");
					break;
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return program;
	}

}







