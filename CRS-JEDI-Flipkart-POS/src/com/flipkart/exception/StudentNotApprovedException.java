/**
 * 
 */
package com.flipkart.exception;

/**
 * Exception thrown when student is not approval
 * @author Jayanth
 *
 */
public class StudentNotApprovedException extends Exception{
	
	private int studentId;

	/**
	 * setter method
	 * @param studentId
	 */
	public StudentNotApprovedException(Integer studentId) {
		this.studentId=studentId;
	}
	
	/**
	 * getter method
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * setter method
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Message to return when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Student "+ studentId +"is not approved";
	}
}
