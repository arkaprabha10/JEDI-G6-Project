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
}
