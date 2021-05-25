/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

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
	
	/**
	 * @param professorID
	 * @return
	 */
	public ArrayList<Student> viewCourseStudents(String courseID);
	
	

}
