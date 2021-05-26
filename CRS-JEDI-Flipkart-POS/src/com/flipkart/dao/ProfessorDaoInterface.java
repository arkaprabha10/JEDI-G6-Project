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
import com.flipkart.exception.CourseNotAssignedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.NoStudentInCourseException;
import com.flipkart.exception.ProfessorCourseRegistrationException;
import com.flipkart.exception.ProfessorNotAssignedException;
import com.flipkart.exception.ProfessorNotRegisteredException;

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
	public void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) throws SQLException, GradeNotAddedException;
	
	/**
	 * @param professorID
	 * @return
	 */
//	View student details for students who are registered in a particular course
	
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws SQLException,NoStudentInCourseException;

	// view courses which the professor is associated with
	public ArrayList<Course> viewCourseProf(Integer instructorID) throws SQLException,ProfessorNotAssignedException;
	
//	prof registers for course if no one is allocated to it
	public Boolean registerCourse(Integer instructorID, Integer semesterID,String courseID)throws SQLException,ProfessorCourseRegistrationException;
	
	public int getProfessorIDFromUserName(String username) throws SQLException,ProfessorNotRegisteredException;

}
