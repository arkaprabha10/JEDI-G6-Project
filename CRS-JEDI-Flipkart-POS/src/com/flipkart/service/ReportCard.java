/**
 * 
 */
package com.flipkart.service;

import java.util.HashMap;

import com.flipkart.bean.RegisteredCourses;

/**
 * @author Asus
 *
 */
public interface ReportCard {
	/**
	 * Method to add student's Grade (by Professor) 
	 * @param studentId
	 * @param semesterId
	 * @param grade 
	 * @param courseId
	 * @return updated report card
	 */
	public ReportCard addGrade(int studentId, int semesterId, int courseId, int grade) ;
	
	/**
	 * Method to get student's SPI
	 * @param studentId
	 * @param semesterId
	 * @return spi for that semester and student
	 */
	public Float getSPI(int studentId, int semesterId);
	
	/**
	 * Method to get student's grades
	 * @param studentId
	 * @param semesterId
	 * @return student's grades for that semester 
	 */
	public HashMap<String, Integer> viewGrades(int studentId, int semesterId);
	
	/**
	 * Method to get student's grades for a course
	 * @param studentId
	 * @param semesterId
	 * @param courseId
	 * @return student's grades for that course 
	 */
	public HashMap<String, Integer> viewCourseGrade(int studentId, int semesterId, int courseId);
	
	
	/**
	 * Method to make report card visible to the student
	 * @param studentId
	 * @param semesterId
	 * @return Boolean to indicate if operation is successful 
	 * //(e.g. check if all grades marked)
	 */
	public Boolean makeVisible(int studentId, int semesterId);
	
	
}
