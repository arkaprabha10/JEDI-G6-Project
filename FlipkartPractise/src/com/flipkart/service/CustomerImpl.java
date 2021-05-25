/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Customer;

/**
 * @author Dell
 *
 */
public class CustomerImpl implements CustomerInterface {

	@Override
	public Integer createCustomer(Customer customerObj[], Integer id, String name, String add,Integer currIndex) {
		// TODO Auto-generated method stub
		if(currIndex>20)
			System.out.println("Limit Exceeded");
		else
		{	currIndex = currIndex+1;
			customerObj[currIndex] = new Customer(id,name,add);
//			customerObj.add(new Customer(id,name,add));
			System.out.println("Created");
			
		}
		return currIndex;
		
	}

	@Override
	public void listCustomer(Customer customerObj[],Integer currIndex) {
		// TODO Auto-generated method stub
		System.out.println("List");
		for (int i=0;i<=currIndex;i++)
			System.out.println("Customer ID = "+customerObj[i].getCustomerid() +" ,Customer name = "+customerObj[i].getCustname() + " ,Customer address = "+customerObj[i].getCustaddres());
//		for (Customer c: customerObj)
//			System.out.println("Customer ID = "+c.getCustomerid() +" ,Customer name = "+c.getCustname() + " ,Customer address = "+c.getCustaddres());
		
	}

	@Override
	public Integer deleteCustomer(Integer id,Customer customerObj[],Integer currIndex) {
		// TODO Auto-generated method stub
		if(currIndex <0)
			System.out.println("No element");
		else
		{
			System.out.println("Delete");
			Boolean found = false;
			Integer counter = 0;
			for (int i=0;i<=currIndex;i++)
			{
				if(customerObj[i].getCustomerid().equals(id))
				{
					found = true;
					break;
				}
				counter++;
			}
			if (found.equals(true))
			{	
				for (int i=counter;i<currIndex;i++)
					customerObj[i]=customerObj[i+1];
				currIndex--;
				System.out.println("Element Deleted");
				
			}
			else
				System.out.println("Element Not found");
		}
		
		return currIndex;
	}

	@Override
	public boolean updateCustomer(Integer id,Integer newID,Customer customerObj[],Integer currIndex) {
		// TODO Auto-generated method stub
		Boolean found = false;
		
		for (int i=0;i<=currIndex;i++)
		{
			if(customerObj[i].getCustomerid().equals(id))
			{
				customerObj[i].setCustomerid(newID);
				found = true;
			}
				
		}
		if (found.equals(true))
			System.out.println("Element Updated");
		else
			System.out.println("Element Not found");
		return true;
	}

}
