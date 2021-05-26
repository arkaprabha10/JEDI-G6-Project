/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import  com.flipkart.utils.DBUtil;
import com.flipkart.bean.Course;
//import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourses;
//import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;

/**
 * @author Dell
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {
	
	

	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade) {
		// TODO Auto-generated method stub
		
		Connection connection=DBUtil.getConnection();
		try 
		{
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
		    	sql1="UPDATE registered_courses set grade1 = (?) WHERE student_id = "+studentID+" AND semester_id = "+semesterID;
		    	
		    }
		    else if(rs.getString("primary_course4").equals(courseID))
		    {
		    	sql1="UPDATE registered_courses set grade1 = (?) WHERE student_id = "+studentID+" AND semester_id = "+semesterID;
		    	
		    }
		    else 
		    {
		    	throw 
		    }
//		    
			stmt1 = connection.prepareStatement(sql1);
	    	stmt1.setInt(1, grade);
			int res = stmt1.executeUpdate();
			
            if (res > 0)            
                System.out.println("Successfully Inserted");            
            else            
                System.out.println("Insert Failed");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM registered_courses WHERE primary_course1 = '"+courseID+"' OR primary_course2 = '"+courseID+"' OR primary_course3 = '"+courseID+"' OR primary_course4 = '"+courseID+"'" ;
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<RegisteredCourses>ans = new ArrayList<RegisteredCourses>();
			ArrayList<String>temp = new ArrayList<String>();
			
			while(rs.next())
			{
				
				temp.add(rs.getString("primary_course1"));
				temp.add(rs.getString("primary_course2"));
				temp.add(rs.getString("primary_course3"));
				temp.add(rs.getString("primary_course4"));
				RegisteredCourses tempObject = new RegisteredCourses(rs.getInt("student_id"),rs.getInt("semester_id"),temp);
				ans.add(tempObject);
				temp.clear();
				
			}
			return ans;
			
			
			//			private Integer studentID;
//			private Integer semesterID;
//			private ArrayList<String> courseID = new ArrayList<String>();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public ArrayList<Course> viewCourseProf(String instructorID) throws SQLException {
		// TODO Auto-generated method stub
//		private String courseID;
//		private String coursename;
//		private String instructorID;
//		private Integer totalSeats;
//		private Integer availableSeats;
		
		Connection connection=DBUtil.getConnection();
		try {
			
			String sql = "SELECT * FROM course_catalog WHERE instructor="+"'"+instructorID+"'";
			
			System.out.println(sql);
			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, instructorID);
			ResultSet rs = stmt.executeQuery(sql);
			
			
			ArrayList<Course>ans = new ArrayList<Course>();
			
			while(rs.next())
			{
				
			Course c = new Course(rs.getString("courseID"), rs.getString("course_name"), rs.getString("instructor"), 10, rs.getInt("available_seats"), 0);
			ans.add(c);
			}
			return ans;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
