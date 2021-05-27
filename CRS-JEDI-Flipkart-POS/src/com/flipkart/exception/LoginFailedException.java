/**
 * 
 */
package com.flipkart.exception;

/**
 * @author rutwi
 * Exception arises when Login Operation is failed
 */
public class LoginFailedException extends Exception {
	private int userID;
	
	/**
	 * setter method
	 * @param userID
	 */
	LoginFailedException(int userID)
	{
		this.userID = userID;
	}
	
	/**
	 * Message to return when exception is thrown
	 */
	public String getMessage() {
		return "Login Failed for User ID: " + userID;
	}

}
