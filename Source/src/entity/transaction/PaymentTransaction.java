package entity.transaction;

import util.TimeManager;

import java.time.LocalDateTime;
import entity.card.CreditCard;

public class PaymentTransaction {

	// rental code
	private String rentalCode;

	// card code
	private String cardNumber;

	// owner
	private String owner;

	// transaction content
	private String transactionContent;

	// amount
	private int amount;

	// date
	private LocalDateTime daytime;

	/**
	 * constructor
	 * 
	 * @param _rentalCode
	 * @param _cardNumber
	 * @param _owner
	 * @param _transactionContent
	 * @param _amount
	 * @param _daytime
	 */
	public PaymentTransaction(String _rentalCode, String _cardNumber, String _owner, String _transactionContent, int _amount,
			LocalDateTime _daytime) {
		this.rentalCode = _rentalCode;
		this.cardNumber = _cardNumber;
		this.owner = _owner;
		this.transactionContent = _transactionContent;
		this.amount = _amount;
		this.daytime = _daytime;
	}

	/**
	 * save payment transaction in database
	 */
	public void savePaymentTransaction() {
		PaymentTransactionDAO.save(rentalCode, cardNumber, owner, transactionContent, amount, daytime.format(TimeManager.formatDayTime));
	}
}
