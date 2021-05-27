/**
 * 
 */
package com.flipkart.exception;

/**
 * Exception to check if course is already Present in cataloge
 * @author Dell
 *
 */

//Exception arises when we try to add an existing course to our catalogue

public class CourseAlreadyPresentException extends Exception{
	private String courseID;

	/**
	 * Constructor
	 */
	public CourseAlreadyPresentException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	/**
	 * setter method
	 * @param courseID
	 */
	public CourseAlreadyPresentException(String courseID) {
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
		return "CourseID: " + courseID + "is already present in catalog!";
	}
	
	
	
	
}
