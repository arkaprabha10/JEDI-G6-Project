/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class User {

	private Integer userID;
	private String name;
	private String role;
	private String password;
	private String contactNumber;
	private Integer joiningYear;
	
	
	/**
	 * @return the userID
	 */
	public Integer getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the joiningYear
	 */
	public Integer getJoiningYear() {
		return joiningYear;
	}

	/**
	 * @param joiningYear the joiningYear to set
	 */
	public void setJoiningYear(Integer joiningYear) {
		this.joiningYear = joiningYear;
	}
	
		
	public User() {
		userID = 0;
		name = "Default";
		role = "Student";
		password = "";
		contactNumber = "0000000000";
		joiningYear = 2021;
		}
			
			// TODO Auto-generated constructor stub
	
	public User(Integer userID, String name, String role, String password, String contactNumber, Integer joiningYear) {
		super();
		this.userID = userID;
		this.name = name;
		this.role = role;
		this.password = password;
		this.contactNumber = contactNumber;
		this.joiningYear = joiningYear;
	}
	
	/**
	 * @param userID
	 * @param name
	 * @param role
	 * @param password
	 * @param contactNumber
	 * @param joiningYear
	 */

}
