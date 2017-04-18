package DegreeTracker;

public class CourseNode {

	/* old variables
	private int courseID;
	private String courseName;
	private int [] isPreReqOfID;
	*/
	//													V (modified code from the prototype) V
	String abbreviation; //ex. CS
	int courseID; //ex. 401
	String courseName; //ex. Software Engineering
	int isPreReqOfID; //ex. 315
	int boundPosition; // ex -3 (3rd position left from the center) / ex 2 (2nd position right from the center)
	int status; // ex (0) for incomplete / (1) for in progress / (2) for completed
	
	public CourseNode() {
		// used as reference
	}
	
	public CourseNode(String abbr, int crseID, String crseName, int reqID, int boundPos, int stat) {
		
		abbreviation = abbr;
		courseID = crseID;
		courseName = crseName;
		isPreReqOfID = reqID;
		boundPosition = boundPos;
		status = stat;
	}
	
	public String getCourseAbbreviation() {
		return abbreviation;
	}
	
	public int getCourseID() {
		return courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public int getIsPreReqOfID() {
		return isPreReqOfID;
	}
	
	public int getBoundPosition() {
		return boundPosition;
	}
	
	public int getStatus() {
		return status;
	}
	//													^ (modified code from the prototype) ^
}
