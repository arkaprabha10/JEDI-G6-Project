/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.dao.SemesterRegistrationDaoOperation;

/**
 * @author Asus
 *
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface{

	@Override
	public boolean addCourse(int studentId, int semesterId, String courseId) {

		SemesterRegistrationDaoOperation srdo = SemesterRegistrationDaoOperation.getInstance();

		return srdo.addCourse(studentId, semesterId, courseId);
	}

	@Override
	public boolean dropCourse(int studentId, int semesterId, String courseId) {

		SemesterRegistrationDaoOperation srdo = SemesterRegistrationDaoOperation.getInstance();

		return srdo.dropCourse(studentId, semesterId, courseId);
	}

	@Override
	public RegisteredCourses viewRegisteredCourses(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> viewAvailableCourses() {

		SemesterRegistrationDaoOperation srdo = SemesterRegistrationDaoOperation.getInstance();

		return srdo.viewAvailableCourses();
	}

	@Override
	public int calculateFees(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean finishRegistration(int studentId, int semesterId) {
		SemesterRegistrationDaoOperation srdo = SemesterRegistrationDaoOperation.getInstance();

		return srdo.finishRegistration(studentId, semesterId);
	}

	@Override
	public Payment payFees(int studentId, int semesterId, String paymentMode) {
		// TODO Auto-generated method stub
		return null;
	}

}
