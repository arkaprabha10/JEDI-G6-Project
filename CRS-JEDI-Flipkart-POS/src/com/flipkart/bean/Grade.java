package com.flipkart.bean;

public class Grade {
	private int numericGrade;

	/**
	 * default constructor
	 */
	public Grade() {
		this.numericGrade=0;
	}
	
	/**
	 * Parameterized Constructor
	 * @param grade
	 */
	public Grade(int grade) {
		super();
		this.numericGrade = grade;
	}
	
	/**
	 * Method to get Numerical Grade
	 * @return Numerical Grade
	 */
	public int getNumericGrade() {
		return numericGrade;
	}
	
	/**
	 * Method to set Numerical Grade
	 * @param numericGrade
	 */
	public void setNumericGrade(int numericGrade) {
		this.numericGrade = numericGrade;
	}
}
