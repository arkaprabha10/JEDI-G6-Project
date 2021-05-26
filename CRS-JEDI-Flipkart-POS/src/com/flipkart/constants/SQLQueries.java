/**
 * 
 */
package com.flipkart.constants;

/**
 * @author Asus
 *
 */
public class SQLQueries {
	public static final String ADD_STUDENT = "insert into student(user_name, name, role, student_id, department, joining_year, password, contact_number) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_STUDENTS = "select * from student";
	
	public static final String GET_REPORT(int studentID, int semesterId) {
		 String qry="select * from registered_courses where student_id = "+studentID+" and semester_id = "+semesterId;
		 return qry;
	}

	public static final String GET_COURSES(int studentID, int semesterId) {
		String qry="select primary_course1, primary_course2, primary_course3, primary_course4 from registered_courses where student_id = "+studentID+" and semester_id = "+semesterId;
		 return qry;
	}

	public static String GET_COURSE_BY_ID(String courseId, int semesterId) {
		String qry="select * from course_catalog where courseID = "+courseId+" and offered_semester = "+semesterId;
	 return qry;
	}

}
