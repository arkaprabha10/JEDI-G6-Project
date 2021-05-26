/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentCourseNotFoundException;
//import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author rutwi
 *
 */
public interface StudentDaoInterface {
	
	/**
	 * @param StudentID

	 * @param semesterId
	 * @return reportCard
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */
	public ReportCard viewReportCard(Integer StudentID, Integer semesterId) throws SQLException, GradeNotAddedException, StudentNotApprovedException, FeesPendingException;
/*
	/**
	 * @param studentID
	 * @param catalog
	 */

	public List<Course> viewRegisteredCourses(Integer studentID, Integer semesterId) throws SQLException, StudentCourseNotFoundException;
	public Student addStudent(Student student) throws SQLException;
	
	public int getStudentIDFromUserName(String username) throws StudentNotRegisteredException,SQLException;
	
}
