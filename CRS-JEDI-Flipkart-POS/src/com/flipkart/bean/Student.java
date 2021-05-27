/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 * Student class
 */
public class Student extends User{
	private Integer studentID;
	private String department;
	
	/**
	 * Default Constructor
	 * @param studentID
	 * @param department
	 */
	public Student() {
	studentID = 0;
	department = "Default";
	}
	
	/**
	 * Parameterized Constructor
	 * @param studentID
	 * @param department
	 */
	public Student(Integer studentID, String department) {
		super();
		this.studentID = studentID;
		this.department = department;
	}

	/**
	 * @return the studentID
	 */
	public Integer getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
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

}
