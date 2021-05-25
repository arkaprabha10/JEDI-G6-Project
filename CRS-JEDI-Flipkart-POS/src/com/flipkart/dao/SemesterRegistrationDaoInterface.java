/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.CourseNotAssignedException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author Asus
 *
 */
public interface SemesterRegistrationDaoInterface {
	
	/**
	 * Method to add Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return the course if it is added successfully, else null
	 */
	public RegisteredCourses addCourse(int studentId, int semesterId, String courseId) throws SQLException;
	
	/**
	 * Method to drop Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return Boolean value indicating if it is was dropped successfully
	 */
	public RegisteredCourses dropCourse(int studentId, int semesterId, String courseId) throws SQLException;
	
	/**
	 * Method to view Courses registered by student 
	 * @param studentId
	 * @param semesterId 
	 * @return list of student's registered courses
	 */
	public List<RegisteredCourses> viewRegisteredCourses(int studentId, int semesterId) throws SQLException;
	
	/**
	 * Method to view all courses available
	 * @return list of all courses with availbale seats
	 */
	public List<RegisteredCourses> viewAvailableCourses(int studentId, int semesterId) throws SQLException;
	
	
	/**
	 * Method to calculate student Fees
	 * @param studentId
	 * @param semesterId
	 * @return total fees to be paid by the student
	 */
	public int calculateFees(int studentId, int semesterId) ;
	
	
	/**
	 * Method to pay student Fees
	 * @param studentId
	 * @param semesterId
	 * @param paymentMode 
	 * @return Boolean value indicating if payment was successful
	 */
	public Payment payFees(int studentId, int semesterId, String paymentMode) throws SQLException ;
	
	
}
