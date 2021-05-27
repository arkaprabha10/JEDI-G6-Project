/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 * Exception arises when course has number of students which are either more/less than the recommended range
 */

public class InvalidCourseException extends Exception {

	private String courseID;
	private int numberOfStudents;
	
	/**
	 * Constructor
	 */
	public InvalidCourseException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	numberOfStudents = 0;
	}
	
	/**
	 * setter method
	 * @param courseID
	 * @param numberOfStudents
	 */
	public InvalidCourseException(String courseID, int numberOfStudents) {
		super();
		this.courseID = courseID;
		this.numberOfStudents = numberOfStudents;
	}

	
	/**
	 * getter method
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * Message to return when exception thrown
	 */
	@Override
	public String getMessage() {
		return "CourseID: " + courseID + "already has " + numberOfStudents + " number of students!";
	}
}
