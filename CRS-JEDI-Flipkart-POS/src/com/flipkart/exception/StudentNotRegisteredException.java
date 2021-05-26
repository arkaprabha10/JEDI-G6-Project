package com.flipkart.exception;

//Exception arises when student details cant be found
public class StudentNotRegisteredException extends Exception {

	@Override
	public String getMessage() {
		return "No such registered student was found";
	}
}
