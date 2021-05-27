/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Offline extends Payment{
	private String cashier;
	private String branch;
	private String transactionType;

	/**
	 * Default constructor
	 */
	public Offline() {
		cashier = "null";
		branch = "null";
		transactionType = "null";
	}
	
	/**
	 * Parameterized Constructor
	 * @param cashier
	 * @param branch
	 * @param transactionType
	 */
	public Offline(String cashier, String branch, String transactionType) {
		super();
		this.cashier = cashier;
		this.branch = branch;
		this.transactionType = transactionType;
	}
	
	/**
	 * Method to get Cashier
	 * @return cashier
	 */
	public String getCashier() {
		return cashier;
	}
	
	/**
	 * Method to set cashier
	 * @param cashier
	 */
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	
	/**
	 * Method to get branch name
	 * @return
	 */
	public String getBranch() {
		return branch;
	}
	
	/**
	 * Method to set branch name
	 * @param branch
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	/**
	 * Method to get transactionType
	 * @return transaction Type
	 */
	public String getTransactionType() {
		return transactionType;
	}
	
	/**
	 * Method to set transactionType
	 * @param transactionType
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	

}
