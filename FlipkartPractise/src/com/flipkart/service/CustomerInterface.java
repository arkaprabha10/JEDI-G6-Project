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
public interface CustomerInterface {
	public void listCustomer(ArrayList<Customer> customerObj);
	public boolean deleteCustomer(Integer id,ArrayList<Customer> customerObj);
	public boolean updateCustomer(Integer id,Integer newID,ArrayList<Customer> customerObj);
	public void createCustomer(ArrayList<Customer> customerObj, Integer id, String name, String add);
	
}
