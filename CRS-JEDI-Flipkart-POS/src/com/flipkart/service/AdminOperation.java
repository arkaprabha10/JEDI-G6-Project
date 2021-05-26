/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.UserAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;

/**
 * @author rutwi
 *
 */

public class AdminOperation implements AdminInterface {
	
//	AdminDaoOperation ado = new AdminDaoOperation();
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
	

	AdminDaoInterface ado  =AdminDaoOperation.getInstance();

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) throws FeesPendingException, StudentNotApprovedException {
		
//		AdminDaoOperation ado1 = new AdminDaoOperation();
		try {
			ado.approveStudentRegistration(studentId,semesterId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeesPendingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StudentNotApprovedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProfessor(Professor professor) {
		
		try {
			ado.addProfessor(professor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeProfessor(int professorID) {
		// TODO Auto-generated method stub
		try {
			ado.removeProfessor(professorID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	
	@Override
	public HashMap<String,ArrayList<Integer> > viewCourseStudentList(String courseID, int semester, Boolean viewAll) {
		
//		AdminDaoOperation ado1 = new AdminDaoOperation();
		return ado.viewCourseStudentList(courseID,semester,viewAll);
	}

	@Override
	public ReportCard generateReportCard(int studentID)
			throws GradeNotAddedException, StudentNotApprovedException, FeesPendingException {
		// TODO Auto-generated method stub
		return null;
	}


}
