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
	private Integer offeredSemester;

	/**
	 * Method to get isn't it Primary Course or not
	 * @return true if primary course else false
	 */
	public Boolean getPrimary() {
		return isPrimary;
	}

	/**
	 * Method to set Course as Primary or not
	 * @param primary
	 */
	public void setPrimary(Boolean primary) {
		isPrimary = primary;
	}

	private Boolean isPrimary;

	/**
	 * Default Constructor
	 */
	public Course() {
		this.courseID = "0";
		this.coursename = "xyz";
		this.instructorID = "1";
		this.totalSeats = 0;
		this.availableSeats = 0;
		this.offeredSemester = 1;
		this.isPrimary = false;
	}
	
	/**
	 * Parameterized Constructor
	 * @param courseID
	 * @param coursename
	 * @param instructorID
	 * @param totalSeats
	 * @param availableSeats
	 * @param offeredSemester
	 */
	public Course(String courseID, String coursename, String instructorID, Integer totalSeats, Integer availableSeats, Integer offeredSemester) {
		super();
		this.courseID = courseID;
		this.coursename = coursename;
		this.instructorID = instructorID;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.offeredSemester = offeredSemester;
		this.isPrimary = false;
	}

	/**
	 * Method to get CourseID
	 * @return CourseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * Method to set CourseID
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * Method to get Coursename
	 * @return Coursename
	 */
	public String getCoursename() {
		return coursename;
	}
	
	/**
	 * Method to set course name
	 * @param coursename
	 */
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	/**
	 * Method to getInstructorID teaching this course
	 * @return InstructorID
	 */
	public String getInstructorID() {
		return instructorID;
	}
	
	/**
	 * Method to set InstructorID teaching this course
	 * @param instructorID
	 */
	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}
	
	/**
	 * Method to get Total seats in Course
	 * @return total seats in course
	 */
	public Integer getTotalSeats() {
		return totalSeats;
	}
	
	/**
	 * Method to set Total seats in Course
	 * @param totalSeats
	 */
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	/**
	 * Method to get Available Seats in course
	 * @return number of available seats
	 */
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	
	/**
	 * Method to set available seats in course
	 * @param availableSeats
	 */
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	/**
	 * Method know is course offered this sem or not
	 * @return 1 if course offered else 0
	 */
	public Integer getOfferedSemester() {
		return offeredSemester;
	}
	
	/**
	 * Method to set course offering status
	 * @param offeredSemester
	 */
	public void setOfferedSemester(Integer offeredSemester) {
		this.offeredSemester = offeredSemester;
	}
	
}
