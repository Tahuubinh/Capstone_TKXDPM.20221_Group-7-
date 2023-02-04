package controller;

import entity.DAO.PaymentTransactionDAO;

public class CardController {
	
	public static boolean checkCardInUse(String _cardCode) {
		return PaymentTransactionDAO.checkCardInUse(_cardCode);
	}

	public static boolean validateCardInfo(String _cardCode, String _owner, String _ccvCode, String _expiredDate) {
		return (validateCardCode(_cardCode) && validateOwner(_owner) && validateCcvCode(_ccvCode) && validateExpiredDate(_expiredDate));
	}

	private static boolean validateCardCode(String _cardCode) {
		return _cardCode == 16 && _cardCode.matches("[0-9]+");
	}

	private static boolean validateOwner(String _owner) {
		return (!(_owner == null)) && _owner.matches("[a-zA-Z]+");
	}

	private static boolean validateCcvCode(String _cvvCode) {
		return _cvvCode.length() == 3 && _cvvCode.matches("[0-9]+");
	}

	private static boolean validateExpiredDate(String _expiredDate) {
		return _expiredDate.length() == 4 && _expiredDate.matches("[0-9]+") && !checkExpiredDate(_expiredDate);
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
