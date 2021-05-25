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
public interface NotificationInterface {
	
	/**
	 * Method to send Notification depending on status:
	 * @param studentId: student to be notified
	 * @param Payment: payment (payment mode,amount and paymentStatus)
	 * @return notificationId for the record added in the database
	 */
	 public int sendNotification(int studentId,Payment payment,Notification notification);
	 
	 
	 /**
	  * @param studentId : student to be notified
	  * @param message : message to send
	  * @return
	  */
	 public Notification GenerateNotification(int studentId,int notificationId,String message);
	
}
