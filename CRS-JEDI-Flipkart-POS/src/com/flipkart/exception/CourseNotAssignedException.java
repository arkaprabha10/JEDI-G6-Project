/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 * Exception arises when a course is not allocated to any professor
 *
 */

//

public class CourseNotAssignedException extends Exception {
	
private String courseID;
	
	/**
	 * Constructor
	 */
	public CourseNotAssignedException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	
	/**
	 * setter method
	 * @param courseID
	 */
	public CourseNotAssignedException(String courseID) {
		super();
		this.courseID = courseID;
	}


	
	/**
	 * getter
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * Message return when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "CourseID: " + courseID + "has not been allocated to anyone!";
	}

}
