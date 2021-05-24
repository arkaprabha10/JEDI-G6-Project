/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Course {
	private String courseID;
	private String coursename;
	private String instructorID;
	private Integer totalSeats;
	private Integer availableSeats;

	
	public Course() {
		this.courseID = "0";
		this.coursename = "xyz";
		this.instructorID = "1";
		this.totalSeats = 0;
		this.availableSeats = 0;
	}
	public Course(String courseID, String coursename, String instructorID, Integer totalSeats, Integer availableSeats) {
		super();
		this.courseID = courseID;
		this.coursename = coursename;
		this.instructorID = instructorID;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
	}

	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
	
}
