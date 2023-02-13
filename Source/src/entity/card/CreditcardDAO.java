package entity.card;

import java.util.ArrayList;

import entity.DBBinder;

public class CreditcardDAO {

	/**
	 * @return All creditcards
	 */
	public static ArrayList<ArrayList<String>> getCreditcards() {
		ArrayList<ArrayList<String>> s = new ArrayList<>();
		String command = "SELECT * from creditcard";
		s = DBBinder.query(command);
		return s;
	}
	
	// update remain
	
	public static void updateStatus(String cardcode, int change) {
		String command = "UPDATE creditcard SET remain = remain - " + change  + " WHERE cardcode = '" + cardcode + "'";
		DBBinder.execute(command);
	}
	
	// kttk
	
	public static ArrayList<ArrayList<String>> checkRemain(String cardcode) {
		ArrayList<ArrayList<String>> s = new ArrayList<>();
		String command = "SELECT creditcard.remain FROM creditcard" + " WHERE cardcode = '" + cardcode + "'";
		s = DBBinder.query(command);
		return s;
	}

}
