package entity.card;

import java.util.ArrayList;


public abstract class Card{
	/**
	 * static variable holds the card
	 */
	private static CreditCard card;
	/**
	 * code of card
	 */
	private String cardCode;
	/**
	 * owner
	 */
	private String owner;
	/**
	 * cvv
	 */
	private String CVV;
	/**
	 * expired date
	 */
	private String expiredDate;
 	/**
	 * remain
	 */   
	private int remain;
	
	
	public Card(String cardCode, String owner, String cvv, String expiredDate, int remain) {
		this.cardCode = cardCode;
		this.owner = owner;
		this.CVV = cvv;
		this.expiredDate = expiredDate;
		this.remain = remain;
	}

	public String getCardCode() {
		return cardCode;
	}
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String CVV) {
		this.CVV = CVV;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public static CreditCard getCard() {
		return card;
	}
	

	public void setRemain(int remain) {
    	this.remain = remain;
	}
	
	//public abstract static void changeRemain(String cardcode, int remain);
	
	// public abstract ArrayList<ArrayList<String>> getRemain(String cardcode);
}