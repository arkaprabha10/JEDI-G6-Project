/**
 * 
 */
package com.flipkart.exception;

/**
 * Exception thrown when student is not approved
 * @author Jayanth
 *
 */
public class StudentNotApproved extends Exception{
	
	private int studentId;

	/**
	 * getter method
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * setter method
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Message to return when exception is thrown
	 */
	public String getMessage() {
		return "Student "+ studentId +"is not approved";
	}
}
