package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * 
 * @author Jayanth
 * Class to implement User Dao Operations
 *
 */

public class UserDaoOperation implements UserDaoInterface{
	private static volatile UserDaoOperation instance=null;
	private static final Connection conn = DBUtil.getConnection();
	private static final String[] roleList = {"professor", "student", "admin"};
	private String userRole;

	private UserDaoOperation(){

	}
	public static UserDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(UserDaoOperation.class){
				instance=new UserDaoOperation();
			}
		}
		return instance;
	}

	
	public static void main(String[] args) throws SQLException {
		UserDaoInterface test = new UserDaoOperation();

		test.updatePassword("aaa", "aaa");
		test.updateContactNumber("aaa", "999");
		//System.out.println(test.loginUser("aaa", "bbb"));
	}


	/**
	 * Method to update Password in database
	 * @param userID
	 * @param password
	 */
	@Override
	public void updatePassword(String userID, String newPassword) {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating password...");

			if(userRole == null) {
				assignUserRole(userID);
			}

			String query = "UPDATE " + userRole + " SET password = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newPassword);
			queryStatement.setString(2, userID);
			queryStatement.executeUpdate();


		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method to get Role of User from DataBase
	 * @param userID
	 * @return Role
	 * @throws UserNotFoundException
	 */
	@Override
	public String getUserRole(String userID) {

		try {
			if(userRole == null) {
				assignUserRole(userID);
			}
		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}

		return userRole;
	}

	/**
	 * Method to assign Role of User from DataBase
	 * @param userID
	 * @return Role
	 * @throws UserNotFoundException
	 */
	private void assignUserRole(String userID) throws UserNotFoundException{

		PreparedStatement stmt;

		try {

			for(String role : roleList) {

				String query = "SELECT COUNT(1) FROM " + role + " WHERE user_name = ?";

				stmt = conn.prepareStatement(query);
				stmt.setString(1, userID);
				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					if(rs.getInt("COUNT(1)") == 1) {
						userRole = role;
						break;
					}
				}

				if(userRole != null) break;
			}

			if(userRole == null) {
				throw new UserNotFoundException();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method to update Contact Number in database
	 * @param userID
	 */
	@Override
	public void updateContactNumber(String userID, String newNumber) {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating contact number...");

			if(userRole == null) {
				assignUserRole(userID);
			}

			String query = "UPDATE " + userRole + " SET contact_number = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newNumber);
			queryStatement.setString(2, userID);
			queryStatement.executeUpdate();


		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	
	@Override
	public void updateRole(String userID, String role) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userID
	 * @param password
	 * @return Verify credentials operation status
	 */
	@Override
	public boolean loginUser(String userID, String userPassword, String role) {

		PreparedStatement queryStatement;

		try {
			System.out.println("Logging in...");
			
			
			
//			if(role.equals("student"))
//			{
//				String query1 = "SELECT account_approved " + "FROM student WHERE user_name = ?";
//				queryStatement = conn.prepareStatement(query1);
//				queryStatement.setString(1, userID);
//				ResultSet rs = queryStatement.executeQuery();
//				
//				Boolean account_status = false;
//				while (rs.next()) {
//					account_status = rs.getBoolean("account_approved");
//				}
//				
//				if(!account_status)
//				{
//					throw new Exception("Account not approved by admin");
//					// TODO: make this exception class
//				}
//			})



			String query = "SELECT password " + "FROM " + role + " WHERE user_name = ?";


			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, userID);
			ResultSet rs = queryStatement.executeQuery();

			String password = null;
			while (rs.next()) {
				password = rs.getString("password");
			}

			if(password == null) {
				throw new UserNotFoundException();
			}

			if(Objects.requireNonNull(password).equals(userPassword)) {
				
				if(role.equals("student"))
				{
					String query1 = "SELECT account_approved FROM student WHERE user_name = ?";
					queryStatement = conn.prepareStatement(query1);
					queryStatement.setString(1, userID);
					ResultSet rs1 = queryStatement.executeQuery();
					
					Boolean account_status = false;
					if(rs1.next())
					{
						account_status = rs1.getBoolean("account_approved");
						
					}
					
					if(!account_status)
					{
						throw new Exception("Account Not Approved By Admin");
						// TODO: ma
					}
					
				}
				return true;
			}


		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		// throw exception on login failure
		return false;
	}

}
