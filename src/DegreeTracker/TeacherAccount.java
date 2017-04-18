package DegreeTracker;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Arrays;

public class TeacherAccount {
	private Scanner input;
	private Driver driver;
	
	private StudentAccount[] studentList;

	public TeacherAccount() throws SQLException {
		driver = new Driver();
		input = new Scanner(System.in);
	}
	
	public int textMenu(int accountId) throws SQLException {
		int loginID = accountId;
		boolean loggedIn = true;
		int option;
		while (loggedIn == true) {
			System.out.println("\n Main menu");
			System.out.println("[Present for developers | 0 to end program]");
			System.out.println("1 to logout");
			System.out.println("2 to create account");
			System.out.println("3 to delete account");
			System.out.println("4 to change an account password");
			System.out.println("5 to ....");
			System.out.print("> ");
			
			option = input.nextInt();			
			if (option == 1) {
				loggedIn = false;
				System.out.println("Logged out");
			} else if (option == 2) {
				// create account
			} else if (option == 3) {
				// delete account
			} else if (option == 4) {
				// change account password
			} else if (option == 5) {
				
			} else if (option == 0) {
				loggedIn = false;
				return 0;
			} else {
				System.out.println("Invalid input");
			}
		}
		return 1;
	}
}
