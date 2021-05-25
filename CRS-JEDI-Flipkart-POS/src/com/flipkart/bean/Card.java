/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Card extends Online{
	private String CardType;
	private Integer CardNumber;

	public Card() {
		CardType = "default";
		CardNumber = "0000-0000-0000";
	}
	public Card(String cardType, Integer cardNumber) {
		super();
		CardType = cardType;
		CardNumber = cardNumber;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	
	public Integer getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		CardNumber = cardNumber;
	}
}
