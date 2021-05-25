/**
 * 
 */
package com.flipkart.exception;

/**
 * Exception to check student registered or not
 * @author Jayanth
 *
 */
public class StudentNotRegisteredException extends Exception{
	
	private String studentName;
	private String userId;
	
	public StudentNotRegisteredException(String userID) {
		this.userId=userID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		studentName = studentName;
	}
	public String getStudentID() {
		return userId;
	}
	public void setStudentID(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return studentName +"( "+userId+")"+"not registered, Register and try again";
	}

}
