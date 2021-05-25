/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */
public class DemoException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = 10,b=5,c,d=0;
		try
		{
			c=a/d;
			c = a/b;
			System.out.println(c);
			
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Not possible to divide by 0"+ex.getMessage());
		}
		finally {
//			we can close connection object,  prepaid statement object or custom object inside the finally block
			System.out.println("Program ends");
		}
		
	}

}
