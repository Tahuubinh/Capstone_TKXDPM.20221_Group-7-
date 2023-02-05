package entity.transaction;

import java.time.LocalDateTime;
import entity.card.CreditCard;
import util.TimeManager;

public class InterbankTransaction {

	// card number
	private String cardNumber;

	// card owner
	private String owner;

	// ccv
	private String cvv;

	// expired Date
	private String expiredDate;

	// command: pay/refund
	private String command;

	// transaction content
	private String transactionContent;

	// amount of transaction
	private double amount;

	// date: yyyy-MM-dd-HH-mm-ss-ns
	private LocalDateTime createdAt;

	/**
	 * constructor
	 * 
	 * @param _card
	 * @param _command
	 * @param _content
	 * @param _amount
	 * @param _createdAt
	 */
	public InterbankTransaction(CreditCard _card, String _command, String _content, int _amount,
			String _createdAt) {
		this.setCardNumber(_card.getCardNumber());
		this.setOwner(_card.getOwner());
		this.setCvv(_card.getCVV());
		this.setExpiredDate(_card.getExpiredDate());
		this.setCommand(_command);
		this.setTransactionContent(_content);
		this.setAmount(_amount);
		this.setCreatedAt(LocalDateTime.parse(_createdAt, TimeManager.formatDayTime));
	}

	public void setCardNumber(String _cardNumber) {
		this.cardNumber = _cardNumber;
	}

	public void setOwner(String _owner) {
		this.owner = _owner;
	}

	public void setCvv(String _cvv) {
		this.cvv = _cvv;
	}

	public void setExpiredDate(String _expiredDate) {
		this.expiredDate = _expiredDate;
	}

	public void setCommand(String _command) {
		this.command = _command;
	}

	public void setTransactionContent(String _transactionContent) {
		this.transactionContent = _transactionContent;
	}

	public void setAmount(double _amount) {
		this.amount = _amount;
	}

	public void setCreatedAt(LocalDateTime _createdAt) {
		this.createdAt = _createdAt;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getOwner() {
		return owner;
	}

	public String getCvvCode() {
		return cvv;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public String getCommand() {
		return command;
	}

	public String getTransactionContent() {
		return transactionContent;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
