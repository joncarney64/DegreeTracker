// Class from the prototype
package DegreeTracker;

import java.util.ArrayList;

public class BasketWeavingProgram {
	ArrayList<CourseNode> arrayList;
	
	public BasketWeavingProgram() {
		arrayList = new ArrayList<CourseNode>();

	}
	
	public CourseNode getCourseNode(int i) {
		return (CourseNode) arrayList.get(i);
	}

	public void addCourse(String abbr, int crseID, String crseName, int reqID, int boundPos, int status) {
		arrayList.add(new CourseNode(abbr, crseID, crseName, reqID, boundPos, status));
	}

	public String getCourseAbbreviation(int i) {
		String courseAbbr = this.getCourseNode(i).getCourseAbbreviation();
		return courseAbbr;
	}

	public int getCourseID(int i) {
		int courseID = this.getCourseNode(i).getCourseID();
		return courseID;
	}

	public String getCourseName(int i) {
		String courseName = this.getCourseNode(i).getCourseName();
		return courseName;
	}

	public int getIsPreReqOfID(int i) {
		int reqID = this.getCourseNode(i).getIsPreReqOfID();
		return reqID;
	}
	
	public int getBoundPosition(int i) {
		int boundPos = this.getCourseNode(i).getBoundPosition();
		return boundPos;
	}
	
	public int getStatus(int i) {
		int status = this.getCourseNode(i).getStatus();
		return status;
	}
	
}
