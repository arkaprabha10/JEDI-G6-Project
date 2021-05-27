/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.exception.NotificationNotDeliveredException;

/**
 * @author Jayanth
 * Interface for Notification Operations
 */
public interface NotificationInterface{
	
	/**
	 * Method to Send PayFee Notification
	 */
	 public void sendPayFeesNotification();
	 
	 /**
	  * Method to send Confirmation Notification
	  * @param amount
	  * @param studentid
	  */
	 public void sendPaymentCompleteNotification(int amount, int studentid);
	
}
