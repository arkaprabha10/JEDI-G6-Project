/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotAssignedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;

/**
 * 
 * @author rutwi
 * Interface for Professor Operations
 * 
 */
public interface ProfessorInterface {
	
	/**
	 * Method to Grade Student updates in database
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	public void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) throws GradeNotAddedException;


	/**
	 * Method to view all enrolled Students
	 * @param courseID
	 * @param semesterID
	 * @throws CourseNotFoundException
	 */
	public void viewCourseStudents(String courseID, Integer semesterID) throws CourseNotFoundException;
	
	/**
	 * Method to view professor with Id
	 * @param instructorID
	 */
	public void viewCourseProf(int instructorID) ;
	
	/**
	 * Method to register Professor to particular course 
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 * @throws SQLException
	 */
	public void registerCourse(int instructorID, Integer semesterID, String courseID) throws SQLException;
	
	

}
