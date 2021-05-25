/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Customer;

/**
 * @author Dell
 *
 */
public class CustomerOperation implements CustomerInterface {

	@Override
	public void listCustomer(Integer lastIndex, Customer[] customers) {
		System.out.println("Customer List:\n");
		for(int i = 0; i < lastIndex; i++)
		{
			System.out.println("Customer ID = "+ customers[i].getCustomerID() +", Customer name = "+ customers[i].getCustomerName() + ", Customer address = "+ customers[i].getCustomerAddress());
		}
		
	}

	@Override
	public int deleteCustomer(Integer id, Integer lastIndex, Customer[] customers) {
		
		for(int i = 0; i < lastIndex; i++)
		{
			if(customers[i].getCustomerID() == id)
			{
				while(i < lastIndex-1)
				{
					customers[i] = customers[i+1];
					i++;
				}
				
				System.out.println("Customer Deleted!");
				return lastIndex-1;
			}
		}
		
		System.out.println("No Such Customer Found!");
		return lastIndex;
		
	}

	@Override
	public void updateCustomerAddress(Integer id, String newAddress, Integer lastIndex, Customer[] customers) {
		for(int i = 0; i < lastIndex; i++)
		{
			if(customers[i].getCustomerID() == id)
			{
				customers[i].setCustomerAddress(newAddress);
				System.out.println("Customer Updated!");
				return;
			}
		}
		
		System.out.println("No Such Customer Found!");
		return;
		
	}

	@Override
	public int createCustomer(String name, String address, Integer lastIndex, Customer[] customers) {
		
		Customer newCust = new Customer(lastIndex+1, name, address);
		customers[lastIndex] = newCust;
		
		System.out.println("Customer Created!");
		return lastIndex+1;
	}

}
