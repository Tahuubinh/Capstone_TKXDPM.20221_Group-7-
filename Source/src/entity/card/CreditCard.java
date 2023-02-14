package entity.card;

import java.util.ArrayList;


public class CreditCard extends Card{
	/**
	 * static variable holds the card
	 */
	private static Card card = new CreditCard("kstn", "Group 7", "6187", "1234", 100000000);
	
	public CreditCard(String cardCode, String owner, String cvv, String expiredDate, int remain) {
		super(cardCode, owner, cvv, expiredDate, remain);
	}
	
	public static void changeRemain(String cardcode, int remain) {
		CreditcardDAO.updateStatus(cardcode, remain);
	}
	
	public static ArrayList<ArrayList<String>> getRemain(String cardcode) {
		return CreditcardDAO.checkRemain(cardcode);
	}
}