
/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.utils.DBUtil;

/**
 * @author rutwi
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	private PreparedStatement statement = null;

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) throws FeesPendingException, StudentNotApprovedException {
		
		Connection connection = DBUtil.getConnection();
		
		
		try {
			statement = connection.prepareStatement(SQLQueries.GET_STUDENT_BY_ID(studentId, semesterId));
						
			ResultSet rs = statement.executeQuery();
			rs.next();
			Boolean primary4 = true;
			Boolean fees = true;
			List<String> primary_course_ids = new ArrayList<String>();
			List<String> alternate_course_ids = new ArrayList<String>();
			do {
				if(rs.getBoolean(7)==false)fees=false; //fees not paid
				if(rs.getString(2)!=null) {
					if(rs.getBoolean(5)) //is primary 
						primary_course_ids.add(rs.getString(2));
					else 
						alternate_course_ids.add(rs.getString(2));
				}
			}while(rs.next());
			
			if(!fees) {
				throw new FeesPendingException(studentId);
			}
			
			if( primary_course_ids.size()  + alternate_course_ids.size() < 4) {
				throw new StudentNotApprovedException(studentId);
			}
			
			PreparedStatement update_statement = connection.prepareStatement(SQLQueries.APPROVE_STUDENT(studentId, semesterId));
			
			update_statement .executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addProfessor(Professor professor){
		// TODO Auto-generated method stub
		String sql = "INSERT INTO professor(user_name, name, joining_year, contact_number, password, instructor_ID, designation, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, professor.getUserID());
			statement.setString(2, professor.getName());
			statement.setInt(3, professor.getJoiningYear());
			statement.setString(4, professor.getContactNumber());
			statement.setString(5, professor.getPassword());
			statement.setInt(6, professor.getInstructorID());
			statement.setString(7, professor.getDesignation());
			statement.setString(8, professor.getDepartment());
			
			int row = statement.executeUpdate();
			
			System.out.println(row + " user added.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}

	@Override
	public void removeProfessor(int professorID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM professor WHERE instructor_ID=?";
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professorID);
			
			int row = statement.executeUpdate();
			
			System.out.println(row + " user deleted.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void generateReportCard(int studentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourse(int courseID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM course_catalog WHERE courseID=?";
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseID);
			
			int row = statement.executeUpdate();
			
			System.out.println(row + " user deleted.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO course_catalog(courseID, course_name,  offered_semester, available_seats) VALUES (?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, course.getCourseID());
			statement.setString(2, course.getCoursename());
			statement.setInt(3, course.getOfferedSemester());
			statement.setInt(4, course.getAvailableSeats());
			
			int row = statement.executeUpdate();
			
			System.out.println(row + " user added.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}