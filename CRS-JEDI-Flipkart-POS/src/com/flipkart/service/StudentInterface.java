/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
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
	 * @return Student
	 */
	public Student addStudent (String userName, String name, String password,String department, String contactNumber, Integer joiningYear) throws UserAlreadyInUseException, SQLException;
	
	
	/**
	 * @param StudentID
	 * @param semesterId
	 * @return reportCard
	 */
	public ReportCard viewReportCard(int StudentID, int semesterId) throws GradeNotAddedException, StudentNotApproved;
	
	/**
	 * @param studentID
	 * @param semesterId
	 * @return course list
	 */
	public List<RegisteredCourses> viewRegisteredCourses(int studentID, int semesterId) throws StudentNotRegisteredException;
	
	

}
