/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.exception.*;

/**
 * @author rutwi
 *
 */
public interface UserDaoInterface {
	
	/**
	 * @param userID
	 * @param password
	 */
	public void updatePassword(String userID, String password) throws SQLException; 
	
	/**
	 * @param userID
	 * @param number
	 */
	public void updateContactNumber(String userID, String number) throws SQLException;
	
	/**
	 * @param UserID
	 * @param role
	 */
	public void updateRole(String userID, String role) throws SQLException;
	
	/**
	 * @param userID
	 * @param password
	 * @return
	 */
	public boolean loginUser(String userID, String password) throws SQLException;
	

}
