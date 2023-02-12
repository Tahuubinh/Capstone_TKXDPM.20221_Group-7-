package controller;

import util.TimeManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import entity.transaction.PaymentTransactionDAO;

public class CardController {
	
	public static boolean checkCardInUse(String _cardCode) {
		return PaymentTransactionDAO.checkCardInUse(_cardCode);
	}

	public static boolean validateCardInfo(String _cardCode, String _owner, String _ccvCode, String _expiredDate) {
		return (validateCardCode(_cardCode) && validateOwner(_owner) && validateCcvCode(_ccvCode) && validateExpiredDate(_expiredDate));
	}

	public static boolean validateCardCode(String _cardCode) {
		return _cardCode != null && _cardCode.length() == 16 && _cardCode.matches("[0-9]+");
	}

	public static boolean validateOwner(String _owner) {
		return (!(_owner == null)) && _owner.matches("[a-zA-Z\\s]+");
	}

	public static boolean validateCcvCode(String _cvvCode) {
		return _cvvCode != null && _cvvCode.length() == 3 && _cvvCode.matches("[0-9]+");
	}

	public static boolean validateExpiredDate(String _expiredDate) {
		return _expiredDate != null && _expiredDate.length() == 4 && _expiredDate.matches("[0-9]+") && !checkExpiredDate(_expiredDate);
	}

	private static boolean checkExpiredDate(String _expiredDate) {
		StringBuffer date = new StringBuffer(_expiredDate);
		date.insert(2, "-20");
		LocalDateTime currentDate = LocalDateTime.now();
		try {
			LocalDateTime expiredDate = LocalDateTime.parse(date.toString(), TimeManager.formatMMYY);
			return TimeManager.getTimeDiff(currentDate, expiredDate) > 0;
		} catch(DateTimeParseException e) {
			return false;
		}
	}
}
