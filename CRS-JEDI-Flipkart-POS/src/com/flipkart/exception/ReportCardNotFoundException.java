/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 * Exception arises when the report card for a student ID doesnt exist
 * 
 */


public class ReportCardNotFoundException extends Exception{
	
private String studentID;
	
	/**
	 * Constructor
	 */
	public ReportCardNotFoundException() {
		// TODO Auto-generated constructor stub
	
		studentID = "";
	
	}
	
	
	/**
	 * setter method
	 * @param courseID
	 */
	public ReportCardNotFoundException(String studentID) {
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
	 * Message to return when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Report Card for studentID: " + studentID + "not found!";
	}

}
