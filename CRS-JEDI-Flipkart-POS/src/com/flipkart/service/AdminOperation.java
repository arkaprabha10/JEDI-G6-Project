/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.client.AdminClient;

/**
 * @author rutwi
 *
 */
public class AdminOperation implements AdminInterface {
	
	
	@Override
	public void approveStudentRegistration(ArrayList<Student> students) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor) {
		
		
	}

	@Override
	public void removeProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateReportCard(int studentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourse(int courseID, ArrayList<Course> courseCatalog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(int courseID, ArrayList<Course> courseCatalog) {
		// TODO Auto-generated method stub
		
	}

}
