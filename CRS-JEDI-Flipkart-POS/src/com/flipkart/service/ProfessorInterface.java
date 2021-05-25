/**
 * 
 */
package com.flipkart.service;

/**
 * @author rutwi
 *
 */
public interface ProfessorInterface {
	
	/**
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	public void addGrade(int studentID, String courseID, Grade grade);

}
