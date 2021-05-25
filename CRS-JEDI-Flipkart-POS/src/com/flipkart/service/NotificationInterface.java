/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;

/**
 * @author Jayanth
 *
 */
public interface NotificationInterface{
	
	
	 /**
	  * @param studentId : student to be notified
	  * @param Payment: payment (payment mode,amount and paymentStatus)
	  * @param message : message to send
	  * @return Notification to send
	  */
	 public Notification GenerateNotification(int studentId,Payment payment,String message);
	
	/**
	 * Method to send Notification depending on status:
	 * @param studentId: student to be notified
	 * @return notificationId for the record added in the database
	 */
	 public int sendNotification(int studentId,Notification notification);
	 
	 

	
}
