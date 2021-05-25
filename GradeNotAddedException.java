/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-G6
 *
 */
public class GradeNotAddedException extends Exception {
	private Integer studentId;
	public GradeNotAddedException (Integer studentId) {
		this.studentId=studentId;
	}
	public int  getStudentId() {
		return studentId;
	}

}
