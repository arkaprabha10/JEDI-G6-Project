/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyPresentException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author rutwi
 * Interface for Admin Dao Operations
 *
 */
public interface AdminDaoInterface {
	
	/**
	 * Method to approveStudent Registration using SQL commands
	 * @param students
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */
	public void approveStudentRegistration(int studentId,int semesterId) throws SQLException, FeesPendingException, StudentNotApprovedException;	
	
	/**
	 * Method to add Professor using SQL commands
	 * @param professor
	 */
	public void addProfessor(Professor professor) throws SQLException;
	
	/**
	 * Method to remove Professor using SQL commands
	 * @param professor
	 */
	public void removeProfessor(int professorID) throws SQLException;
	
	/**
	 * Method to Generate ReportCard using SQL commands
	 * @param studentID
	 * @return 
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 * @throws GradeNotAddedException 
	 */
	public ReportCard generateReportCard(int studentID) throws SQLException, StudentNotApprovedException, GradeNotAddedException, FeesPendingException;
	
	/**
	 * Method to remove course using SQL commands
	 * @param courseID
	 * @param courseCatalog
	 */
	public void removeCourse(String courseID) throws SQLException;
	
	/**
	 * Method to remove course using SQL commands
	 * @param courseID
	 * @param courseCatalog
	 */
	public void addCourse(Course course) throws SQLException;
	
	/**
	 * Method to add Course using SQL commands
	 * @param courseID
	 * @param semesterId
	 * @param viewAll
	 * @return
	 */
	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semesterId, Boolean viewAll);
	
	/**
	 * Method to Fetch Students yet to approved using SQL commands
	 * @return list of student yet to approved
	 */
	public List<Student> getPendingStudentAccountsList();
	
	/**
	 * Method to Approve Student using SQL commands
	 * @param studentId
	 */
	public void approveStudentAccount(int studentId);

}
