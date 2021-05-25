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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	@Override
	public String getMessage() {
		return "Student "+ studentId +"is not approved";
	}
}
