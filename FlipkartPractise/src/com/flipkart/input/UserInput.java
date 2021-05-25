/**
 * 
 */
package com.flipkart.input;

import java.util.Scanner;

/**
 * @author Dell
 *
 */
public class UserInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner in = new Scanner(System.in);
	System.out.println("Enter the name");
	String name = in.nextLine();
	System.out.println(name);
	in.close();
	
	}

}
