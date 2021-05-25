/**
 * 
 */
package com.flipkart.service;


/**
 * @author rutwi
 *
 */
public interface UserInterface {
	
	public void updatePassword(String userID, String password);
	
	public void updateContactNumber(String userID, String number);
	
	public void updateRole(String UserID, String role);
	

}
