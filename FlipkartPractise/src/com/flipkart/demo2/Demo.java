/**
 * 
 */
package com.flipkart.demo2;

import com.practise.demo.BusinessCal;

/**
 * @author Dell
 *
 */
// if final class A then B extends A and similar is not possible , i.e it cant be inherited.

class A
{	
	float a = 10;
	public void test()
	{
		System.out.println("Hello Parent :");
	}
}

class B extends A
{
	float b = 20;
}

class C extends A
{
	float c = 30;
}

class D extends C
{
	float d = 40;
}
public class Demo extends D {

	/**
	 * @param args
	 */
//	main without static wont work as java app
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out is like print statement in java similar to cout in c++
//		 system is a class and out is an object and println is a method

		//		System.out.println("Hello there, obi-wan kenobi");
//		create object
		
//		BusinessCal cal = new BusinessCal();
//		System.out.println("Addition : " + cal.add(3, 2));
//		System.out.println("Subtraction : " + cal.sub(3, 2));
//		System.out.println("Multiplication : " + cal.mul(3, 2));
//		System.out.println("Divide : " + cal.div(3, 2));
//		System.out.println("Name : " + BusinessCal.test("darth maul"));
//		due to inbuilt java error even object can call static method with warning.

//		start inheritance
		
//		Demo demo = new Demo();
//		System.out.println("demo a = " + demo.a);
//		System.out.println("demo c = " + demo.c);
//		System.out.println("demo d = " + demo.d);
//		
//		B new_b = new B();
//		System.out.println("B a = " +  new_b.a);
//		System.out.println("B b = " + new_b.b);
//		
	
		
	}

}
