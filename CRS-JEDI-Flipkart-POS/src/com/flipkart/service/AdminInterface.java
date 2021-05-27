/**
 * 
 */
package com.flipkart.service;

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
 * 
 * @author rutwi
 * Interface for Admin Operations
 * 
 */
public interface AdminInterface {
	
	/**
	 * Method to Approve Student Registration
	 * @param students
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	public void approveStudentRegistration(int studentId,int semesterId) throws StudentNotRegisteredException, StudentNotRegisteredException, FeesPendingException, StudentNotApprovedException;
	
	/**
	 * Method to add Professor
	 * @param professor
	 * @throws ProfessorNotAddedException
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException;
	
	/**
	 * Method to removeProfessor
	 * @param professor
	 */
	public void removeProfessor(int professorID);
	
	/**
	 * Method to return ReportCard
	 * @param studentID
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	public ReportCard generateReportCard(int studentID) throws GradeNotAddedException, StudentNotApprovedException, FeesPendingException;
	
	/**
	 * Method to RemoveCourse
	 * @param courseID
	 * @param courseCatalog
	 */
	public void removeCourse(String courseID) throws CourseNotFoundException, CourseNotDeletedException;
	
	/**
	 * Method to Add Course
	 * @param courseID
	 * @param courseCatalog
	 * @throws CourseAlreadyPresentException
	 */
	public void addCourse(String course_name, String courseID, int semester) throws CourseAlreadyPresentException;

	/**
	 * Method to get Students list registered a course/ all courses
	 * @param courseID
	 * @param semester
	 * @param viewAll : Option to view all Registered courses
	 * @return Student List registered for specified course or all courses depending on Viewall
	 */
	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semester, Boolean viewAll);

	/**
	 *Method to return get all Pending Student Account list
	 * @return  
	 */
	public List<Student> getPendingStudentAccountsList();
	
	/**
	 * Method to Approve Student Account
	 * @param studentID
	 */
	public void approveStudentAccount(Integer studentID);
}
