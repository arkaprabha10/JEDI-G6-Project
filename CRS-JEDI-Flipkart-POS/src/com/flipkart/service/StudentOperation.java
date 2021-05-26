package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyInUseException;

public class StudentOperation implements StudentInterface {

	@Override
	public ReportCard viewReportCard(int StudentID, int semesterId) throws GradeNotAddedException, StudentNotApproved, FeesPendingException, SQLException, StudentNotApprovedException  {

		ReportCard R = new ReportCard();
		StudentDaoOperation SDO= new StudentDaoOperation();
		R= SDO.viewReportCard(StudentID,semesterId);
		ReportCardOperation report = new ReportCardOperation();
		R.setSpi(report.getSPI(R));
		return R;
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentID, int semesterId)
			throws StudentNotRegisteredException, SQLException {
		
		StudentDaoOperation SDO= new StudentDaoOperation();
		
		return SDO.viewRegisteredCourses(studentID,semesterId);	
		
		
	}

	@Override
	public Student addStudent(String userName, String name, String password,String department ,String contactNumber, Integer joiningYear)
			throws UserAlreadyInUseException, SQLException {
		Student newStudent = new Student();
		newStudent.setUserID(userName);
		newStudent.setName(name);
		newStudent.setPassword(password);
		newStudent.setDepartment(department);
		newStudent.setContactNumber(contactNumber);
		newStudent.setJoiningYear(joiningYear);
//		System.out.println("Student Made"+newStudent.getName());
		StudentDaoOperation sdo=new StudentDaoOperation();
		sdo.addStudent(newStudent);
		return newStudent;
	}
//	public static void main(String[] args) throws UserAlreadyInUseException, SQLException, StudentNotRegisteredException, GradeNotAddedException, StudentNotApproved, FeesPendingException, StudentNotApprovedException {
//		System.out.println("Hey There!");
//		StudentOperation so = new StudentOperation();
//		
//			so.addStudent("Anon", "Gurseerat", "derf","EE", "1234554321", 2020);
//			List<Course> l=so.viewRegisteredCourses(1, 1);
//			for (Course el: l ) {
//				System.out.println(el.getCourseID());
//			}
//			so.viewReportCard(1, 1);
//	}
	
}
