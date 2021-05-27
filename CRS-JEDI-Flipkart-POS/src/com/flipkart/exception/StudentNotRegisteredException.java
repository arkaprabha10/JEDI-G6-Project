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
	private Integer studentID;
	
	/**
	 * getter
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}
	
	/**
	 * setter
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		studentName = studentName;
	}
	
	/**
	 * getter method
	 * @return studentID
	 */
	public Integer getStudentID() {
		return studentID;
	}
	
	/**
	 * setter method
	 * @param studentID
	 */
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	/**
	 * Message to return when exception is thrown
	 */
	public String getMessage() {
		return studentName +"( "+studentID+")"+"not registered, Register and try again";
	}

}
