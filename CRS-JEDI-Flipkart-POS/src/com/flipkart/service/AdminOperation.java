/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	AdminDaoOperation ado = new AdminDaoOperation();

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) throws FeesPendingException, StudentNotApprovedException {
		
		AdminDaoOperation ado1 = new AdminDaoOperation();
		ado1.approveStudentRegistration(studentId,semesterId);
		
	}

	@Override
	public void addProfessor(Professor professor) {
		
		ado.addProfessor(professor);
		
	}

	@Override
	public void removeProfessor(int professorID) {
		// TODO Auto-generated method stub
		ado.removeProfessor(professorID);
		
	}

	@Override
	public ReportCard generateReportCard(int studentID) throws StudentNotApprovedException, GradeNotAddedException, FeesPendingException {
		// TODO Auto-generated method stub
		return ado.generateReportCard(studentID);
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
		
		AdminDaoOperation ado1 = new AdminDaoOperation();
		return ado1.viewCourseStudentList(courseID,semester,viewAll);
	}

	
	@Override
	public List<Student> getPendingStudentAccountsList() {

		return ado.getPendingStudentAccountsList();
		
	}

	@Override
	public void approveStudentAccount(Integer studentID) {
		ado.approveStudentAccount(studentID);
		
	}


}
