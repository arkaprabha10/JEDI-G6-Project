/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;

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
	public void addGrade(int studentID, String courseID, Grade grade) throws CourseNotFoundException, GradeNotAddedException;
	
	/**
	 * @param professorID
	 * @return
	 */
	public ArrayList<Student> viewCourseStudents(String courseID) throws CourseNotFoundException;
	
	

}
