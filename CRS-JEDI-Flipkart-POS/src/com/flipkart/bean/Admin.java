/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Admin extends User {
	private String dateOfJoining;

	/**
	 * Default Constructor
	 */
	public Admin() {
		// TODO Auto-generated constructor stub
		this.dateOfJoining="01-01-2001";//default value of DOJ
	}


	public Admin(String dateOfJoining) {
		super();
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Method to get Date of Joining
	 * @return Date of joining
	 */
	public String getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Method to set Date of joining
	 * @param dateOfJoining
	 */
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
}
