/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;

/**
 * @author Asus
 *
 */
public interface SemesterRegistrationInterface {
	
	/**
	 * Method to add Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return the course if it is added successfully, else null
	 */
	public RegisteredCourses addCourse(int studentId, int semesterId, String courseId) ;// throws CourseNotFound, CourseNotAvailable, SQLException ;
	
	/**
	 * Method to drop Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return Boolean value indicating if it is was dropped successfully
	 */
	public RegisteredCourses dropCourse(int studentId, int semesterId, String courseId) ;// throws CourseNotFound, SQLException ;
	
	/**
	 * Method to view Courses registered by student 
	 * @param studentId
	 * @param semesterId 
	 * @return list of student's registered courses
	 */
	public List<RegisteredCourses> viewRegisteredCourses(int studentId, int semesterId) ;
	
	/**
	 * Method to view all courses available
	 * @return list of all courses with availbale seats
	 */
	public List<RegisteredCourses> viewAvailableCourses(int studentId, int semesterId) ;
	
	
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
	public Payment payFees(int studentId, int semesterId, String paymentMode) ;
	
	
}
