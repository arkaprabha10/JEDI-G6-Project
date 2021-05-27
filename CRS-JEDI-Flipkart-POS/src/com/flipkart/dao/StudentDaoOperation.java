package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.*;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.CourseNotAssignedException;
import com.flipkart.exception.ReportCardNotGeneratedException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyInUseException;
import com.flipkart.service.StudentOperation;
import com.flipkart.utils.DBUtil;

/**
 * 
 * @author Jayanth
 * Class to implement Student Dao Operations
 */
public class StudentDaoOperation implements StudentDaoInterface {

	private static volatile StudentDaoOperation instance=null;

	StudentDaoOperation() {

	}


	public static StudentDaoOperation getInstance() {
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentDaoOperation.class){
				instance=new StudentDaoOperation();
			}
		}
		return instance;
	}

	/**
	 * Method to add Student in database
	 * @param student
	 * @return Student
	 * @throws SQLException
	 * @throws UserAlreadyInUseException
	 */
	@Override
	public Student addStudent(Student student) throws SQLException, UserAlreadyInUseException{
		
		Connection connection=DBUtil.getConnection();
		
		try
		{
			//open db connection
			PreparedStatement stmt = connection.prepareStatement("SELECT MAX(student_id) FROM student");
			ResultSet results = stmt.executeQuery();
			int studentId = 0;
			if(results.next()) {
				studentId=results.getInt(1);
			}
			student.setStudentID(studentId+1);
			
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
		return student;
	}

	/**
	 * Method to view Report Card
	 * @param StudentID
	 * @param semesterId
	 * @return reportCard
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */
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
			HashMap<String,Integer> grades = new HashMap<String, Integer>();

			while (rs.next()) {
				if(!rs.getBoolean(7)) {
					throw new FeesPendingException(StudentID);
				}

				else if (!rs.getBoolean(6)) {
					throw new StudentNotApprovedException(StudentID);
				}

				else {
					if(rs.getInt(4)==0) {
						throw new GradeNotAddedException(StudentID);	
						}
					grades.put(rs.getString(2), rs.getInt(4));
				}
			}
			if(grades.isEmpty()) throw new ReportCardNotGeneratedException();
			R.setIsVisible(true);
			R.setGrades(grades);
				
		}
			
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		return R;
	}

	/**
	 * Method to view Registered Courses
	 * @param studentID
	 * @param semesterId
	 * @return list of registeredCourses
	 * @throws SQLException
	 * @throws StudentNotRegisteredException
	 */
	@Override
	public List<Course> viewRegisteredCourses(int studentID, int semesterId)
			throws SQLException, StudentNotRegisteredException {
		
		Connection connection=DBUtil.getConnection();
		
		List<Course> registeredCourses = new ArrayList<Course>();
		
		
		try
		{ 
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueries.GET_COURSES(studentID,semesterId));
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String courseId = rs.getString("course_id");

				PreparedStatement preparedStatement0=connection.prepareStatement(SQLQueries.GET_COURSE_BY_ID(courseId, semesterId));
				ResultSet rs0 = preparedStatement0.executeQuery();

				if(rs0.next()) {
					Course c = new Course();
					c.setCourseID(courseId);
					c.setCoursename(rs0.getString("course_name"));
					c.setInstructorID(rs0.getString("instructor"));
					c.setPrimary(rs.getBoolean("is_primary"));

					registeredCourses.add(c);
				}
			}
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

		if(registeredCourses.isEmpty()) {
			throw new StudentNotRegisteredException();
		}

		return registeredCourses;
	}

	/**
	 * Method to get StudentId from username
	 * @param username
	 * @return StudentId
	 * @throws StudentNotRegisteredException
	 * @throws SQLException
	 */
	@Override
	public int getStudentIDFromUserName(String username) throws StudentNotRegisteredException, SQLException {
		
		int studentID = -1;
		
		Connection connection=DBUtil.getConnection();
		
		try
		{
			//open db connection			
			String Qry = "select * from student where user_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(Qry);
			preparedStatement.setString(1, username);
			ResultSet results=preparedStatement.executeQuery();
			
			if(results.next()) {
				studentID = results.getInt("student_id");

				return studentID;
			}
			else {
				throw new StudentNotRegisteredException();
			}
		}
		catch(StudentNotRegisteredException ex) {
			System.out.println(ex.getMessage());
		}

		return studentID;
	}
	

}
