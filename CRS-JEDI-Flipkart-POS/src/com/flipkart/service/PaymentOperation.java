/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;

import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.dao.PaymentDaoInterface;
import com.flipkart.dao.PaymentDaoOperation;
import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.PaymentFailedException;

/**
 * @author Asus
 * Implementations of payment Operations
 */
public class PaymentOperation implements PaymentInterface{

	/**
	 * Method to make Payments
	 * @param payment
	 * @throws PaymentFailedException
	 */
	@Override
	public void makePayment(Payment payment) throws PaymentFailedException {
		
		PaymentDaoInterface paymentObj = new PaymentDaoOperation();

		paymentObj.makePayment(payment);
	}

}
