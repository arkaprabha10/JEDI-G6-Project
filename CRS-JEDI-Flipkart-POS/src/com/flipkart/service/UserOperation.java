package com.flipkart.service;

import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface{

	private final UserDaoOperation userDao = UserDaoOperation.getInstance();

	@Override
	public void updatePassword(String userID, String password) {

		userDao.updatePassword(userID, password);
	}

	@Override
	public void updateContactNumber(String userID, String number) {

		userDao.updateContactNumber(userID, number);
	}

	@Override
	public void updateRole(String userID, String role) {
		// TODO Auto-generated method stub
		
	}

	public String getRole(String userID) {

		return userDao.getUserRole(userID);
	}

	@Override

	public boolean loginUser(String userID, String password, String role) throws UserNotFoundException {
		
		return userDao.loginUser(userID, password, role);
	}

}
