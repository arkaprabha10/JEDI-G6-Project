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
import com.flipkart.exception.StudentCourseNotFoundException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;

public class StudentOperation implements StudentInterface {

	@Override
	public ReportCard viewReportCard(Integer StudentID, Integer semesterId)   {

		ReportCard R = new ReportCard();
		StudentDaoOperation SDO= new StudentDaoOperation();
		try {
			R = SDO.viewReportCard(StudentID,semesterId);
		} catch (SQLException | GradeNotAddedException | StudentNotApprovedException | FeesPendingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		ReportCardOperation report = new ReportCardOperation();
		R.setSpi(report.getSPI(R));
		return R;
	}

	@Override
	public List<Course> viewRegisteredCourses(Integer studentID, Integer semesterId)
			 {
		
		StudentDaoOperation SDO= new StudentDaoOperation();
		List<Course> ans= new ArrayList<Course>();
		try {
			ans = SDO.viewRegisteredCourses(studentID,semesterId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (StudentCourseNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		return ans;
		
	}

	@Override
	public Student addStudent(String userName, String name, String password,String department ,String contactNumber, Integer joiningYear)
			  {
		Student newStudent = new Student();
		newStudent.setUserID(userName);
		newStudent.setName(name);
		newStudent.setPassword(password);
		newStudent.setDepartment(department);
		newStudent.setContactNumber(contactNumber);
		newStudent.setJoiningYear(joiningYear);

		StudentDaoOperation sdo=new StudentDaoOperation();
		try {
			sdo.addStudent(newStudent);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return newStudent;
	}
	
}
