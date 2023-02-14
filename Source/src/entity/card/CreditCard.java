package entity.card;

import java.util.ArrayList;


public class CreditCard extends Card{
	
	public CreditCard(String cardCode, String owner, String cvv, String expiredDate, int remain) {
		super(cardCode, owner, cvv, expiredDate, remain);
	}
	
	public static void changeRemain(String cardcode, int remain) {
		CardDAO.updateStatus(cardcode, remain);
	}
	
	public static ArrayList<ArrayList<String>> getRemain(String cardcode, String owner) {
		return CardDAO.checkCard(cardcode, owner);
	}
}
