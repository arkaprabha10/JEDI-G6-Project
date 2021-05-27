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
 *
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

	@Override
	public RegisteredCourses viewRegisteredCourses(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public int calculateFees(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return 0;
	}

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

	@Override
	public Payment payFees(int studentId, int semesterId, String paymentMode) {
		// TODO Auto-generated method stub
		return null;
	}

}
