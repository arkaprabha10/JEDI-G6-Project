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
public class SemesterRegistrationImplementation implements SemesterRegistrationInterface{

	@Override
	public RegisteredCourses addCourse(int studentId, int semesterId, String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredCourses dropCourse(int studentId, int semesterId, String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredCourses> viewRegisteredCourses(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredCourses> viewAvailableCourses(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateFees(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Payment payFees(int studentId, int semesterId, String paymentMode) {
		// TODO Auto-generated method stub
		return null;
	}

}
