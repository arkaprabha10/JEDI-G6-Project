/**
 * 
 */
package com.flipkart.service;

/**
 * @author Asus
 * Implementations of Notification Operations
 */
public class NotificationOperation implements NotificationInterface{

	/**
	 * Method to Send PayFee Notification
	 */
	@Override
	public void sendPayFeesNotification() {
		// TODO Auto-generated method stub
		System.out.println("+-----------------------------------+");
		System.out.println("|         Notification Alert!       |");
		System.out.println("+-----------------------------------+");
		System.out.println("|      Registration Completed!      |");
		System.out.println("|    Please Complete Fee Payment!   |");
		System.out.println("+-----------------------------------+");
		
	}

	 /**
	  * Method to send Confirmation Notification
	  * @param amount
	  * @param studentid
	  */
	@Override
	public void sendPaymentCompleteNotification(int amount, int studentid) {
		System.out.println("+-----------------------------------+");
		System.out.println("|         Notification Alert!       |");
		System.out.println("+-----------------------------------+");
		System.out.println("|          Payment Completed!       |");
		System.out.println("|   Student ID: " + studentid);
		System.out.println("|   Amount    : " + amount);
		System.out.println("+-----------------------------------+");
		
	}

}
