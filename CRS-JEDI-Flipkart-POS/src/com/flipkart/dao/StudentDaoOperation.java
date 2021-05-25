package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.GradeNotAddedException;
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
			if(results.next())
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
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return student;
	}

	@Override
	public ReportCard viewReportCard(int StudentID, int semesterId) throws SQLException, GradeNotAddedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredCourses> viewRegisteredCourses(int studentID, int semesterId)
			throws SQLException, StudentNotRegisteredException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
