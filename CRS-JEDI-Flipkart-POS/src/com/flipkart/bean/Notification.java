/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Notification {
	private String notificationID;
	private String paymentID;
	private String message;

	/**
	 * Default Constructor
	 */
	public Notification() {
		notificationID="null";
		paymentID="null";
		message="NothingToDisplay";
	}
	
	/**
	 * Parameterized Constructor
	 * @param notificationID
	 * @param paymentID
	 * @param message
	 */
	public Notification(String notificationID, String paymentID, String message) {
		super();
		this.notificationID = notificationID;
		this.paymentID = paymentID;
		this.message = message;
	}
	
	/**
	 * Method to get NotificationID
	 * @return NotificationID
	 */
	public String getNotificationID() {
		return notificationID;
	}

	/**
	 * Method to setNotificationID
	 * @param notificationID
	 */
	public void setNotificationID(String notificationID) {
		this.notificationID = notificationID;
	}

	/**
	 * Method to get paymentID
	 * @return paymentID
	 */
	public String getPaymentID() {
		return paymentID;
	}

	/**
	 * Method set paymentID
	 * @param paymentID
	 */
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	/**
	 * Method to get message
	 * @return notification message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Method to set message
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
