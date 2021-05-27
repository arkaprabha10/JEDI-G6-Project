package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyInUseException;

public class StudentOperation implements StudentInterface {
	
	private static volatile StudentOperation instance=null;
	StudentDaoInterface SDO =StudentDaoOperation.getInstance();

	private StudentOperation()
	{
		
	}
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}

	@Override
	public ReportCard viewReportCard(int StudentID, int semesterId)  {

		ReportCard R = new ReportCard();
//		StudentDaoOperation SDO= new StudentDaoOperation();
		try {
			R = SDO.viewReportCard(StudentID,semesterId);
			System.out.println("StudentID : "+R.getStudentID()+"\t SemesterID : "+R.getSemesterID());
	    	System.out.println("Course  Grade");
	    	R.getGrades().forEach((key, value) -> {
	    		System.out.println(key + "    " + value);
	    		});
		} catch (SQLException | GradeNotAddedException | StudentNotApprovedException | FeesPendingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		ReportCardOperation report = new ReportCardOperation();
		R.setSpi(report.getSPI(R));
		return R;
	}

	@Override
	public void viewRegisteredCourses(int studentID, int semesterId) {

		try {
			List<Course> courses = SDO.viewRegisteredCourses(studentID,semesterId);

			System.out.println("=======================================");
			System.out.println("Registered courses :");
			System.out.println("---------------------------------------");
			System.out.println("Primary courses :");
			for(Course c: courses) {
				if(c.getPrimary()) {
					System.out.println("Course ID : "+c.getCourseID()+" \t Course Name : "+ c.getCoursename()+"\t Instructor : "+c.getInstructorID());
				}
			}
			System.out.println("---------------------------------------");
			System.out.println("Alternate courses :");
			for(Course c: courses) {
				if(!c.getPrimary()) {
					System.out.println("Course ID : "+c.getCourseID()+" \t Course Name : "+ c.getCoursename()+"\t Instructor : "+c.getInstructorID());
				}
			}
			System.out.println("=======================================");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
//		StudentDaoOperation sdo=new StudentDaoOperation();
		SDO.addStudent(newStudent);
		return newStudent;
	}
	
	public static void main(String[] args) throws UserAlreadyInUseException, SQLException, StudentNotRegisteredException, GradeNotAddedException, StudentNotApproved, FeesPendingException, StudentNotApprovedException {
		System.out.println("Hey There!");
		StudentOperation so = new StudentOperation();
		
//			so.addStudent("09.Charlie", "Drake", "6273","EE", "2538389027", 2021);
//			List<Course> l=so.viewRegisteredCourses(1, 1);
//			for (Course el: l ) {
//				System.out.println(el.getCourseID());
//			}
//			so.viewReportCard(1, 1);
	}
	
}
