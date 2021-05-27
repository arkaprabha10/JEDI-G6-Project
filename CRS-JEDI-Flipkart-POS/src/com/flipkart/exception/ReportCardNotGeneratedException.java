package com.flipkart.exception;

/**
 * 
 * @author Jayanth
 * Exception arises when ReportCard is called and Report Card is not Generated.
 */

public class ReportCardNotGeneratedException extends Exception {
	/**
	 * Message to return when exception is thrown
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Report Card Not Generated !";
	}
}
