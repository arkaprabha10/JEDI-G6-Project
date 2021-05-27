/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyInUseException;

/**
 * @author rutwi
 * Interface for Student Dao Operations
 */
public interface StudentDaoInterface {
	
	/**
	 * Method to view Report Card
	 * @param StudentID
	 * @param semesterId
	 * @return reportCard
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */
	public ReportCard viewReportCard(int StudentID, int semesterId) throws SQLException, GradeNotAddedException, StudentNotApprovedException, FeesPendingException;

	/**
	 * Method to view Registered Courses
	 * @param studentID
	 * @param semesterId
	 * @return list of registeredCourses
	 * @throws SQLException
	 * @throws StudentNotRegisteredException
	 */
	public List<Course> viewRegisteredCourses(int studentID, int semesterId) throws SQLException, StudentNotRegisteredException;
	

	/**
	 * Method to add Student in database
	 * @param student
	 * @return Student
	 * @throws SQLException
	 * @throws UserAlreadyInUseException
	 */
	public Student addStudent(Student student) throws SQLException, UserAlreadyInUseException;
	
	/**
	 * Method to get StudentId from username
	 * @param username
	 * @return StudentId
	 * @throws StudentNotRegisteredException
	 * @throws SQLException
	 */
	public int getStudentIDFromUserName(String username) throws StudentNotRegisteredException,SQLException;
	
}
