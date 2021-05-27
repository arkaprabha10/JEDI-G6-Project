/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Asus
 * Exception arises When Notification is not send Sucessfully
 */
public class NotificationNotDeliveredException extends Exception {

	/**
	 * Message to return when Exception is thrown
	 */
	public String getMessage() {
		return "Notification Not Delivered!";
	}
}
