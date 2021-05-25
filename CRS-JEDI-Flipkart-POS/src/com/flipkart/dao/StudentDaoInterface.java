/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
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
public interface StudentDaoInterface {
	/**
	 * @param StudentID
	 * @param reportCard
	 * @return Student
	 */
	public Student addStudent (Student student) throws SQLException, UserAlreadyInUseException;
	
	
	/**
	 * @param StudentID
	 * @param semesterId
	 * @return reportCard
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */
	public ReportCard viewReportCard(int StudentID, int semesterId) throws SQLException, GradeNotAddedException, StudentNotApprovedException, FeesPendingException;
	
	/**
	 * @param studentID
	 * @param semesterId
	 * @return course list
	 */
	public List<Course> viewRegisteredCourses(int studentID, int semesterId) throws SQLException, StudentNotRegisteredException;
	
	
}
