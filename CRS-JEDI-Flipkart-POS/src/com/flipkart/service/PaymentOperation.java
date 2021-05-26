/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;

import com.flipkart.bean.RegisteredCourses;
import com.flipkart.dao.PaymentDaoInterface;
import com.flipkart.dao.PaymentDaoOperation;
import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.PaymentFailedException;

/**
 * @author Asus
 *
 */
public class PaymentOperation implements PaymentInterface{

	@Override
	public String makePayment(int studentId, int semesterId, int amount) throws PaymentFailedException {
		
//		PaymentDaoInterface test = PaymentDaoOperation.getInstance();
		PaymentDaoInterface paymentobj = new PaymentDaoOperation();
		
		
		String transactionId = null;
		try {
			transactionId = paymentobj.makePayment(studentId, semesterId, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PaymentFailedException();
		}

		// TODO Auto-generated method stub
		return transactionId;
	}

}
