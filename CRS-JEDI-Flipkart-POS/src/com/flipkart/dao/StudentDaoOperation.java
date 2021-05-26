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
			PreparedStatement preparedStatement0=connection.prepareStatement("SELECT MAX(student_id) FROM student");
			ResultSet results=preparedStatement0.executeQuery();
			int studentId = 0;
			if(results.next()) {
				studentId=results.getInt(1);
			}
			student.setStudentID(studentId+1);
//			System.out.println(student.getStudentID());
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueries.ADD_STUDENT);
			preparedStatement.setString(1, student.getUserID());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, "student");//role
			preparedStatement.setInt(4, student.getStudentID());
			preparedStatement.setString(5, student.getDepartment());
			preparedStatement.setInt(6, student.getJoiningYear());
			preparedStatement.setString(7, student.getPassword());
			preparedStatement.setString(8, student.getContactNumber());
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
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
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

	@Override
	
	public Student getStudentfromUserName(String username) throws StudentNotRegisteredException, SQLException {
		
		Student student = new Student();
		
		Connection connection=DBUtil.getConnection();
		
		try
		{
			//open db connection			
			String Qry = "select * from student where user_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(Qry);
			preparedStatement.setString(1, username);
			ResultSet results=preparedStatement.executeQuery();
			
			if(results.next()) {
//				System.out.println(results.getInt(4));
				student.setUserID(username);
				student.setName(results.getString(2));
				student.setStudentID(results.getInt(4));
				student.setDepartment(results.getString(5));
				student.setJoiningYear(results.getInt(6));
				student.setPassword(results.getString(7));
				student.setContactNumber(results.getString(8));
			}
			else {
				throw new StudentNotRegisteredException();
			}	
			
			
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
	

}
