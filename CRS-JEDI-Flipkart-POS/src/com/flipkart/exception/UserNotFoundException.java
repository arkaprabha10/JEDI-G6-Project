/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Jayanth
 *	Exception arises when fetched for UserID which is not listed in DB
 */
public class UserNotFoundException extends Exception {
	
	private String userId;

	/**
	 * setter
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * Message return when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "No such user exists! Verify userID and try again ";
	}
	
}
