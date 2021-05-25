/**
 * 
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.service.CustomerImpl;
import com.flipkart.service.CustomerInterface;

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
//		CustomerInterface customer = new CustomerImpl();
	
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
		while(choice!=5)
		{
			System.out.println(" Press 1 to Create elements \n Press 2 to View elements \n Press 3 to Update ID \n Press 4 to Delete elements \n Press any other key to exit ");
			 choice = in.nextInt();
			if(choice.equals(1))
			{
				System.out.println("Enter ID : "); 
				Integer id = in.nextInt();
				in.nextLine();
				System.out.println("Enter Name : "); 
				String name = in.nextLine();
				System.out.println("Enter Address : "); 
				String add = in.nextLine();
				currIndex =  ci.createCustomer(customerObj,id,name,add,currIndex);
//				customerObj.add(new Customer(id,name,add));
				
			}
			else if(choice.equals(2) )
			{
				ci.listCustomer(customerObj,currIndex);
//				for (Customer c: customerObj)
//					System.out.println("Customer ID = "+c.getCustomerid() +" ,Customer name = "+c.getCustname() + " ,Customer address = "+c.getCustaddres());
//				
			}
			else if(choice.equals(3))
			{
				System.out.println("Update");
				System.out.println("Enter old ID : "); 
				Integer id = in.nextInt();
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
			}
			else if(choice.equals(4))
			{
				System.out.println("Enter old ID : "); 
				Integer id = in.nextInt();
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
			}
			else 
				{
				System.out.println("Exiting....");
				break;
				}
		}
		in.close();		
		System.out.println("Thank you for using the portal");
	}

}
