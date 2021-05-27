package com.flipkart.service;

import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;


/**
 * 
 * @author Jayanth
 * Implementations of User Operations
 * 
 */
public class UserOperation implements UserInterface{

	private final UserDaoOperation userDao = UserDaoOperation.getInstance();

	/**
	 * Method to update Password of user
	 * @param userID
	 * @param password
	 */
	@Override
	public void updatePassword(String userID, String password) {

		userDao.updatePassword(userID, password);
	}

	/**
	 * Method to Update Contact Number of user
	 * @param userID
	 * @param number
	 */
	@Override
	public void updateContactNumber(String userID, String number) {

		userDao.updateContactNumber(userID, number);
	}

	/**
	 * Method to update Role of user
	 * @param userID
	 * @param role
	 */
	@Override
	public void updateRole(String userID, String role) {
		// TODO Auto-generated method stub
		
	}

	
	public String getRole(String userID) {

		return userDao.getUserRole(userID);
	}

	/**
	 * Method to verify user credentials
	 * @param userID
	 * @param password
	 * @return indicating if user exists in the database
	 */
	@Override
	public boolean loginUser(String userID, String password, String role) throws UserNotFoundException {
		
		return userDao.loginUser(userID, password, role);
	}

}
