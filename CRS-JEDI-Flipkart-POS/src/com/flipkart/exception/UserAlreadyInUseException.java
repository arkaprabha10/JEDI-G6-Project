/**
 * 
 */
package com.flipkart.exception;

/**
 * Exception used in adding user 
 * @author Jayanth
 *
 */

public class UserAlreadyInUseException extends Exception {

	private String userId;

	/**
	 * Getter 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * setter
	 * @param userId
	 */

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Message to thrown if exception occurs
	 */
	@Override
	public String getMessage() {
		return "Provided UserId is already in use";	
	}
}
