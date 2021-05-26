/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author rutwi
 *
 */

public class AdminOperation implements AdminInterface {
	
//	AdminDaoOperation ado = new AdminDaoOperation();
	AdminDaoInterface ado = AdminDaoOperation.getInstance();
	private static volatile AdminOperation instance = null;
	
	private AdminOperation()
	{
		
	}
	
	/**
	 * Method to make AdminOperation Singleton
	 */
	public static AdminOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminOperation.class){
				instance = new AdminOperation();
			}
		}
		return instance;
	}
	
	

	@Override
	public void approveStudentRegistration(ArrayList<Student> students) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProfessor(int professorID) {
		// TODO Auto-generated method stub
		try {
			ado.removeCourse(professorID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void generateReportCard(int studentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourse(int courseID) {
		// TODO Auto-generated method stub
		try {
			ado.removeCourse(courseID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addCourse(String course_name, String courseID, int semester) {
		// TODO Auto-generated method stub
		Course newCourse = new Course();
		newCourse.setCoursename(course_name);
		newCourse.setCourseID(courseID);
		newCourse.setOfferedSemester(semester);
		newCourse.setAvailableSeats(10);
		
		try {
			ado.addCourse(newCourse);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
