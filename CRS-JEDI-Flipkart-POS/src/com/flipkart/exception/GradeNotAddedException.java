/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Asus
 * Exception arises when grade is not allocated but report cards are generated
 *
 */


public class GradeNotAddedException extends Exception {
	private Integer studentId;
	
	/**
	 * setter method
	 * @param studentId
	 */
	public GradeNotAddedException (Integer studentId) {
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
	 * Message to return when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Grades have not been added for Student ID : " + studentId ;
	}

}
