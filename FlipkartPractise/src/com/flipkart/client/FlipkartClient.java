/**
 * 
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.service.CustomerOperation;

/**
 * @author Dell
 *
 */
public class FlipkartClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Customer[] customers = new Customer[100];
		int lastIndex = 0;
		
		CustomerOperation ci = new CustomerOperation();
		
		Scanner in = new Scanner(System.in);
		Integer choice = 0;
		
		while(choice!=5)
		{
			System.out.println("Press 1 to Create Customer \nPress 2 to View Customers \nPress 3 to Update Address \nPress 4 to Delete Customer \nPress any other number to exit ");
			choice = in.nextInt();
			
			if(choice.equals(1))
			{
				System.out.println("Enter Name : "); 
				String name = in.next();
				System.out.println("Enter Address : "); 
				String address = in.next();
				
				lastIndex = ci.createCustomer(name, address, lastIndex, customers);	
				System.out.println("-----------------------------------------------------");
			}
			else if(choice.equals(2) )
			{
				ci.listCustomer(lastIndex, customers);
				System.out.println("-----------------------------------------------------");
			}
			else if(choice.equals(3))
			{
				System.out.print("Enter ID : "); 
				Integer id = in.nextInt();
				System.out.print("Enter Adress : "); 
				String newAddress = in.next();
				
				ci.updateCustomerAddress(id, newAddress, lastIndex, customers);
				System.out.println("-----------------------------------------------------");
			}
			else if(choice.equals(4))
			{
				System.out.print("Enter ID : "); 
				Integer id = in.nextInt();
				
				lastIndex = ci.deleteCustomer(id, lastIndex, customers);
				System.out.println("-----------------------------------------------------");
			}
			else 
			{
				System.out.println("Exiting...");
				System.out.println("-----------------------------------------------------");
				break;
			}
		}
		
		in.close();		
		System.out.println("Thank you for using the portal");
		System.out.println("-----------------------------------------------------");
	}

}
