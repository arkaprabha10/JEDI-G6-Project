/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

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
	private static volatile SemesterRegistrationDaoOperation instance=null;
	private static Connection conn = DBUtil.getConnection();

	private SemesterRegistrationDaoOperation(){

	}

	public static SemesterRegistrationDaoOperation getInstance()
	{
		if(instance==null)
		{
			synchronized(SemesterRegistrationDaoOperation.class){
				instance=new SemesterRegistrationDaoOperation();
			}
		}
		return instance;
	}


	public static void main(String[] args) throws SQLException {
		SemesterRegistrationDaoInterface test = new SemesterRegistrationDaoOperation();

//		test.addCourse(3, 1, "aaa", false);
//		test.dropCourse(3, 1, "aaa");

//		for(String courseID : test.viewRegisteredCourses(1, 1).getCourseID()) {
//			System.out.println(courseID);
//		}
	}

	@Override
	public boolean addCourse(int studentId, int semesterId, String courseId, boolean isPrimary) {

		PreparedStatement stmt;
		Course courseObj;

		try {

			courseObj = getCourseDetails(courseId, semesterId);

			if(courseObj == null) {
				throw new CourseNotFoundException();
			}

			if(courseObj.getAvailableSeats() <= 0) {
//				throw exception for no seats
//				to do : create an exception for this
			}

			if(checkRegisteredCourseExists(studentId, semesterId, courseId)) {
//				throw exception for duplication
// 				to do : create an exception for this
				throw new Exception("Course already added to cart!");
			}

			String query = "INSERT INTO registered_courses VALUES (?,?,?,?,?,?,?)";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setString(2, courseObj.getCourseID());
			stmt.setInt(3, courseObj.getOfferedSemester());
			stmt.setInt(4, 0);
			stmt.setBoolean(5, isPrimary);
			stmt.setBoolean(6, false);
			stmt.setBoolean(7, false);
			stmt.execute();

			changeCourseSeats(courseId, semesterId, 0);

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	private Course getCourseDetails(String courseId, Integer semesterId) {
		PreparedStatement stmt;
		Course courseObj = null;

		try {

			String query = "SELECT * FROM course_catalog WHERE courseID = ? AND offered_semester = ?";

			stmt = conn.prepareStatement(query);
			stmt.setString(1, courseId);
			stmt.setInt(2, semesterId);
			ResultSet rs = stmt.executeQuery();

			String courseID = null, courseName, instructor;
			int offeredSemester, availableSeats;

			while (rs.next()) {
				courseID = rs.getString("courseID");
				courseName = rs.getString("course_name");
				instructor = rs.getString("instructor");
				offeredSemester = rs.getInt("offered_semester");
				availableSeats = rs.getInt("available_seats");

				courseObj = new Course(courseID, courseName, instructor, 10, availableSeats, offeredSemester);
			}

			return courseObj;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private boolean checkRegisteredCourseExists(int studentId, int semesterId, String courseId) {
		PreparedStatement stmt;

		try {

			String query = "SELECT COUNT(1) FROM registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setString(2, courseId);
			stmt.setInt(3, semesterId);
			ResultSet rs = stmt.executeQuery();

			rs.next();

			if(rs.getInt("COUNT(1)") == 1) {
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	// change = 0 -> add course
	// change = 1 -> drop course
	private void changeCourseSeats(String courseId, int semesterId, int change) {
		PreparedStatement stmt;

		try {

			int currentAvailableSeats = Objects.requireNonNull(getCourseDetails(courseId, semesterId)).getAvailableSeats();
			String query = "UPDATE course_catalog SET available_seats = ? WHERE  courseID = ? AND offered_semester = ?";

			int seatChange =  (change == 0 ? -1 : 1);

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, currentAvailableSeats + seatChange);
			stmt.setString(2, courseId);
			stmt.setInt(3, semesterId);
			stmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean dropCourse(int studentId, int semesterId, String courseId) {

		PreparedStatement stmt;
		Course courseObj;

		try {

			courseObj = getCourseDetails(courseId, semesterId);

			if(courseObj == null) {
				throw new CourseNotFoundException();
			}

			if(!checkRegisteredCourseExists(studentId, semesterId, courseId)) {
//				throw exception for dropping not registered course
// 				to do : create an exception for this
				throw new Exception("Course not in cart.");
			}

			String query = "DELETE FROM registered_courses WHERE student_id = ? AND course_id = ? AND semester_id = ?";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setString(2, courseObj.getCourseID());
			stmt.setInt(3, courseObj.getOfferedSemester());
			stmt.execute();

			changeCourseSeats(courseId, semesterId, 1);

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	@Override
	public boolean finishRegistration(int studentId, int semesterId) {

		PreparedStatement stmt;

		try {

			String query = "SELECT * FROM registered_courses WHERE student_id = ? AND semester_id = ?";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setInt(2, semesterId);
			ResultSet rs = stmt.executeQuery();

			int totalPrimaryCourse = 0, totalAlternateCourses = 0;

			while(rs.next()) {
				if(rs.getBoolean("is_primary")) {
					totalPrimaryCourse++;
				}
				else {
					totalAlternateCourses++;
				}
			}

			if(totalPrimaryCourse == 4 && totalAlternateCourses == 2) {
				return true;
			}

			else {
//				throw exception for invalid number of courses
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

			String query = "SELECT * FROM registered_courses WHERE student_id = ? AND semester_id = ?";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setInt(2, semesterId);
			ResultSet rs = stmt.executeQuery();

			ArrayList<String> courseID = new ArrayList<>();

			while(rs.next()) {
				courseID.add(rs.getString("course_id"));
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
