/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Professor extends User{

	private String instructorID;
	private String department;
	private String designation;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	
		instructorID = "1";
		department = "Default";
		designation = "Default";
	}
	
	
	/**
	 * @param instructorID
	 * @param department
	 * @param designation
	 */
	public Professor(String instructorID, String department, String designation) {
		super();
		this.instructorID = instructorID;
		this.department = department;
		this.designation = designation;
	}


	/**
	 * @return the instructorID
	 */
	public String getInstructorID() {
		return instructorID;
	}


	/**
	 * @param instructorID the instructorID to set
	 */
	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}


	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}


	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
