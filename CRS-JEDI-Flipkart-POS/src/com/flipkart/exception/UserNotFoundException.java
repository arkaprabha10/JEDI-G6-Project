/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Jayanth
 *
 */
public class UserNotFoundException extends Exception {
	
	private String userId;

	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Message thrown by user
	 */
	@Override
	public String getMessage() {
		return "No such user exists! Verify UserID and try again ";
	}
	
}
