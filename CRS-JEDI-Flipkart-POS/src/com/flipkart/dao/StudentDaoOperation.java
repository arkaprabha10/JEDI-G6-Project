package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyInUseException;
import com.flipkart.utils.DBUtil;

public class StudentDaoOperation implements StudentDaoInterface {

	@Override
	public Student addStudent(Student student) throws SQLException, UserAlreadyInUseException{
		Connection connection=DBUtil.getConnection();
		
		try
		{
			//open db connection
			PreparedStatement preparedStatement0=connection.prepareStatement(SQLQueries.GET_STUDENTS,Statement.RETURN_GENERATED_KEYS);
			ResultSet results=preparedStatement0.getGeneratedKeys();
			int studentId = 0;
			while(results.next())
				studentId=results.getInt(1);
			
			student.setStudentID(studentId+1);
			System.out.println(studentId);
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueries.ADD_STUDENT);
			preparedStatement.setString(1, student.getUserID());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, "student");//role
			preparedStatement.setInt(4, student.getStudentID());
			preparedStatement.setString(5, student.getDepartment());
			preparedStatement.setString(6, student.getPassword());
			preparedStatement.setString(7, student.getContactNumber());
			preparedStatement.setInt(8, student.getJoiningYear());
			preparedStatement.executeUpdate();
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
//			throw new UserAlreadyInUseException();
		}
//		finally
//		{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
//		}
		return student;
	}

	@Override
	public ReportCard viewReportCard(int StudentID, int semesterId) throws SQLException, GradeNotAddedException , StudentNotApprovedException, FeesPendingException{
		Connection connection=DBUtil.getConnection();
		
		ReportCard R = new ReportCard();
		R.setStudentID(StudentID);
		R.setSemesterID(semesterId);
		
		try
		{ 
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueries.GET_REPORT(StudentID,semesterId));
			
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			if(rs.getBoolean(13)==false)
				throw new FeesPendingException(StudentID);
			else if (rs.getBoolean(14)==false)
				throw new StudentNotApprovedException(StudentID);
			else {
				R.setIsVisible(true);
				
				HashMap<String,Integer> grades = new HashMap<String, Integer>();
				
				for(int i=0;i<4;i++) {
					grades.put(rs.getString(2+i), rs.getInt(9+i));
				}
				
				R.setGrades(grades);
				
			}
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
//		finally
//		{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
//		}
		
		return R;
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentID, int semesterId)
			throws SQLException, StudentNotRegisteredException {
		
		Connection connection=DBUtil.getConnection();
		
		List<Course> registeredCourses = new ArrayList<Course>();
		
		
		try
		{ 
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueries.GET_COURSES(studentID,semesterId));
			
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			List<String> course_ids= new ArrayList<String>();
			for(int i=1;i<=4;i++) {
				course_ids.add(rs.getString(i));
			}
			for(int i=1;i<=4;i++) {		
				String courseId = course_ids.get(i-1);
				PreparedStatement preparedStatement0=connection.prepareStatement(SQLQueries.GET_COURSE_BY_ID(courseId,semesterId));
				ResultSet rs0 = preparedStatement.executeQuery();
				Course c = new Course();
				c.setCourseID(courseId);
				rs0.next();
				c.setCoursename(rs0.getString(2));
				c.setInstructorID(rs0.getString(2));
				registeredCourses.add(c);
			}
		}
		
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
//		finally
//		{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
//		}
		
		return registeredCourses;
	}
	public void viewReportCard(int StudentID, ReportCard reportCard) {
		// TODO Auto-generated method stub
		
	}
	
	

}
