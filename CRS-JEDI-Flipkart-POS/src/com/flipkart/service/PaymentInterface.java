/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.RegisteredCourses;

/**
 * @author Jayanth
 *
 */
public interface PaymentInterface {

	/**
	 * 
	 * @param studentId : student to be notified
	 * @param registeredCourses : has coursesList of student
	 * @return : final payableAmount for student
	 */
	public float calculatepay(int studentId,RegisteredCourses registeredCourses);
	
}
