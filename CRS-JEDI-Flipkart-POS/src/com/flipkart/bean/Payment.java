/**
 * 
 */
package com.flipkart.bean;

import javax.print.DocFlavor.INPUT_STREAM;

/**
 * @author Dell
 * payment Class
 *
 */
public class Payment {
	
	private Integer paymentID;
	private Integer amount;
	private Integer studentID;
	private Boolean paymentStatus;
	private String paymentMode;

	/**
	 * Default Constructor
	 */
	public Payment() {
		paymentID=null;
		amount=0;
		studentID=0;
		paymentStatus=false;
		paymentMode=null;
	}
	
	/**
	 * parameterized Constructor
	 * @param paymentID
	 * @param amount
	 * @param studentID
	 * @param paymentStatus
	 * @param paymentMode
	 */
	public Payment(Integer paymentID, Integer amount, Integer studentID, Boolean paymentStatus, String paymentMode) {
		super();
		this.paymentID = paymentID;
		this.amount = amount;
		this.studentID = studentID;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
	}
	
	/**
	 * Method to getPaymentID
	 * @return paymentId
	 */
	public Integer getPaymentID() {
		return paymentID;
	}
	
	/**
	 * Method to set PaymentID
	 * @param paymentID
	 */
	public void setPaymentID(Integer paymentID) {
		this.paymentID = paymentID;
	}
	
	/**
	 * Method to get amount 
	 * @return amount
	 */
	public Integer getAmount() {
		return amount;
	}
	
	/**
	 * Method to set amount
	 * @param amount
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	/**
	 * method to getStudentID
	 * @return
	 */
	public Integer getStudentID() {
		return studentID;
	}
	
	/**
	 * Method to set StudentID
	 * @param studentID
	 */
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * Method to get payment status
	 * @return true of payment is done or false
	 */
	public Boolean getPaymentStatus() {
		return paymentStatus;
	}
	
	/**
	 * Method to setPayment status
	 * @param paymentStatus
	 */
	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	/**
	 * Method to get PaymentMode
	 * @return payment mode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	
	/**
	 * Method to setPayment Mode
	 * @param paymentMode
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
}
