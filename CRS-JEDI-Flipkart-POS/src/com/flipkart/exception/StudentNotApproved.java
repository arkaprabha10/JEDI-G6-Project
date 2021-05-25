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
