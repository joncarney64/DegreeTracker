package DegreeTracker;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Arrays;

public class StudentAccount extends Account {
	private Account account;
	private Scanner input;
	private String studentMajorProgram;
	private float currentGPA;
	private float creditsEarned;
	
	private String minorProgram;
	private String secondaryMajorProgram;
	private String gradProgram;
	private String certificateProgram;
	
	private Driver driver;
	
	public StudentAccount() throws SQLException {
		account = new Account();
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
			System.out.println("2 to view current degree program");
			System.out.println("3 to print GPA");
			System.out.println("4 to ....");
			System.out.println("5 to ....");
			System.out.print("> ");
			
			option = input.nextInt();			
			if (option == 1) {
				loggedIn = false;
				System.out.println("Logged out");
			} else if (option == 2) {
				account.printMainProgram(loginID);
			} else if (option == 3) {
				account.printDegreeGPA(loginID);
			} else if (option == 4) {
				
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












