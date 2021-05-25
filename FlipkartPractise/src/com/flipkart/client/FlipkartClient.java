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
	
<<<<<<< HEAD
//		ArrayList<Customer> customerObj = new ArrayList<Customer>();
		Customer[] customerObj = new Customer[20];
		
		customerObj[0]=new Customer(1,"Arka","India");
		customerObj[1]=new Customer(2,"Mikkel","Germany");
		customerObj[2]=new Customer(3,"Luke","Tattoine");
		
		
//		customerObj.add(new Customer(1,"Arka","India"));
//		customerObj.add(new Customer(2,"Mikkel","Germany"));
//		customerObj.add(new Customer(3,"Luke","Tattoine"));
		Scanner in = new Scanner(System.in);
		
		CustomerImpl ci = new CustomerImpl();
		Integer choice = 0,currIndex=2;
=======
		Customer[] customers = new Customer[100];
		int lastIndex = 0;
		
		CustomerOperation ci = new CustomerOperation();
		
		Scanner in = new Scanner(System.in);
		Integer choice = 0;
		
>>>>>>> 92baaf33e6f1bbc53b223c2ee51e7f31dbc2b181
		while(choice!=5)
		{
			System.out.println("Press 1 to Create Customer \nPress 2 to View Customers \nPress 3 to Update Address \nPress 4 to Delete Customer \nPress any other number to exit ");
			choice = in.nextInt();
			
			if(choice.equals(1))
			{
				System.out.println("Enter Name : "); 
				String name = in.next();
				System.out.println("Enter Address : "); 
<<<<<<< HEAD
				String add = in.nextLine();
				currIndex =  ci.createCustomer(customerObj,id,name,add,currIndex);
//				customerObj.add(new Customer(id,name,add));
=======
				String address = in.next();
>>>>>>> 92baaf33e6f1bbc53b223c2ee51e7f31dbc2b181
				
				lastIndex = ci.createCustomer(name, address, lastIndex, customers);	
				System.out.println("-----------------------------------------------------");
			}
			else if(choice.equals(2) )
			{
<<<<<<< HEAD
				ci.listCustomer(customerObj,currIndex);
//				for (Customer c: customerObj)
//					System.out.println("Customer ID = "+c.getCustomerid() +" ,Customer name = "+c.getCustname() + " ,Customer address = "+c.getCustaddres());
//				
=======
				ci.listCustomer(lastIndex, customers);
				System.out.println("-----------------------------------------------------");
>>>>>>> 92baaf33e6f1bbc53b223c2ee51e7f31dbc2b181
			}
			else if(choice.equals(3))
			{
				System.out.print("Enter ID : "); 
				Integer id = in.nextInt();
<<<<<<< HEAD
				System.out.println("Enter new ID : "); 
				Integer newID = in.nextInt();
				ci.updateCustomer(id,newID, customerObj,currIndex);
//				System.out.println("Enter old ID : "); 
//				Integer id = in.nextInt();
//				System.out.println("Enter new ID : "); 
//				Integer newID = in.nextInt();
//				Boolean found = false;
//				for (Customer c: customerObj)
//				{
//					if(c.getCustomerid().equals(id))
//					{
//						c.setCustomerid(newID);
//						found = true;
//					}
//						
//				}
//				if (found.equals(true))
//					System.out.println("Element Updated");
//				else
//					System.out.println("Element Not found");
=======
				System.out.print("Enter Adress : "); 
				String newAddress = in.next();
				
				ci.updateCustomerAddress(id, newAddress, lastIndex, customers);
				System.out.println("-----------------------------------------------------");
>>>>>>> 92baaf33e6f1bbc53b223c2ee51e7f31dbc2b181
			}
			else if(choice.equals(4))
			{
				System.out.print("Enter ID : "); 
				Integer id = in.nextInt();
<<<<<<< HEAD
				currIndex = ci.deleteCustomer(id, customerObj,currIndex);
				System.out.println(currIndex);
//				Boolean found = false;
//				Integer counter = 0;
//				for (Customer c: customerObj)
//				{
//					if(c.getCustomerid().equals(id))
//					{
//						found = true;
//						break;
//					}
//					counter++;
//						
//				}
//				if (found.equals(true))
//				{	
//					customerObj.remove((int)counter);
//					System.out.println("Element Deleted");
//					
//				}
//				else
//					System.out.println("Element Not found");
=======
				
				lastIndex = ci.deleteCustomer(id, lastIndex, customers);
				System.out.println("-----------------------------------------------------");
>>>>>>> 92baaf33e6f1bbc53b223c2ee51e7f31dbc2b181
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
