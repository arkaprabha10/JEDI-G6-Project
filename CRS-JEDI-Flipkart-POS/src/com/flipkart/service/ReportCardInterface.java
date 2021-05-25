/**
 * 
 */
package com.flipkart.service;

import java.util.HashMap;

import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.CourseNotAssignedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.ReportCardNotFoundException;
import com.flipkart.exception.StudentNotApproval;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author Asus
 *
 */
public interface ReportCardInterface {
	/**
	 * Method to add student's Grade (by Professor) 
	 * @param studentId
	 * @param semesterId
	 * @param grade 
	 * @param courseId
	 * @return updated report card
	 */
	public ReportCardInterface addGrade(int studentId, int semesterId, int courseId, int grade) throws CourseNotFoundException;
	
	/**
	 * Method to get student's SPI
	 * @param studentId
	 * @param semesterId
	 * @return spi for that semester and student
	 */
	public Float getSPI(int studentId, int semesterId) throws StudentNotRegisteredException, ReportCardNotFoundException;
	
	/**
	 * Method to get student's grades
	 * @param studentId
	 * @param semesterId
	 * @return student's grades for that semester 
	 */
	public HashMap<String, Integer> viewGrades(int studentId, int semesterId) throws StudentNotRegisteredException, ReportCardNotFoundException;
	
	/**
	 * Method to get student's grades for a course
	 * @param studentId
	 * @param semesterId
	 * @param courseId
	 * @return student's grades for that course 
	 */
	public HashMap<String, Integer> viewCourseGrade(int studentId, int semesterId, int courseId) throws StudentNotRegisteredException, ReportCardNotFoundException, CourseNotFoundException, CourseNotAssignedException;
	
	
	/**
	 * Method to make report card visible to the student
	 * @param studentId
	 * @param semesterId
	 * @return Boolean to indicate if operation is successful 
	 * //(e.g. check if all grades marked)
	 */
	public Boolean makeVisible(int studentId, int semesterId) throws GradeNotAddedException, FeesPendingException;
	
	
}
