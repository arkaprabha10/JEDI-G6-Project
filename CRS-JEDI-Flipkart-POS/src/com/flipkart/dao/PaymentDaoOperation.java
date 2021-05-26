/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.PaymentFailedException;

import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author Asus
 *
 */
public class PaymentDaoOperation implements PaymentDaoInterface{
	
	private PreparedStatement statement = null;
	private static volatile PaymentDaoOperation instance=null;
	
//	public static void main(String[] args) throws SQLException {
//		
//		PaymentDaoInterface test = new PaymentDaoOperation();
//		test.makePayment(2,2,200);
//		System.out.println("hello");
//	}
	
	@Override
	public String makePayment(int studentId, int semesterId, int amount){
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO payments(studentId, semesterId, amount, transactionId,is_payed) VALUES (?, ?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		
		String transactionId = null;
		String is_payed = null;
		
		try {
			statement = connection.prepareStatement(sql);
			transactionId = Integer.toString(studentId)+"_PAYED";
			is_payed = "yes";
			statement.setInt(1, studentId);
			statement.setInt(2, semesterId);
			statement.setInt(3, amount);
			statement.setString(4, transactionId);
			statement.setString(5, is_payed);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionId;
		
	}
	
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