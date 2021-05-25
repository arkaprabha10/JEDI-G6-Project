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
	public void createCustomer(ArrayList<Customer> customerObj,Integer id,String name,String add) {
		// TODO Auto-generated method stub
		customerObj.add(new Customer(id,name,add));
		System.out.println("Create");
		
	}

	@Override
	public void listCustomer(ArrayList<Customer> customerObj) {
		// TODO Auto-generated method stub
		System.out.println("List");
		for (Customer c: customerObj)
			System.out.println("Customer ID = "+c.getCustomerid() +" ,Customer name = "+c.getCustname() + " ,Customer address = "+c.getCustaddres());
		
	}

	@Override
	public boolean deleteCustomer(Integer id,ArrayList<Customer> customerObj) {
		// TODO Auto-generated method stub
		System.out.println("Delete");
		Boolean found = false;
		Integer counter = 0;
		for (Customer c: customerObj)
		{
			if(c.getCustomerid().equals(id))
			{
				found = true;
				break;
			}
			counter++;
				
		}
		if (found.equals(true))
		{	
			customerObj.remove((int)counter);
			System.out.println("Element Deleted");
			
		}
		else
			System.out.println("Element Not found");
		return true;
	}

	@Override
	public boolean updateCustomer(Integer id,Integer newID,ArrayList<Customer> customerObj) {
		// TODO Auto-generated method stub
		Boolean found = false;
		for (Customer c: customerObj)
		{
			if(c.getCustomerid().equals(id))
			{
				c.setCustomerid(newID);
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
