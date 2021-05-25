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
	
	public void approveStudentRegistration(ArrayList<Student> students);
	public void addProfessorDetails(Professor professor);
	public void generateReportCard();
	public void removeCourse(int courseID, ArrayList<Course> courseCatalog);
	public void addCourse(int courseID, ArrayList<Course> courseCatalog);

}
