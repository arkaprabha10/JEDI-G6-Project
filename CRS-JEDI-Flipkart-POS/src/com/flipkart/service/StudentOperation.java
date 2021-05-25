package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyInUseException;

public class StudentOperation implements StudentInterface {
	
	
	@Override
	public ReportCard viewReportCard(int StudentID, int semesterId) throws GradeNotAddedException, StudentNotApproved {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredCourses> viewRegisteredCourses(int studentID, int semesterId)
			throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		return null;
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
	
}
