/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 * Exception arises when student tries to register for an already registered course
 */

public class CourseAlreadyRegisteredException extends Exception{

	private String courseID;
	
	/**
	 * Constructor
	 */
	public CourseAlreadyRegisteredException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	
	/**
	 * setter method
	 * @param courseID
	 */
	public CourseAlreadyRegisteredException(String courseID) {
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
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "CourseID: " + courseID + "is already registered!";
	}
}
