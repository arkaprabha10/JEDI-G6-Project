/**
 * 
 */
package com.flipkart.dao;

import java.util.HashMap;

/**
 * @author Asus
 *
 */
public class ReportCardDaoOperation implements ReportCardDaoInterface {

	@Override
	public ReportCardDaoInterface addGrade(int studentId, int semesterId, int courseId, int grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getSPI(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Integer> viewGrades(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Integer> viewCourseGrade(int studentId, int semesterId, int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean makeVisible(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

}
