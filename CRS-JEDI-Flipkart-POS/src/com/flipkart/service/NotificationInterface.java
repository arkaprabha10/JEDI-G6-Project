/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.exception.NotificationNotDeliveredException;

/**
 * @author Jayanth
 *
 */
public interface NotificationInterface{
	
	
	 public void sendPayFeesNotification();
	 
	 public void sendPaymentCompleteNotification(int amount, int studentid);
	
}
