/**
 * 
 */
package com.practise.bean;

/**
 * @author Dell
 *
 */
// Simple Java Bean class containing Setter / Getter
public class Customer {
	
	private int Customerid;
	private String custname;
	private String custaddres;
	
	
	/**
	 * @param customerid
	 * @param custname
	 * @param custaddres
	 */
	public Customer(int customerid, String custname, String custaddres) {
		super();
		this.Customerid = customerid;
		this.custname = custname;
		this.custaddres = custaddres;
	}
	public int getCustomerid() {
		return Customerid;
	}
	public void setCustomerid(int customerid) {
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
