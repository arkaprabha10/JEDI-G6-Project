/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
//import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.bean.Student;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;

/**
 * @author rutwi
 *
 */
public class ProfessorOperation implements ProfessorInterface {

	//Add grade
	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade)  
	{
		try {
			ProfessorDaoInterface profObj=new ProfessorDaoOperation();
			profObj.addGrade(studentID, semesterID,courseID, grade);
			System.out.println("Grade added successfully");
			
		}
		catch(Exception e){
			;
		}
	}

	//view student details who have registered for a particular course
	@Override
	public void viewCourseStudents(String courseID, Integer semesterID) {
		
		ArrayList<RegisteredCourses>ans = new ArrayList<RegisteredCourses>();
		
		try {
			ProfessorDaoInterface profObj=new ProfessorDaoOperation();
			ans = profObj.viewCourseStudents(courseID, semesterID);
			for (RegisteredCourses r:ans) {
				System.out.println("studentID = " + r.getStudentID()+ " Semester ID = "+r.getSemesterID());
			}
			 
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//view course details which the professor is associated with
	@Override
	public void viewCourseProf(int instructorID) {
	
		ArrayList<Course>ans = new ArrayList<Course>();
		try {
			
			
			ProfessorDaoInterface profObj=new ProfessorDaoOperation();
			ans = profObj.viewCourseProf(instructorID);
			for (Course c: ans) {
				System.out.println("CourseID = " + c.getCourseID()+ " Course Name = " + c.getCoursename());
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public void registerCourse(int instructorID, Integer semesterID, String courseID) {
		ProfessorDaoInterface profObj=new ProfessorDaoOperation();
		try {
			Boolean ans = profObj.registerCourse(instructorID, semesterID, courseID);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
