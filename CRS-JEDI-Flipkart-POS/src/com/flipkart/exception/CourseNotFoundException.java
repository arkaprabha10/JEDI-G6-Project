/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 * Exception arises when course doesnt exist in the course catalog
 *
 */

//

public class CourseNotFoundException extends Exception {
	private String courseID;
	
	/**
	 * Constructor
	 */
	public CourseNotFoundException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	
	/**
	 * setter method
	 * @param courseID
	 */
	public CourseNotFoundException(String courseID) {
		super();
		this.courseID = courseID;
	}


	
	/**
	 * getter method
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * Message to return when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "CourseID: " + courseID + "is not present in course catalogue!";
	}

}
