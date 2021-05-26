/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.ProfessorNotRegisteredException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Dell
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {
	private volatile ProfessorDaoOperation instance=null;

	private ProfessorDaoOperation(){

	}
	public static ProfessorDaoOperation getInstance(){
		if(instance==null)
		{
			synchronized (ProfessorDaoOperation.class){
				instance=new ProfessorDaoOperation();
			}
		}
		return instance;
	}

	public static void main(String[] args) throws SQLException {
		ProfessorDaoOperation test = new ProfessorDaoOperation();

//		test.addGrade(1, 1, "A", 3);
//		test.registerCourse("Abc", 1,"1" );
//		ArrayList<Course> temp = test.viewCourseProf("ABC");
//		for(Course r: temp )
//			System.out.println(r.getCourseID()+" "+r.getCoursename());
	}

	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade) {
		// TODO Auto-generated method stub
		
		Connection connection=DBUtil.getConnection();
		try 
		{
	String queryStr;
			PreparedStatement stmt;

			queryStr = "UPDATE registered_courses SET grade = ? WHERE student_id = ? AND course_id = ? AND semester_id = ?";
			stmt = connection.prepareStatement(queryStr);
	    	stmt.setInt(1, grade);
			stmt.setInt(2, studentID);
			stmt.setString(3, courseID);
			stmt.setInt(4, semesterID);

			int res = stmt.executeUpdate();
			
            if (res > 0)            
                System.out.println("Successfully Inserted");            
            else            
                System.out.println("Insert Failed");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM registered_courses WHERE course_id = ? AND semester_id = ?" ;
			System.out.println(sql);
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, courseID);
			stmt.setInt(2, semesterID);
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<RegisteredCourses> ans = new ArrayList<RegisteredCourses>();
			ArrayList<String> temp = new ArrayList<String>();
			if(!rs.next())
			{
				System.out.println("No student in Course!!");
			}
			else {
				do  {
					temp.add(rs.getString("course_id"));
					RegisteredCourses tempObject = new RegisteredCourses(rs.getInt("student_id"), rs.getInt("semester_id"), temp);
					ans.add(tempObject);
					temp.clear();
				}while(rs.next());
			}
			

			return ans;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Course> viewCourseProf(int instructorID) {
		// TODO Auto-generated method stub

		ArrayList<Course>ans = new ArrayList<Course>();
		Connection connection=DBUtil.getConnection();
		try {
			
			String sql = "SELECT * FROM course_catalog WHERE instructor = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, instructorID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Course c = new Course(rs.getString("courseID"), rs.getString("course_name"), rs.getString("instructor"), 10, rs.getInt("available_seats"), 0);
				ans.add(c);
			}

			if(!ans.isEmpty()) {
				return ans;
			}
			else {
				throw new Exception("Not yet registered to any courses!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ans;
	}

	@Override
	public Boolean registerCourse(int instructorID, Integer semesterID, String courseID) {
		
		Connection connection=DBUtil.getConnection();
		try {
			
			String sql = "SELECT * FROM course_catalog WHERE courseID = '"+courseID+"' AND offered_semester = "+semesterID + " AND instructor is NULL";
			String sql1 = "UPDATE course_catalog set instructor = + '"+instructorID+"' WHERE courseID = '"+courseID+"' AND offered_semester = "+semesterID;
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			if(!rs.next())
			{
				System.out.println("Course already registered / Course doesn't exist!!");
				return false;
			}
			else {
			
				PreparedStatement stmt1 = connection.prepareStatement(sql1);
				int res = stmt1.executeUpdate();
				if (res > 0)            
	                System.out.println("Successfully Registered");            
	            else            
	                System.out.println("Registration Failed");
			}
				
			
			return true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
			
		}
	}

	public int getProfessorIDFromUserName(String username) throws SQLException {

		int professorID = -1;

		Connection connection=DBUtil.getConnection();

		try
		{
			String Qry = "select * from professor where user_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(Qry);
			preparedStatement.setString(1, username);
			ResultSet results=preparedStatement.executeQuery();

			if(results.next()) {
				professorID = results.getInt("instructor_ID");

				return professorID;
			}
			else {
				throw new ProfessorNotRegisteredException();
			}
		}
		catch(ProfessorNotRegisteredException ex) {
			System.out.println(ex.getMessage());
		}

		return professorID;
	}

}
