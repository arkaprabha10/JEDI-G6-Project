/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Asus
 * Exception arises when fetched for Professor who is not in DB
 *  
 */
public class ProfessorNotAddedException extends Exception{
	private String professorId;
	
	/**
	 * setter method
	 * @param professorId
	 */
	public ProfessorNotAddedException(String professorId) {
		this.professorId=professorId;
	}
	
	/**
	 * getter method
	 */
	public String getUserId() {
		return this.professorId;
	}
	
	/**
	 * Message to return when exception is thrown
	 */
	public String getMessage() {
		return "Professor with id: " + professorId + "is not added yet!";
	}

}
