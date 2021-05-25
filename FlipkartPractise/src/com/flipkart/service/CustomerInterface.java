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
<<<<<<< HEAD
	public void listCustomer(Customer customerObj[],Integer currIndex);
	public Integer deleteCustomer(Integer id,Customer customerObj[],Integer currIndex);
	public boolean updateCustomer(Integer id,Integer newID,Customer customerObj[],Integer currIndex);
	public Integer createCustomer(Customer customerObj[], Integer id, String name, String add,Integer currIndex);
=======
	
	public void listCustomer(Integer lasIndex, Customer[] customers);
	public int deleteCustomer(Integer id, Integer lastIndex, Customer[] customers);
	public void updateCustomerAddress(Integer id, String newAddress, Integer lastIndex, Customer[] customers);
	public int createCustomer(String name, String address, Integer lastIndex, Customer[] customers);
>>>>>>> 92baaf33e6f1bbc53b223c2ee51e7f31dbc2b181
	
}
