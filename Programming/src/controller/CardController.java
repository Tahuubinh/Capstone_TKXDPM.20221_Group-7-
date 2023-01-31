package controller;

import entity.data.PaymentTransactionDAO;


public class CardController {
	
	public static boolean checkCardInUse(String cardCode) {
		return PaymentTransactionDAO.checkCardInUse(cardCode);
	}

	public static boolean validateCardInfo(String carCode, String owner, String ccvCode, String expiredDate) {
		if (validateCardCode(carCode) && validateOwner(owner) && validateCcvCode(ccvCode)
				&& validateExpiredDate(expiredDate)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validateCardCode(String cardCode) {
		if (cardCode == null)
			return false;

		if (!cardCode.matches("[a-z0-9_]+")) {
			return false;
		}
		return true;
	}

	public static boolean validateOwner(String owner) {
		if (owner == null)
			return false;

		if (!owner.matches("[A-Za-z0-9\\s]+")) {
			return false;
		}

		return true;
	}

	public static boolean validateCcvCode(String cvvCode) {
		if (cvvCode == null) {
			return false;
		}
		if (cvvCode.length() != 3) {
			return false;
		}

		if (!cvvCode.matches("[0-9]+")) {
			return false;
		}

		try {
			int code = Integer.parseInt(cvvCode);
			if (0 <= code && code <= 999) {
				return true;
			} else
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean validateExpiredDate(String expiredDate) {
		if (expiredDate == null) {
			return false;
		}

		if (!expiredDate.matches("[0-9]+")) {
			return false;
		}

		if (expiredDate.length() != 4) {
			return false;
		}

		try {
			int expDate = Integer.parseInt(expiredDate);
			if (100 <= expDate && expDate <= 1299) {
				return true;
			} else
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
