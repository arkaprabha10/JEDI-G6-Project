/**
 * 
 */
package com.flipkart.exception;

/**
 * Exception thrown when student is not approval
 * @author Jayanth
 *
 */
public class StudentNotApproval extends Exception{
	
	private int studentId;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getmessage() {
		return "Student "+ studentId +"is not approved";
	}
	
}
