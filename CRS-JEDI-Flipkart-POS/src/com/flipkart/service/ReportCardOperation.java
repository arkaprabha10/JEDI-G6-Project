/**
 * 
 */
package com.flipkart.service;

import java.util.HashMap;

import com.flipkart.bean.ReportCard;

/**
 * @author Asus
 * Implementations of ReportCard Operations
 *
 */
public class ReportCardOperation implements ReportCardInterface {

	/**
	 * Method to get student's SPI
	 * @param studentId
	 * @param semesterId
	 * @return spi for that semester and student
	 */
	@Override
	public Float getSPI(ReportCard RC) {
		HashMap<String, Integer> grades = RC.getGrades();
		float sum = 0.0f;
		int num_courses=0;
		for (float g : grades.values()) {
		    sum += g;
		    num_courses++;
		}
		sum=sum/num_courses;
		return sum;
	}

}
