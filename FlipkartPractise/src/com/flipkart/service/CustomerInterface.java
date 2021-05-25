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
	public void listCustomer(Customer customerObj[],Integer currIndex);
	public Integer deleteCustomer(Integer id,Customer customerObj[],Integer currIndex);
	public boolean updateCustomer(Integer id,Integer newID,Customer customerObj[],Integer currIndex);
	public Integer createCustomer(Customer customerObj[], Integer id, String name, String add,Integer currIndex);
	
}
