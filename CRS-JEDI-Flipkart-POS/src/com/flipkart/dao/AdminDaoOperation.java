
/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtil;

/**
 * @author rutwi
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	private PreparedStatement statement = null;

	@Override
	public void approveStudentRegistration(ArrayList<Student> students) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor){
		// TODO Auto-generated method stub
		String sql = "INSERT INTO professor(user_name, name, joining_year, contact_number, password, instructor_ID, designation, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, professor.getuserName());
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
	public void removeProfessor(Professor professor) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM professor WHERE user_name=?";
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, "username");
			//statement.setString(1, professor.getuserName());
			
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
	public void removeCourse(int courseID, ArrayList<Course> courseCatalog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(int courseID, ArrayList<Course> courseCatalog) {
		// TODO Auto-generated method stub
		
	}

}