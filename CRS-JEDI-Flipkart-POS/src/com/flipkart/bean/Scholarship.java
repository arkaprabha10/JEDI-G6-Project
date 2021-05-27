/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 * Scholarship Class
 *
 */
public class Scholarship extends Payment {
	private String scholarshipName;

	/**
	 * Default Constructor
	 */
	public Scholarship() {
		// TODO Auto-generated constructor stub
	scholarshipName = "Default";
	}
	
	/**
	 * Parameterized Constructor
	 * @param scholarshipName
	 */
	public Scholarship(String scholarshipName) {
		super();
		this.scholarshipName = scholarshipName;
	}
	
}
