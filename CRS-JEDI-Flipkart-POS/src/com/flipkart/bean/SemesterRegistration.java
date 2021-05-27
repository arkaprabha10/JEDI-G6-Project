/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 * SemesterRegistration Class
 *
 */
public class SemesterRegistration {
	private Integer studentID;
	private Integer semesterID;
	private String dateOfRegistration;
	private Boolean isApproved;
	
	/**
	 * Default Constructor
	 */
	public SemesterRegistration() {
		// TODO Auto-generated constructor stub
		studentID = 0;
		semesterID = 1;
		dateOfRegistration = "1/1/2021";
	}
	
	/**
	 * Parameterized constructor
	 * @param studentID
	 * @param semesterID
	 * @param dateOfRegistration
	 * @param isApproved
	 */
	public SemesterRegistration(Integer studentID, Integer semesterID, String dateOfRegistration, Boolean isApproved) {
		super();
		this.studentID = studentID;
		this.semesterID = semesterID;
		this.dateOfRegistration = dateOfRegistration;
		this.isApproved = isApproved;
	}

	/**
	 * Method to get studentID
	 * @return the studentID
	 */
	public Integer getStudentID() {
		return studentID;
	}

	/**
	 * Method to set StudentID
	 * @param studentID the studentID to set
	 */
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	/**
	 * Method to get SemesterID
	 * @return the semesterID
	 */
	public Integer getSemesterID() {
		return semesterID;
	}

	/**
	 * Method to set SemesterID
	 * @param semesterID the semesterID to set
	 */
	public void setSemesterID(Integer semesterID) {
		this.semesterID = semesterID;
	}

	/**
	 * Method to get Date of Registration
	 * @return the dateOfRegistration
	 */
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	/**
	 * Method to set Date of Registration
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	/**
	 * Method to know Approved or not
	 * @return true if Approved else false
	 */
	public Boolean getIsApproved() {
		return isApproved;
	}

	/**
	 * Method to set Approved or not
	 * @param isApproved the isApproved to set
	 */
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
