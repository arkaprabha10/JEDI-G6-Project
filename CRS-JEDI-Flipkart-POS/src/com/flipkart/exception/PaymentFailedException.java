/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Asus
 * Exception arises when Fee payment is failed
 */
public class PaymentFailedException extends Exception {
	
	/**
	 * Message to return when exception is thrown
	 */
	public String getMessage() {
		return "Payment was not successful ! Please try again";
	}
}
