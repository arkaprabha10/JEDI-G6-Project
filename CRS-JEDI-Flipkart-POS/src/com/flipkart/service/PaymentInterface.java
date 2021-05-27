/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.PaymentFailedException;

/**
 * @author Jayanth
 * Interface for Payment Operations
 */
public interface PaymentInterface {
	//Deuplicate in semester registration
//	/**
//	 * @param studentId : student to be notified
//	 * @param registeredCourses : has coursesList of student
//	 * @return : final payableAmount for student
//	 */
//	public float calculatePay(int studentId,RegisteredCourses registeredCourses);


	/**
	 * Method to make Payments
	 * @param payment
	 * @throws PaymentFailedException
	 */
	public void makePayment(Payment payment) throws PaymentFailedException;
	
}
