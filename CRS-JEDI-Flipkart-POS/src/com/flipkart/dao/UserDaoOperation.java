package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoOperation implements UserDaoInterface{

	private static Connection conn = DBUtil.getConnection();
	private static final String[] roleList = {"Professor", "Student", "Admin"};
	private String userRole;

	public static void main(String[] args) throws SQLException {
		UserDaoInterface test = new UserDaoOperation();

		test.updatePassword("aaa", "aaa");
		test.updateContactNumber("aaa", "999");
		System.out.println(test.loginUser("aaa", "bbb"));
	}



	@Override
	public void updatePassword(String userName, String newPassword) {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating password...");

			getUserRole(userName);

			String query = "UPDATE " + userRole + " SET password = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newPassword);
			queryStatement.setString(2, userName);
			queryStatement.executeUpdate();


		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void getUserRole(String userName) throws UserNotFoundException{

		PreparedStatement stmt;

		try {

			for(String role : roleList) {

				String query = "SELECT COUNT(1) FROM " + role + " WHERE user_name = ?";

				stmt = conn.prepareStatement(query);
				stmt.setString(1, userName);
				ResultSet rs = stmt.executeQuery();

				rs.next();

				if(rs.getInt("COUNT(1)") == 1) {
					userRole = role;
					break;
				}
			}

			if(userRole == null) {
				throw new UserNotFoundException();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateContactNumber(String userName, String newNumber) {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating contact number...");

			getUserRole(userName);

			String query = "UPDATE " + userRole + " SET contact_number = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newNumber);
			queryStatement.setString(2, userName);
			queryStatement.executeUpdate();


		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateRole(String UserID, String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean loginUser(String userName, String userPassword) {

		PreparedStatement queryStatement;

		try {
			System.out.println("Logging in...");

			getUserRole(userName);

			String query = "SELECT password " + "FROM " + userRole;

			queryStatement = conn.prepareStatement(query);
			ResultSet rs = queryStatement.executeQuery();

			rs.next();
			String password = rs.getString("password");

			if(password.equals(userPassword)) {
				return true;
			}


		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}

		// throw exception on login failure
		return false;
	}

}
