/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dell
 *
 */
public class ReportCard {
	HashMap<String, Integer> grades =new HashMap<String, Integer>();
	private Float spi;
	private Integer studentID;
	private Integer semesterID;
	private Boolean isVisible;
	
	/**
	 * Default Constructor
	 */
	public ReportCard() {
		// TODO Auto-generated constructor stub
		spi = (float) 10.0;
		studentID = 0;
		semesterID = 1;
		isVisible = false;
	}
	
	/**
	 * Parameterized Constructor
	 * @param grades
	 * @param spi
	 * @param studentID
	 * @param semesterID
	 * @param isVisible
	 */
	public ReportCard(HashMap<String, Integer> grades, Float spi, Integer studentID, Integer semesterID,
			Boolean isVisible) {
		super();
		this.grades = grades;
		this.spi = spi;
		this.studentID = studentID;
		this.semesterID = semesterID;
		this.isVisible = isVisible;
	}

	/**
	 * Method to get Grades for all courses
	 * @return the grades
	 */
	public HashMap<String, Integer> getGrades() {
		return grades;
	}

	/**
	 * Method to set Grades
	 * @param grades the grades to set
	 */
	public void setGrades(HashMap<String, Integer> grades) {
		this.grades = grades;
	}

	/**
	 * Method to get SPI
	 * @return the spi
	 */
	public Float getSpi() {
		return spi;
	}

	/**
	 * Method to setSpi
	 * @param spi the spi to set
	 */
	public void setSpi(Float spi) {
		this.spi = spi;
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
	 * Method to get semesterID
	 * @return the semesterID
	 */
	public Integer getSemesterID() {
		return semesterID;
	}

	/**
	 * Method to set SemesterID
	 * @param semesterID 
	 */
	public void setSemesterID(Integer semesterID) {
		this.semesterID = semesterID;
	}

	/**
	 * Method to set Visibility
	 * @return true if visible else false
	 */
	public Boolean getIsVisible() {
		return isVisible;
	}

	/**
	 * Method to set visibility 
	 * @param isVisible the isVisible to set
	 */
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	} 
	
	

}
