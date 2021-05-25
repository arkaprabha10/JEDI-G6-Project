/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */
public class CourseAlreadyRegisteredException extends Exception{

	private String courseID;
	
	public CourseAlreadyRegisteredException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	
	/**
	 * @param courseID
	 */
	public CourseAlreadyRegisteredException(String courseID) {
		super();
		this.courseID = courseID;
	}


	
	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	@Override
	public String getMessage() {
		return "CourseID: " + courseID + "is already registered!";
	}
}
