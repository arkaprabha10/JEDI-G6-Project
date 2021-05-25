/**
 * 
 */
package com.flipkart.exception;

/**
 * @author lenovo
 *
 */
public class DemoException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int a = 10 , b =0,c;
			c = a/5;
			System.out.println(c);
		}
		catch(ArithmeticException ex) {
			System.out.println("It is not possible to divide by zero " + ex.getMessage());
		}
		finally {
			// we can close the connection object , prepaid statements objects , custom objects inside the final
			System.out.println("Program ends");
		}
		

	}

}
