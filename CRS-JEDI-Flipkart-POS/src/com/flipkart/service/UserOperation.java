package com.flipkart.service;

import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface{
	
	UserDaoOperation udo = new UserDaoOperation();

	@Override
	public void updatePassword(String userID, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContactNumber(String userID, String number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRole(String UserID, String role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loginUser(String userID, String password, String role) throws UserNotFoundException {
		
		if(udo.loginUser(userID, password, role)) return true;
		else return false;
	}

}
