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
 * Interface for Admin Dao Operations
 */
public interface ProfessorDaoInterface {
	
	/**
	 * Method to Grade a Student using SQL commands
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	public void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) throws SQLException;
	
	/**
	 * Method to View student details for students who are registered in a particular course
	 * @param professorID
	 * @return the enrolled students for the corresponding professor and course code.
	 */
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws SQLException;

	/**
	 * Method to view courses which the professor is associated with
	 * @param instructorID
	 * @return the enrolled students for the corresponding professor and course code.
	 * @throws SQLException
	 */
	public ArrayList<Course> viewCourseProf(int instructorID) throws SQLException;
	
	/**
	 * Method for Professor to register for a course if no one is allocated to it
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 * @return true if Successfully registered else false
	 * @throws SQLException
	 */
	public Boolean registerCourse(int instructorID, Integer semesterID,String courseID)throws SQLException;
	

}
