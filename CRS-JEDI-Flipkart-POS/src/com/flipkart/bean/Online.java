/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 * Online class
 *
 */
public class Online extends Payment{
	private String transactionType;

	/**
	 * Default constructor
	 */
	public Online() {
		transactionType="null";
	}
	
	/**
	 * parameterized constructor
	 * @param transactionType
	 */
	public Online(String transactionType) {
		super();
		this.transactionType = transactionType;
	}
	
	/**
	 * Method to get transactionType
	 * @return TransactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	
	/**
	 * Method to set transaction Type
	 * @param transactionType
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
