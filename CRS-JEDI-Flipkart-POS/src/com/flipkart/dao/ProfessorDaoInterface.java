/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourses;
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
	public void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) throws SQLException;
	
	/**
	 * @param professorID
	 * @return
	 */
//	View student details for students who are registered in a particular course
	
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws SQLException;

	// view courses which the professor is associated with
	public ArrayList<Course> viewCourseProf(String instructorID) throws SQLException;
	
//	prof registers for course if no one is allocated to it
	public Boolean registerCourse(String instructorID, Integer semesterID,String courseID)throws SQLException;
	

}
