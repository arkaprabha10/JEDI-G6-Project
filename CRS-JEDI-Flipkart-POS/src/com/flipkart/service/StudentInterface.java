/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyInUseException;

/**
 * @author rutwi
 *
 */
public interface StudentInterface {
	
	/**
	 * @param StudentID
	 * @param reportCard
	 * @throws UserAlreadyInUseException 
	 */

	public Student addStudent (String userName, String name, String password,String department, String contactNumber, Integer joiningYear) throws UserAlreadyInUseException, SQLException, UserAlreadyInUseException;
	
	
	/**
	 * @param StudentID
	 * @param semesterId
	 * @return reportCard
	 * @throws StudentNotApprovedException 
	 * @throws SQLException 
	 */
	public ReportCard viewReportCard(int StudentID, int semesterId) throws GradeNotAddedException, StudentNotApproved,FeesPendingException, SQLException, StudentNotApprovedException;
	
	/**
	 * @param studentID
	 * @param semesterId
	 * @return course list
	 * @throws SQLException 
	 */
	public List<Course> viewRegisteredCourses(int studentID, int semesterId) throws StudentNotRegisteredException, SQLException;
	
	

}