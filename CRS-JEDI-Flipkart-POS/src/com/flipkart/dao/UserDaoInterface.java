package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

import java.sql.SQLException;

/**
 * @author rutwi
 * Interface for User Dao Operations
 *
 */
public interface UserDaoInterface {
	
	/**
	 * Method to update Password in database
	 * @param userID
	 * @param password
	 */
	public void updatePassword(String userID, String password);

	/**
	 * Method to get Role of User from DataBase
	 * @param userID
	 * @return Role
	 * @throws UserNotFoundException
	 */
	public String getUserRole(String userID) throws UserNotFoundException;

	/**
	 * Method to update Contact Number in database
	 * @param userID
	 */
	public void updateContactNumber(String userID, String number);
	
	/**
	 * Method to update Role in database
	 * @param userID
	 * @param role
	 */
	public void updateRole(String userID, String role);
	
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userID
	 * @param password
	 * @return Verify credentials operation status
	 */
	public boolean loginUser(String userID, String password, String role) throws SQLException;
}
