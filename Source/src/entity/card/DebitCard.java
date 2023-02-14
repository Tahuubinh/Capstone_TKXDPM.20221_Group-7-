package entity.card;

import java.util.ArrayList;


public class DebitCard extends Card{

    /**
	 * start date
	 */
	private String startDate;
	/**
	 * static variable holds the card
	 */
	private static DebitCard card = new DebitCard("kstn", "Group 7", "6187","1221", "1234", 100000000);
	
	public DebitCard(String cardCode, String owner, String cvv,String startDate, String expiredDate, int remain) {
		super(cardCode, owner, cvv, expiredDate, remain);
        this.startDate = startDate;

	}

    public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public static void changeRemain(String cardcode, int remain) {
		// DebitcardDAO.updateStatus(cardcode, remain);
	}
	
	public ArrayList<ArrayList<String>> getRemain(String cardcode) {
		return null;
		// return DebitcardDAO.checkRemain(cardcode);
	}
}