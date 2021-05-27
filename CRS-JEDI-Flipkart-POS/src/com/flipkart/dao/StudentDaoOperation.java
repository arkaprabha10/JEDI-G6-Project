package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

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

public class StudentDaoOperation implements StudentDaoInterface {
	
	private static Logger logger = Logger.getLogger(StudentDaoOperation.class);
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
			logger.error(ex.getMessage());
//			throw new UserAlreadyInUseException();
		}
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
			logger.error(ex.getMessage());
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
			List<String> course_ids= new ArrayList<String>();
		
			while (rs.next()) {
//				System.out.println(rs.getString(1));
				course_ids.add(rs.getString(1));
			}
			
			for(String courseId: course_ids) {		
				PreparedStatement preparedStatement0=connection.prepareStatement(SQLQueries.GET_COURSE_BY_ID(courseId,semesterId));
				ResultSet rs0 = preparedStatement0.executeQuery();
				Course c = new Course();
				c.setCourseID(courseId);
				rs0.next();
				c.setCoursename(rs0.getString(2));
				c.setInstructorID(rs0.getString(3));
				registeredCourses.add(c);
			}
		}
		
		catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		
		return registeredCourses;
	}

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
			logger.error(ex.getMessage());
		}

		return studentID;
	}
	

}
