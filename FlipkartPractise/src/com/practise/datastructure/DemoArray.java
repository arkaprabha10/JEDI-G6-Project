/**
 * 
 */
package com.practise.datastructure;

import com.practise.bean.Customer;

/**
 * @author Dell
 *
 */
public class DemoArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// datatype array
		// this is a basic loop
		int arrayOfInt[] = new int[] {2, 3, 5};
	       for (int i = 0; i < arrayOfInt.length; i++) {
	        System.out.println("The " + i + " element has value  : " + arrayOfInt[i]);
	       }
	    
	    // java 8 for each loop
	    for(int i:arrayOfInt)  
	   		System.out.println(i);
 
	    //Most of the primitive datatype has to be referred in the form of wrapper classes.
	    // for eg int -> Integer()
//	    		  float -> Float
	    
	    String names[] = new String[] {"Shakir", "Priyanka", "Sumeet"};
	       
	       for (int i = 0; i < names.length; i++) {
	         System.out.println("The " + i + " name is : " + names[i]);
	       }
	       for (String i:names)
	    	   System.out.println(i);
	       	
	     // Creating a custom class array
	       Customer myCustomers[] = new Customer[] {new Customer(), new Customer(), new Customer()};
	       
	       myCustomers[0].setCustomerid(100);
	       myCustomers[0].setCustname("IBM 0");
	       myCustomers[0].setCustaddres("Address 0");
	       
	       myCustomers[1].setCustomerid(101);
	       myCustomers[1].setCustname("IBM 1");
	       myCustomers[1].setCustaddres("Address 1");
	       
	       myCustomers[2].setCustomerid(102);
	       myCustomers[2].setCustname("IBM2");
	       myCustomers[2].setCustaddres("Address 2");
	       
	       for (int i = 0; i < 3; i++) {
	           
	           System.out.println("The id of " + i + " Customer is :" + myCustomers[i].getCustomerid() + " and name is : " + myCustomers[i].getCustname());
	           
	          }
	       for (Customer cust:myCustomers)
	    	   System.out.println(" Customer is :" + cust.getCustomerid() + " and name is : " + cust.getCustname());     
	       
	}
	
}
