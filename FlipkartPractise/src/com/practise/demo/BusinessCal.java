package com.practise.demo;

public class BusinessCal {
//	define 4 methods here
// 3 types of modifier which would be applicable @ method level / @properties
	
//	below 4 are non-static method
	public int add(int a , int b) {
		return a+b;
		
	}
	public int sub(int a , int b) {
		return a-b;
		
	}
	public int mul(int a , int b) {
		return a*b;
		
	}
	public int div(int a , int b) {
		return a/b;
		
	}
//	static method - always classed by class name
	public static String test(String name) {
		return name;
		
	}

}
