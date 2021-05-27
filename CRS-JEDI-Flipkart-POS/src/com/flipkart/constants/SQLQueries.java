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
	public static final String GET_PENDING_STUDENT = "select * from student where account_approved = 0 ";
	
	public static final String GET_REPORT(int studentID, int semesterId) {
		 String qry="select * from registered_courses where student_id = "+studentID+" and semester_id = "+semesterId +" and is_primary=1";
		 return qry;
	}

	public static final String GET_COURSES(int studentID, int semesterId) {
		String qry="select course_id from registered_courses where student_id = "+studentID+" and semester_id = "+semesterId ;//+" and is_primary=1";
		 return qry;
	}

	public static String GET_COURSE_BY_ID(String courseId, int semesterId) {
		String qry="select * from course_catalog where courseID = '"+courseId+"' and offered_semester = "+semesterId;
	 return qry;
	}

	
	public static String GET_STUDENT_BY_ID(int studentId, int semesterId) {
		String qry="select * from registered_courses where student_id = '"+studentId+"' and semester_id = "+semesterId;
		 return qry;
	}

	public static String APPROVE_STUDENT(int studentId, int semesterId) {
		String qry="UPDATE registered_courses set is_approved=1 where student_id = '"+studentId+"' and semester_id = "+semesterId;
		 return qry;
	}

	public static String GET_ALL_COURSES(int semesterId) {
		String qry="select distinct course_id from registered_courses where semester_id = "+semesterId;
		 return qry;
	}

	public static String GET_COURSE_STUDENTS(String course_id,int semesterId) {
		return "select student_id from registered_courses where course_id = '"+course_id+"' and semester_id = "+semesterId;
	}

	public static String GET_STUDENT(int studentID) {
		String qry="select account_approved from student where student_id = "+studentID;
		 return qry;
	}

	public static String GENERATE_REPORT_CARD(int studentID,float spi) {
		String qry="update student set spi = "+spi+ " where student_id = "+studentID;
		 return qry;
	}

	public static String APPROVE_STUDENT_ACCOUNT(int studentId) {
		String qry="update student set account_approved = 1 where student_id = "+studentId;
		return qry;
	}

}
