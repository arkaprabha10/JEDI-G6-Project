/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author rutwi
 *
 */
public interface StudentInterface {
	
	/**
	 * @param StudentID
	 * @param reportCard
	 */
	public void viewReportCard(int StudentID, ReportCard reportCard) throws GradeNotAddedException, StudentNotApproved;
	
	/**
	 * @param studentID
	 * @param catalog
	 */
	public void viewRegisteredCourses(int studentID, ArrayList<Course> catalog) throws StudentNotRegisteredException;

}
