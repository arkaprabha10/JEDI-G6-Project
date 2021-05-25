/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Payment;

/**
 * @author Jayanth
 *
 */
public interface NotificationInterface {
	
	/**
	 * Method to send Notification depending on status:
	 * @param studentId: student to be notified
	 * @param Payment: has payment mode,amount and paymentstatus
	 * @return notification id for the record added in the database
	 */
	 public int sendNotification(int studentId,Payment payment);
	
}
