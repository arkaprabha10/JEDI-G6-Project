/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;

/**
 * @author Dell
 *
 */
public class RegisteredCourses {
	private Integer studentID;
	private Integer semesterID;
	private ArrayList<String> courseID = new ArrayList<String>();
	
	/**
	 * Default Constructor
	 */
	public RegisteredCourses() {
		// TODO Auto-generated constructor stub
		studentID = 0;
		semesterID = 1;
	}
	
	/**
	 * Parameterized constructor
	 * @param studentID
	 * @param semesterID
	 * @param courseID
	 */
	public RegisteredCourses(Integer studentID, Integer semesterID, ArrayList<String> courseID) {
		super();
		this.studentID = studentID;
		this.semesterID = semesterID;
		this.courseID = courseID;
	}
	
	/**
	 * Method to get StudentID
	 * @return the studentID
	 */
	public Integer getStudentID() {
		return studentID;
	}
	
	/**
	 * Method to set StudentID
	 * @param studentID 
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
	 * Method to get CourseID
	 * @return the courseID
	 */
	public ArrayList<String> getCourseID() {
		return courseID;
	}
	
	/**
	 * Method to set CourseID
	 * @param courseID the courseID to set
	 */
	public void setCourseID(ArrayList<String> courseID) {
		this.courseID = courseID;
	}
	
}
