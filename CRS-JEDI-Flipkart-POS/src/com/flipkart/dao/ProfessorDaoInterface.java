/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;

/**
 * @author rutwi
 *
 */
public interface ProfessorDaoInterface {
	
	/**
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	public void addGrade(int studentID, String courseID, Grade grade) throws SQLException;
	
	/**
	 * @param professorID
	 * @return
	 */
	public ArrayList<Student> viewCourseStudents(String courseID) throws SQLException;
	
	

}
