/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author rutwi
 *
 */
public interface AdminInterface {
	
	/**
	 * @param students
	 */
	public void approveStudentRegistration(ArrayList<Student> students);
	
	/**
	 * @param professor
	 */
	public void addProfessorDetails(Professor professor);
	
	/**
	 * @param studentID
	 */
	public void generateReportCard(int studentID);
	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */
	public void removeCourse(int courseID, ArrayList<Course> courseCatalog);
	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */
	public void addCourse(int courseID, ArrayList<Course> courseCatalog);

}
