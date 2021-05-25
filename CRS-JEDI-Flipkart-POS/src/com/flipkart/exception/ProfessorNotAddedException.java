/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-G6
 *
 */



public class ProfessorNotAddedException extends Exception {
	private String professorId;
	
	public ProfessorNotAddedException(String professorId) {
		this.professorId=professorId;
	}
	
	public String getUserId() {
		return this.professorId;
	}
	
	public String getMessage() {
		return "Professor with id: " + professorId + "is not added yet!";
	}

}
