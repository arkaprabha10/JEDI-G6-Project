/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-G6
 *
 */
public class ProfessorNotAddedException {
	private String professorId;
	
	public ProfessorNotAddedException(String professorId) {
		this.professorId=professorId;
	}
	
	public String getUserId() {
		return this.professorId;
	}
	
	@Override
	public String getMessage() {
		return "Professor with id: " + professorId + "is not added yet!";
	}

}
