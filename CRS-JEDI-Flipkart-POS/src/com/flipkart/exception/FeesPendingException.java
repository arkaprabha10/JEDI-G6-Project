/**
 * 
 */
package com.flipkart.exception;

/**
 * @author mahak
 * Exception arises when Fee is Pending
 */
public class FeesPendingException extends Exception{
	private Integer studentId;
	
	/**
	 * setter method
	 * @param studentId
	 */
	public FeesPendingException (Integer studentId) {
		this.studentId=studentId;
	}
	
	/**
	 * getter method
	 * @return studentId
	 */
	public int  getStudentId() {
		return studentId;
	}

	/**
	 * Message to return when exception is arised
	 */
	public String getMessage() {
		return "Fees has not been paid for Student ID : " + studentId ;
	}
}
