/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.utils.DBUtil;

/**
 * @author Asus
 *
 */
public class SemesterRegistrationDaoOperation implements SemesterRegistrationDaoInterface{

	private static Connection conn = DBUtil.getConnection();

	public static void main(String[] args) throws SQLException {
		SemesterRegistrationDaoInterface test = new SemesterRegistrationDaoOperation();
		System.out.println(test.isRegistered(1, 1));
	}

	@Override
	public boolean addCourse(int studentId, int semesterId, String courseId) {

		PreparedStatement stmt;
		Course courseObj;

		try {

			courseObj = getCourseDetails(courseId);

			if(courseObj == null) {
				throw new CourseNotFoundException();
			}

			if(courseObj.getAvailableSeats() == 0) {
//				throw exception for no seats
			}

			String query = "INSERT INTO registered_courses VALUES (?,?,?,?,?,?,?)";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setString(2, courseObj.getCoursename());
			stmt.setInt(3, courseObj.getOfferedSemester());
			stmt.setInt(4, 0);
			stmt.setBoolean(5, false);
			stmt.setBoolean(6, false);
			stmt.setBoolean(7, false);
			stmt.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	private Course getCourseDetails(String courseId) {
		PreparedStatement stmt;
		Course courseObj = null;

		try {

			String query = "SELECT * FROM course_catalog WHERE courseID = ?";

			stmt = conn.prepareStatement(query);
			stmt.setString(1, courseId);
			ResultSet rs = stmt.executeQuery();

			rs.next();
			String courseID = rs.getString("courseID");
			String courseName = rs.getString("course_name");
			String instructor = rs.getString("instructor");
			Integer offeredSemester = rs.getInt("offered_semester");
			Integer availableSeats = rs.getInt("available_seats");

			courseObj = new Course(courseID, courseName, instructor, 10, availableSeats, offeredSemester);

			return courseObj;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean isRegistered(int studentId, int semeseterId) {
		PreparedStatement stmt;

		try {

			String query = "SELECT COUNT(1) FROM Registered_courses WHERE student_id = ? AND semester_id = ?";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setInt(2, semeseterId);
			ResultSet rs = stmt.executeQuery();

			rs.next();
			int isReg = rs.getInt("COUNT(1)");

			return isReg == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean dropCourse(int studentId, int semesterId, String courseId) {

		try {

			if(!isRegistered(studentId, semesterId)) {
//				coursesToAdd.remove(courseId);
				return true;
			}

			else {
//				throw exception here
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean finishRegistration(int studentId, int semesterId) throws SQLException {

		PreparedStatement stmt;

		try {

//			if(!(coursesToAdd.size() == 6)){
////				throw exception for invalid num of courses
//			}

			if(!isRegistered(studentId, semesterId)) {
				String query = "INSERT INTO Registered_courses";

				stmt = conn.prepareStatement(query);
				stmt.setInt(1, studentId);
				stmt.setInt(2, semesterId);
				ResultSet rs = stmt.executeQuery();

				ArrayList<String> courseID = new ArrayList<String>();

				while(rs.next()) {
					courseID.add(rs.getString("primary_course1"));
					courseID.add(rs.getString("primary_course2"));
					courseID.add(rs.getString("primary_course3"));
					courseID.add(rs.getString("primary_course4"));
				}

//				regCourses = new RegisteredCourses(studentId, semesterId, courseID);
			}

			else {
//				throw exception here
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public RegisteredCourses viewRegisteredCourses(int studentId, int semesterId) {

		PreparedStatement stmt;
		RegisteredCourses regCourses = null;

		try {

			String query = "SELECT primary_course1, primary_course2, primary_course3, primary_course4 FROM Registered_courses WHERE student_id = ? AND semester_id = ?";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setInt(2, semesterId);
			ResultSet rs = stmt.executeQuery();

			ArrayList<String> courseID = new ArrayList<String>();

			while(rs.next()) {
				courseID.add(rs.getString("primary_course1"));
				courseID.add(rs.getString("primary_course2"));
				courseID.add(rs.getString("primary_course3"));
				courseID.add(rs.getString("primary_course4"));
			}
			
			regCourses = new RegisteredCourses(studentId, semesterId, courseID);


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return regCourses;
	}

	@Override
	public ArrayList<Course> viewAvailableCourses() {

		PreparedStatement stmt;
		ArrayList<Course> courseCatalog = null;

		try {

			String query = "SELECT * FROM course_catalog";

			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			courseCatalog = new ArrayList<>();

			while(rs.next()) {
				String courseID = rs.getString("courseID");
				String courseName = rs.getString("course_name");
				String instructor = rs.getString("instructor");
				Integer offeredSemester = rs.getInt("offered_semester");
				Integer availableSeats = rs.getInt("available_seats");

				Course course = new Course(courseID, courseName, instructor, 10, availableSeats, offeredSemester);
				courseCatalog.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return courseCatalog;
	}

	@Override
	public int calculateFees(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Payment payFees(int studentId, int semesterId, String paymentMode) {
		// TODO Auto-generated method stub
		return null;
	}

}
