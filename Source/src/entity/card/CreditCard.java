package entity.card;

import java.util.ArrayList;


public class CreditCard extends Card{
	
	public CreditCard(String cardCode, String owner, String cvv, String expiredDate, int remain) {
		super(cardCode, owner, cvv, expiredDate, remain);
	}
	
	public static void changeRemain(String cardcode, int remain) {
		CardDAO.updateStatus(cardcode, remain);
	}
	
	public static ArrayList<ArrayList<String>> getRemain(String cardcode) {
		return CardDAO.checkRemain(cardcode);
	}
	
	public static ArrayList<ArrayList<String>> checkCard(String cardcode, String owner) {
		ArrayList<ArrayList<String>> s = new ArrayList<>();
		String command = "SELECT creditcard.remain FROM creditcard" + " WHERE cardcode = '" + cardcode + "' && owner = '" + owner + "'";
		s = DBConnection.query(command);
		return s;
	}
}
