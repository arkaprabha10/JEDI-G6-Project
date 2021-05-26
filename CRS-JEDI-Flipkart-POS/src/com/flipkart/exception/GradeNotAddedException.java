/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-G6
 *
 */

//Exception arises when grade is not properly allocated 

public class GradeNotAddedException extends Exception {
	private Integer studentId;
	public GradeNotAddedException (Integer studentId) {
		this.studentId=studentId;
	}
	public int  getStudentId() {
		return studentId;
	}

	@Override
	public String getMessage() {
		return "Grades have not been added for Student ID : " + studentId ;
	}

}
