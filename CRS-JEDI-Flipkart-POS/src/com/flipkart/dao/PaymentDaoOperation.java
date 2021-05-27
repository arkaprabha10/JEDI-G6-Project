/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.PaymentFailedException;

import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author Asus
 * Dao class operation for Payment
 */
public class PaymentDaoOperation implements PaymentDaoInterface{

	private static volatile PaymentDaoOperation instance=null;
	private Connection connection=DBUtil.getConnection();
	
	public static void main(String[] args) throws SQLException {
		PaymentDaoOperation test = new PaymentDaoOperation();
	}
	
	/**
	 * Method to make Payment
	 * @param payment
	 */
	@Override
	public void makePayment(Payment payment) throws PaymentFailedException {

		payment.setPaymentID(getNewTransactionID());
		PreparedStatement statement;

		try {

			String sql = "INSERT INTO payments(studentId, amount, transactionId, paymentType, isPaid) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, payment.getStudentID());
			statement.setInt(2, payment.getAmount());
			statement.setInt(3, payment.getPaymentID());
			statement.setString(4, payment.getPaymentMode());
			statement.setBoolean(5, payment.getPaymentStatus());

			statement.executeUpdate();

		} catch (Exception e) {
			throw new PaymentFailedException();
		}
	}

	/**
	 * Method to New transaction ID
	 * @return transactionID
	 */
	private int getNewTransactionID() {

		int newTransactionID = -1;

		try
		{
			//open db connection
			String query = "SELECT MAX(transactionId) FROM payments";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				newTransactionID = rs.getInt("MAX(transactionId)") + 1;
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

		return newTransactionID;
	}

	/**
	 * Method to Update Registered Courses payment
	 */
	private void updateRegisteredCoursesPayment() {

		// to do
	}

	/**
	 * Method to make PaymentDaoOperation Singleton
	 * @return
	 */
	public static PaymentDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(PaymentDaoOperation.class){
				instance=new PaymentDaoOperation();
			}
		}
		return instance;
	}

}