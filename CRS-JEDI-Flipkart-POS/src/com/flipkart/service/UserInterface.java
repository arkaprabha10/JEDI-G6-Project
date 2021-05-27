/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.*;

/**
 * 
 * @author rutwi
 * Interface for User Operations
 * 
 */
public interface UserInterface {
	
	/**
	 * Method to update Password of user
	 * @param userID
	 * @param password
	 */
	public void updatePassword(String userID, String password) throws UserNotFoundException;
	
	/**
	 * Method to Update Contact Number of user
	 * @param userID
	 * @param number
	 */
	public void updateContactNumber(String userID, String number) throws UserNotFoundException;
	
	/**
	 * Method to update Role of user
	 * @param userID
	 * @param role
	 */
	public void updateRole(String userID, String role) throws UserNotFoundException;
	
	/**
	 * Method to verify user credentials
	 * @param userID
	 * @param password
	 * @return indicating if user exists in the database
	 */
	public boolean loginUser(String userID, String password, String role) throws UserNotFoundException;
	

}
