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
 *
 */
public interface AdminDaoInterface {
	
	/**
	 * @param students
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */
	public void approveStudentRegistration(int studentId,int semesterId) throws SQLException, FeesPendingException, StudentNotApprovedException;	
	/**
	 * @param professor
	 */
	public void addProfessor(Professor professor) throws SQLException;
	
	/**
	 * @param professor
	 */
	public void removeProfessor(int professorID) throws SQLException;
	
	/**
	 * @param studentID
	 * @return 
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 * @throws GradeNotAddedException 
	 */
	public ReportCard generateReportCard(int studentID) throws SQLException, StudentNotApprovedException, GradeNotAddedException, FeesPendingException;
	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */
	public void removeCourse(int courseID) throws SQLException;
	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */
	public void addCourse(Course course) throws SQLException;
	
	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semesterId, Boolean viewAll);
	
	public List<Student> getPendingStudentAccountsList();
	
	public void approveStudentAccount(int studentId);

}
