/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Customer;

/**
 * @author Dell
 *
 */
public interface CustomerInterface {
	
	public void listCustomer(Integer lasIndex, Customer[] customers);
	public int deleteCustomer(Integer id, Integer lastIndex, Customer[] customers);
	public void updateCustomerAddress(Integer id, String newAddress, Integer lastIndex, Customer[] customers);
	public int createCustomer(String name, String address, Integer lastIndex, Customer[] customers);
	
}
