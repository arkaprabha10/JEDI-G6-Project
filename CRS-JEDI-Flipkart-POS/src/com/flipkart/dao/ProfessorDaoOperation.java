/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
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

	public static void main(String[] args) {
		ProfessorDaoOperation test = new ProfessorDaoOperation();

//		test.addGrade(1, 1, "aaa", 3);

		for(RegisteredCourses regCourseObj : test.viewCourseStudents("aaa", 1)) {
			System.out.println(regCourseObj.getStudentID());
		}
	}

	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade) {
		// TODO Auto-generated method stub
		
		Connection connection=DBUtil.getConnection();
		try 
		{
<<<<<<< HEAD
			String sql="",sql1="";
			PreparedStatement stmt = null,stmt1=null;
			sql = "SELECT * FROM registered_courses WHERE student_id = "+studentID+" AND semester_id = "+semesterID;         
//		    System.out.println(sql);
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
		    
			if(rs.getString("primary_course1").equals(courseID))
		    {
		    	sql1="UPDATE registered_courses set grade1 = (?) WHERE student_id = "+studentID+" AND semester_id = "+semesterID;
		    }
		    else if(rs.getString("primary_course2").equals(courseID))
		    {
		    	sql1="UPDATE registered_courses set grade2 = (?) WHERE student_id = "+studentID+" AND semester_id = "+semesterID;
		    	
		    }
		    else if(rs.getString("primary_course3").equals(courseID))
		    {
		    	sql1="UPDATE registered_courses set grade3 = (?) WHERE student_id = "+studentID+" AND semester_id = "+semesterID;
		    	
		    }
		    else if(rs.getString("primary_course4").equals(courseID))
		    {
		    	sql1="UPDATE registered_courses set grade4 = (?) WHERE student_id = "+studentID+" AND semester_id = "+semesterID;
		    	
		    }
		    
//		    
			stmt1 = connection.prepareStatement(sql1);
	    	stmt1.setInt(1, grade);
			int res = stmt1.executeUpdate();
=======
			String queryStr;
			PreparedStatement stmt;

			queryStr = "UPDATE registered_courses SET grade = ? WHERE student_id = ? AND course_id = ? AND semester_id = ?";
			stmt = connection.prepareStatement(queryStr);
	    	stmt.setInt(1, grade);
			stmt.setInt(2, studentID);
			stmt.setString(3, courseID);
			stmt.setInt(4, semesterID);

			int res = stmt.executeUpdate();
>>>>>>> 9231a43c4e79d941ea65411391c9d687439eb7ff
			
            if (res > 0)            
                System.out.println("Successfully Inserted");            
            else            
                System.out.println("Insert Failed");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		finally 
		{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
=======
>>>>>>> 9231a43c4e79d941ea65411391c9d687439eb7ff
	}

	@Override
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM registered_courses WHERE course_id = ? AND semester_id = ?" ;
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, courseID);
			stmt.setInt(2, semesterID);
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<RegisteredCourses> ans = new ArrayList<RegisteredCourses>();
			ArrayList<String> temp = new ArrayList<String>();
			
			while(rs.next()) {
				temp.add(rs.getString("course_id"));
				RegisteredCourses tempObject = new RegisteredCourses(rs.getInt("student_id"), rs.getInt("semester_id"), temp);
				ans.add(tempObject);
				temp.clear();
			}

			return ans;
		}
		catch(SQLException e) {
			e.printStackTrace();
<<<<<<< HEAD
			
		}
		finally 
		{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
=======
>>>>>>> 9231a43c4e79d941ea65411391c9d687439eb7ff
		}
		
		return null;
	}

	@Override
	public ArrayList<Course> viewCourseProf(String instructorID) {
		// TODO Auto-generated method stub
		
		Connection connection=DBUtil.getConnection();
		try {
			
			String sql = "SELECT * FROM course_catalog WHERE instructor = ?";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, instructorID);
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Course>ans = new ArrayList<Course>();
			
			while(rs.next()) {
				Course c = new Course(rs.getString("courseID"), rs.getString("course_name"), rs.getString("instructor"), 10, rs.getInt("available_seats"), 0);
				ans.add(c);
			}
			return ans;
		}

		catch(SQLException e) {
			e.printStackTrace();
			
		}
<<<<<<< HEAD
		finally 
		{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
=======

>>>>>>> 9231a43c4e79d941ea65411391c9d687439eb7ff
		return null;
	}

	@Override
	public Boolean registerCourse(String instructorID, Integer semesterID, String courseID) throws SQLException {
		
		Connection connection=DBUtil.getConnection();
try {
			
			String sql = "SELECT * FROM course_catalog WHERE courseID = '"+courseID+"' AND offered_semester = "+semesterID + " AND instructor is NULL";
			String sql1 = "UPDATE course_catalog set instructor = + '"+instructorID+"' WHERE courseID = '"+courseID+"' AND offered_semester = "+semesterID;
			System.out.println(sql);
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			if(!rs.next())
			{
				System.out.println("Course already registered");
				return false;
			}
			else {
			
				PreparedStatement stmt1 = connection.prepareStatement(sql1);
				int res = stmt1.executeUpdate();
				if (res > 0)            
	                System.out.println("Successfully Inserted");            
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

}
