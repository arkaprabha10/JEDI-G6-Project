/**
 * 
 */
package com.flipkart.exception;

/**
 * @author rutwi
 *
 */
public class LoginFailedException extends Exception {
	private int userID;
	
	LoginFailedException(int userID)
	{
		this.userID = userID;
	}
	
	public String getMessage() {
		return "Login Failed for User ID: " + userID;
	}

}
