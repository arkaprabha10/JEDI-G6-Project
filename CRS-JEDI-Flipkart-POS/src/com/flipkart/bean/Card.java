/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 * Card Class
 *
 */
public class Card extends Online{
	private String CardType;
	private String CardNumber;

	/**
	 * Default Constructor
	 */
	public Card() {
		CardType = "default";
		CardNumber = "0000-0000-0000";
	}
	
	/**
	 * Parametrized Constructor
	 * @param cardType
	 * @param cardNumber
	 */
	public Card(String cardType, String cardNumber) {
		super();
		CardType = cardType;
		CardNumber = cardNumber;
	}
	
	/**
	 * Method to get CardType
	 * @return CardType
	 */
	public String getCardType() {
		return CardType;
	}
	
	/**
	 * Method to set CardType
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	
	/**
	 * Method to get CardNumber
	 * @return CardNumber
	 */
	public String getCardNumber() {
		return CardNumber;
	}
	
	/**
	 * Method to set CardNumber
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
}
