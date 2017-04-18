package DegreeTracker;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Arrays;

public class Program {
	private Scanner input;
	private Driver driver;
	private StudentAccount student;
	private TeacherAccount teacher;
	private String accountType;
	private String progName;
	private String progType;
	private CourseNode[] progCourses;
	private boolean loggedIn;
	private double version;
	private int loginID;
	//private Prototype app; // From the prototype
	
	public Program() throws SQLException{
		version = 0.2; // 0.1 - Class Demo / 0.2 - Post Demo development
		driver = new Driver();
		student = new StudentAccount();
		teacher = new TeacherAccount();
		input = new Scanner(System.in);
		//app = new Prototype(); // From the prototype
	}
	
	// Login with account information to access main functions
	public void textLogin() throws SQLException {
		int attempts = 0;
		loggedIn = false;
		loginID = 0;
		System.out.println("Welcome to Degree Tracer Ver." + version);
		while (loggedIn == false) {
			if (attempts > 2) {
				System.out.println("Too many login attempts failed for this time\n");
				textLogin();
				break;
			} else {
				attempts++;
				System.out.println("Please enter your Account ID and password");
				System.out.print("Account ID: ");
				int accountID = input.nextInt();
				System.out.print("Password: ");
				int password = input.nextInt();
				if (driver.findAccountID(accountID, password) == true) {
					loggedIn = true;
					loginID = accountID;
				}
			}
		}
	}
	
	// Logout and return to login method
	public void textLogOut() throws SQLException {
		loggedIn = false; // Back up if menu don't change logged in value into false
		System.out.println("Logged out");
		textMenu();
	}
	
	public String getAccountType(int id) throws SQLException {
		return driver.getAccountType(id);
	}
	
	public void textMenu() throws SQLException {
		textLogin();
		String accountType = this.getAccountType(loginID);
		int result = 1;
		while (true) {
		if (accountType.equals("teacher")) {
			result = teacher.textMenu(loginID);
		} else if (accountType.equals("student")) {
			result = student.textMenu(loginID);
		} else {
			System.out.println("Error: Account does not have a type to use specific functions. ");
		}
		
		if (result == 0) {
			System.out.print("Program Terminated");
			break;
		} else {
			textLogin();
			}
		}
	}
	
	/*
	//															V (modified code from the prototype) V
	public class Prototype {
		private BasketWeavingProgram basketWeaving;
		
		public Prototype() {
			// Basket Weaving Degree Program
			basketWeaving = new BasketWeavingProgram();
			basketWeaving.addCourse("BW", 101, "Introduction to Containers", 10, 0, 2);
			basketWeaving.addCourse("BW", 121, "Introduction to Basket Weaving", 101, 2, 2);
			basketWeaving.addCourse("BW", 201, "Fabrication Materials", 101, -2, 2);
			basketWeaving.addCourse("BW", 215, "Basic Weaving Patters", 111, 2, 2);
			basketWeaving.addCourse("BW", 226, "Ancient Weaving", 215, 2, 2);
			
			basketWeaving.addCourse("BW", 250, "Decoration I", 201, 0, 2);
			basketWeaving.addCourse("BW", 301, "Industrial Materials", 201, -2, 2);
			basketWeaving.addCourse("BW", 321, "Advanced Weaving", 301, 2, 1);
			basketWeaving.addCourse("BW", 326, "Medeival Weaving", 226, 4, 2);
			basketWeaving.addCourse("BW", 327, "Renaissance Weaving", 326, 4, 1);
			
			basketWeaving.addCourse("BW", 370, "Workshop I", 00, -4, 1);
			basketWeaving.addCourse("BW", 400, "Decoration II", 250, 0, 1);
			basketWeaving.addCourse("BW", 402, "Modern Weaving", 327, 4, 0);
			basketWeaving.addCourse("BW", 406, "Ornamate Design", 00, 4, 0);
			basketWeaving.addCourse("BW", 428, "Weaving Theories", 301, 0, 0);
			
			basketWeaving.addCourse("BW", 480, "Internship", 00, -4, 0);
		}

		
		// Print a course based on the Degree Program's tree width with spacing
		public void printCourseNode(int i) {
			String abbre = basketWeaving.arrayList.get(i).getCourseAbbreviation();
			int courseID = basketWeaving.arrayList.get(i).getCourseID();
			String courseName = basketWeaving.arrayList.get(i).getCourseName();
			int isPreReqOfID = basketWeaving.arrayList.get(i).getIsPreReqOfID();
			String status = this.findStatus(i);
			String space;
			int width = this.findWidth();
			int boundPos = this.basketWeaving.arrayList.get(i).getBoundPosition();
			space = this.spacer(width, boundPos);
			
			System.out.print("\n");
			System.out.print("\n" + space + "[" + status + "]");
			System.out.print("\n" + space + abbre);
			System.out.print("\n" + space + courseID);
			System.out.print("\n" + space + courseName);
			System.out.print("\n" + space + isPreReqOfID);
		}

		// find the width of the same level class to center on the middle of the tree
		public int findWidth(){
			int zerolv = 0, onelv = 0, twolv = 0, threelv = 0, fourlv = 0, fivelv = 0, sixlv = 0, sevenlv = 0, eigthlv = 0, width = 0, i = 0, x = 0;
			// Find the total amount of courses in each level
			while (i < basketWeaving.arrayList.size()) {
				if (basketWeaving.arrayList.get(i).courseID < 100) {
					zerolv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 200) {
					onelv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 300) {
					twolv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 400) {
					threelv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 500) {
					fourlv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 600) {
					fivelv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 700) {
					sixlv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 800) {
					sevenlv++;
				} else if (basketWeaving.arrayList.get(i).getCourseID() < 900) {
					eigthlv++;
				} else {
					zerolv++;
				}
				i++;
			}
			// Find the level that has the most courses
					if (width < zerolv) {
						width = zerolv;
					} else if (width < onelv) {
						width = onelv;
					} else if (width < twolv) {
						width = twolv;
					} else if (width < threelv) {
						width = threelv;
					} else if (width < fourlv) {
						width = fourlv;
					} else if (width < fivelv) {
						width = fivelv;
					} else if (width < sixlv) {
						width = sixlv;
					} else if (width < sevenlv) {
						width = sevenlv;
					} else if (width < eigthlv) {
						width = eigthlv;
					}
			//System.out.print("Finding Width");
			return width + 3;
		}

		// Determine the amount of space from the left to center the entire tree
		public String spacer(int initial, int boundPos) {
			initial = (initial + boundPos) * 15;
			char[] chars = new char[initial];
			Arrays.fill(chars, ' ');
			String space = new String(chars);
			return space;
		}
		
		public String findStatus(int i) {
			int stat = basketWeaving.arrayList.get(i).getStatus();
			if (stat == 0) {
				return "Incomplete";
			} else if (stat == 1) {
				return "In Progress";
			} else if (stat == 2) {
				return "Completed";
			} else {
				return "Unknown Status";
			}
		}
		
		// Prints the entire Degree Program with spacing
		public void printTree() {
			int i = 0;
			while (i < basketWeaving.arrayList.size()) {
				this.printCourseNode(i);
				i++;
			}
			System.out.println("\n");
		}
	}
	//													^ (modified code from the prototype) ^

	// Fills BasketWeaving Courses in Basket Weaving Program database
	public void fillBasketWeavingCourses() {
		//createBasketWeavingCourse
		//(String abbreviation, int courseNumber, String title, String req1abbreviation, int req1number, String req2abbreviation, int req2number)
		driver.createBasketWeavingCourse("BW", 101, "Introduction to Containers", "NONE", 0, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 121, "Introduction to Basket Weaving", "BW", 101, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 201, "Fabrication Materials", "BW", 101, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 215, "Basic Weaving Patters", "BW", 201, "BW", 121);
		driver.createBasketWeavingCourse("BW", 226, "Ancient Weaving", "BW", 215, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 250, "Decoration I", "BW", 201, "BW", 226);
		driver.createBasketWeavingCourse("BW", 301, "Industrial Materials", "BW", 201, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 321, "Advanced Weaving", "BW", 215, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 326, "Medeival Weaving", "BW", 226, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 327, "Renaissance Weaving", "BW", 326, "NONE", 0);
		
		driver.createBasketWeavingCourse("BW", 370, "Workshop I", "BW", 301, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 400, "Decoration II", "BW", 250, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 402, "Modern Weaving", "BW", 327, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 406, "Ornamate Design", "BW", 370, "NONE", 0);
		driver.createBasketWeavingCourse("BW", 428, "Weaving Theories", "BW", 301, "BW", 402);
		driver.createBasketWeavingCourse("BW", 480, "Internship","BW", 370, "NONE", 0);
		
		System.out.println("Basket Weaving Courses Filled in the database");
	}
	*/
	
	public static void main(String[] args) throws SQLException{
		Program app = new Program();
		app.textMenu();
		
		//driver.createAccount("Xu", "Wei", 450265, 3333, "myWei@gmail.com");
		//driver.alterAccountPassword("inthasanh", 2222);
		//driver.deleteAccount(450265);
	}
}