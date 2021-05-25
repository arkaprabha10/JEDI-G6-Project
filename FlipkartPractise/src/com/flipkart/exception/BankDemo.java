/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */
public class BankDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CheckingAccountClass c = new CheckingAccountClass(101);
	      System.out.println("Depositing $500...");
	      c.deposit(500.00);
	      try
	      {
	         System.out.println("\nWithdrawing $100...");
	         c.withdraw(100.00);
	         System.out.println("\nWithdrawing $600...");
	         c.withdraw(600.00);
	      }catch(InsufficientFundException e)
	      {
	         System.out.println("Sorry, but you are short $"
	                                  + e.getAmount());
	        // e.printStackTrace();
	      }
	    }
	}


