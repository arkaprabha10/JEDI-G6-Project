/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.dao.SemesterRegistrationDaoInterface;
import com.flipkart.dao.SemesterRegistrationDaoOperation;

/**
 * @author Asus
 * Implementations of SemesterRegistration Operations
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface{
	
	private static volatile SemesterRegistrationOperation instance = null;
	
	SemesterRegistrationDaoInterface srdo = SemesterRegistrationDaoOperation.getInstance();

	private SemesterRegistrationOperation() {
	}

	/**
	 * Method to make Registration Operation Singleton
	 * 
	 * @return
	 */
	public static SemesterRegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (SemesterRegistrationOperation.class) {
				instance = new SemesterRegistrationOperation();
			}
		}
		return instance;
	}

	/**
	 * Method to add Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return the course if it is added successfully, else null
	 */
	@Override
	public boolean addCourse(int studentId, int semesterId, String courseId, boolean isPrimary) {

//		SemesterRegistrationDaoOperation srdo = new SemesterRegistrationDaoOperation();

		try {
			return srdo.addCourse(studentId, semesterId, courseId, isPrimary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Method to drop Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return Boolean value indicating if it is was dropped successfully
	 */
	@Override
	public boolean dropCourse(int studentId, int semesterId, String courseId) {

//		SemesterRegistrationDaoOperation srdo = new SemesterRegistrationDaoOperation();

		try {
			return srdo.dropCourse(studentId, semesterId, courseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Method to view Courses registered by student 
	 * @param studentId
	 * @param semesterId 
	 * @return list of student's registered courses
	 */
	@Override
	public RegisteredCourses viewRegisteredCourses(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to view all courses available
	 * @return list of all courses with availbale seats
	 */
	@Override
	public ArrayList<Course> viewAvailableCourses() {

//		SemesterRegistrationDaoOperation srdo = new SemesterRegistrationDaoOperation();

		try {
			return srdo.viewAvailableCourses();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method to calculate student Fees
	 * @param studentId
	 * @param semesterId
	 * @return total fees to be paid by the student
	 */
	@Override
	public int calculateFees(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param studentId
	 * @param semesterId
	 * @return true if finshed else false
	 */
	@Override
	public boolean finishRegistration(int studentId, int semesterId) {
//		SemesterRegistrationDaoOperation srdo = new SemesterRegistrationDaoOperation();

		try {
			return srdo.finishRegistration(studentId, semesterId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Method to pay student Fees
	 * @param studentId
	 * @param semesterId
	 * @param paymentMode 
	 * @return Boolean value indicating if payment was successful
	 */
	@Override
	public Payment payFees(int studentId, int semesterId, String paymentMode) {
		// TODO Auto-generated method stub
		return null;
	}

}
