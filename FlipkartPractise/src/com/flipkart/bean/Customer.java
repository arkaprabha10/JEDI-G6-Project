/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Customer {
	private Integer Customerid;
	private String custname;
	private String custaddres;
	
	
	/**
	 * @param customerid
	 * @param custname
	 * @param custaddres
	 */
	public Customer(Integer customerid, String custname, String custaddres) {
		super();
		this.Customerid = customerid;
		this.custname = custname;
		this.custaddres = custaddres;
	}
	public Integer getCustomerid() {
		return Customerid;
	}
	public void setCustomerid(Integer customerid) {
		Customerid = customerid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustaddres() {
		return custaddres;
	}
	public void setCustaddres(String custaddres) {
		this.custaddres = custaddres;
	}
}
