/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
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
	
	AdminDaoOperation ado = new AdminDaoOperation();

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) throws FeesPendingException, StudentNotApprovedException {
		
		AdminDaoOperation ado = new AdminDaoOperation();
		ado.approveStudentRegistration(studentId,semesterId);
		
	}

	@Override
	public void addProfessor(Professor professor) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProfessor(int professorID) {
		// TODO Auto-generated method stub
		ado.removeCourse(professorID);
		
	}

	@Override
	public void generateReportCard(int studentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourse(int courseID) {
		// TODO Auto-generated method stub
		ado.removeCourse(courseID);
		
	}

	@Override
	public void addCourse(String course_name, String courseID, int semester) {
		// TODO Auto-generated method stub
		Course newCourse = new Course();
		newCourse.setCoursename(course_name);
		newCourse.setCourseID(courseID);
		newCourse.setOfferedSemester(semester);
		newCourse.setAvailableSeats(10);
		
		ado.addCourse(newCourse);
		
	}

	
	@Override
	public HashMap<String,ArrayList<Integer> > viewCourseStudentList(String courseID, int semester, Boolean viewAll) {
		
		AdminDaoOperation ado = new AdminDaoOperation();
		return ado.viewCourseStudentList(courseID,semester,viewAll);
	}


}
