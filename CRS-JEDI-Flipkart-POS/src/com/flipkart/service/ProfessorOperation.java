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
	
	private static volatile ProfessorOperation instance=null;
//	ProfessorDaoInterface profObj = ProfessorDaoOperation.getInstance();
	private ProfessorOperation()
	{

	}
	
	/**
	 * Method to make ProfessorOperation Singleton
	 * @return
	 */
	public static ProfessorOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorOperation.class){
				instance=new ProfessorOperation();
			}
		}
		return instance;
	}

	//Add grade
	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade) throws GradeNotAddedException 
	{
		try {
			ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
			profObj.addGrade(studentID, semesterID,courseID, grade);
			System.out.println("Grade added successfully");
			
		}
		catch(Exception e){
			throw new GradeNotAddedException(studentID);
		}
	}

	//view student details who have registered for a particular course
	@Override
	public void viewCourseStudents(String courseID, Integer semesterID)throws CourseNotFoundException {
		
		ArrayList<RegisteredCourses>ans = new ArrayList<RegisteredCourses>();
		
		try {
			ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
			ans = profObj.viewCourseStudents(courseID, semesterID);
			for (RegisteredCourses r:ans) {
				System.out.println("studentID = " + r.getStudentID()+ " Semester ID = "+r.getSemesterID());
			}
			 
		}
		catch(Exception e) {
			throw new CourseNotFoundException(courseID);
		}
	}

	//view course details which the professor is associated with
	@Override
	public void viewCourseProf(int instructorID) {
	
		ArrayList<Course>ans = new ArrayList<Course>();
		try {
			
			
			ProfessorDaoInterface profObj=ProfessorDaoOperation.getInstance();
			ans = profObj.viewCourseProf(instructorID);
			for (Course c: ans) {
				System.out.println("CourseID = " + c.getCourseID()+ " Course Name = " + c.getCoursename());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void registerCourse(int instructorID, Integer semesterID, String courseID) throws SQLException {
		ProfessorDaoInterface profObj=ProfessorDaoOperation.getInstance();
		Boolean ans = profObj.registerCourse(instructorID, semesterID, courseID);
		
		
	}

}
