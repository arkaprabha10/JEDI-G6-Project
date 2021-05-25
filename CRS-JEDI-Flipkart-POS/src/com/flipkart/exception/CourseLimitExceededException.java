/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */
public class CourseLimitExceededException extends Exception {


private String studentID;
	
	public CourseLimitExceededException() {
		// TODO Auto-generated constructor stub
	
		studentID = "";
	
	}
	
	
	/**
	 * @param courseID
	 */
	public CourseLimitExceededException(String studentID) {
		super();
		this.studentID = studentID;
	}


	
	/**
	 * @return the courseID
	 */
	public String getstudentID() {
		return studentID;
	}
	
	@Override
	public String getMessage() {
		return "studentID: " + studentID + "has exceeded course Limit!";
	}


}

