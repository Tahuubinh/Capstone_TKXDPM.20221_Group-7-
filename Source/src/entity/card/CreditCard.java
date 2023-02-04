package entity.card;

public class CreditCard {
	// card info
	private static CreditCard card = new CreditCard("9999999999999999", "Nghiem Viet Thang", "666", "1029");

	// card number
	private String cardNumber;

	// card owner
	private String owner;

	// ccv
	private String cvv;

	// expire date
	private String expiredDate;

	/**
	 * constructor
	 * 
	 * @param _cardNumber
	 * @param _owner
	 * @param _cvv
	 * @param _expiredDate
	 */
	public CreditCard(String _cardNumber, String _owner, String _cvv, String _expiredDate) {
		this.cardNumber = _cardNumber;
		this.owner = _owner;
		this.cvv = _cvv;
		this.expiredDate = _expiredDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String _cardNumber) {
		this.cardNumber = _cardNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String _owner) {
		this.owner = _owner;
	}

	public String getCVV() {
		return cvv;
	}

	public void setCVV(String _cvv) {
		this.cvv = _cvv;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String _expiredDate) {
		this.expiredDate = _expiredDate;
	}

	public static CreditCard getCard() {
		return card;
	}
}
