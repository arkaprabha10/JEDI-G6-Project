/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 * Exception arises when student has taken more than the recommended limit of courses
 * 
 */

//

public class CourseLimitExceededException extends Exception {


private String studentID;
	
	/*
	 * Constructor
	 */
	public CourseLimitExceededException() {
		// TODO Auto-generated constructor stub
	
		studentID = "";
	
	}
	
	
	/**
	 * setter method
	 * @param courseID
	 */
	public CourseLimitExceededException(String studentID) {
		super();
		this.studentID = studentID;
	}


	
	/**
	 * getter method
	 * @return the courseID
	 */
	public String getstudentID() {
		return studentID;
	}
	
	/**
	 * Message return when exception thrown
	 */
	@Override
	public String getMessage() {
		return "studentID: " + studentID + "has exceeded course Limit!";
	}


}

