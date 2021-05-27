/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 * Netbanking class
 */
public class NetBanking extends Online {
	private String bank;
	private String accountNumber;

	/**
	 * Default Constructor
	 */
	public NetBanking() {
		this.bank="abc";
		this.accountNumber="1231231231232";
	}
	
	/**
	 * Method to get Numerical Grade
	 * @param bank
	 * @param accountNumber
	 */
	public NetBanking(String bank, String accountNumber) {
		super();
		this.bank = bank;
		this.accountNumber = accountNumber;
	}
	
	/**
	 * Method to get Bank name
	 * @return bank name
	 */
	public String getBank() {
		return bank;
	}
	
	/**
	 * Method to set bank name
	 * @param bank
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	/**
	 * Method to get Account Number
	 * @return account Number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Method to set AccountNumber
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
