/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;

/**
 * @author rutwi
 *
 */
public interface StudentInterface {
	
	/**
	 * @param StudentID
	 * @param reportCard
	 */
	public void viewReportCard(int StudentID, ReportCard reportCard);
	
	/**
	 * @param studentID
	 * @param catalog
	 */
	public void viewRegisteredCourses(int studentID, ArrayList<Course> catalog);

}
