package controller;

import entity.bike.Bike;
import entity.card.CreditCard;
import entity.dock.Dock;
import entity.transaction.PaymentTransaction;
import entity.invoice.RentBikeInvoice;
import entity.DAO.RentBikeInvoiceDAO;
import subsystem.interbank.IInterbank;
import subsystem.interbank.Interbank;
import util.*;
import java.util.ArrayList;


public class RentBikeController {
	
	public static String rentalCode = null;

	public static int rentalCounter = 0;

	public static String processRentBike(CreditCard _card, Bike _bike) throws RuntimeException {
		System.out.println("Processing transaction");
		if (CardController.checkCardInUse(_card.getCardNumber())) {
			HandleException.getException(Constants.IS_USE);
			return Constants.IS_USE;
		}

		LocalDateTime date = LocalDateTime.now();

		rentalCode = convertBikeCodeToRentalCode(_bike.getBikeID());
		int deposit = _bike.calculateDeposit();
		IInterbank interbank = new Interbank();
		String code = interbank.processTransaction(_card, deposit, "Transaction for a rent", date.format(TimeManager.formatDayTime),
				Constants.PAY);

		if (code.equals(Constants.SUCCESS)) {
			updateRentBikeStatus(_card, _bike, deposit, date, null);
		} else {
			HandleException.getException(code);
		}
		return code;
	}

	private static void updateRentBikeStatus(CreditCard _card, Bike _bike, int _amount, LocalDateTime _rentStamp,
			String _returnStamp) {
		RentBikeInvoice rentBikeInvoice = new RentBikeInvoice(rentalCode, _bike.getBikeID(), _bike.getType().name(),
				_card.getOwner(), _rentStamp.format(TimeManager.formatDayTime), _amount);

		rentBikeInvoice.saveRentBikeInvoice();

		PaymentTransaction paymentTransaction = new PaymentTransaction(rentalCode, _card.getCardNumber(),
				_card.getOwner(),
				Constants.RENT_MESSAGE, _amount, _rentStamp.format(TimeManager.formatDayTime));
		paymentTransaction.savePaymentTransaction();

		_bike.updateStatus(true, _bike.getDockID());
		Dock.updateRemainCapacity(_bike.getDockID(), "1");
	}

	public static String convertBikeCodeToRentalCode(int _bikeID) {
		return _bikeID + String.valueOf(rentalCounter++);
	}

	public static RentBikeInvoice getRentBikeInvoice(String _rentalCode) {
		ArrayList<ArrayList<String>> rentBikeInvoice = RentBikeInvoiceDAO.queryByRentalCode(_rentalCode);
		assert rentBikeInvoice.size() == 1;

		ArrayList<String> s = rentBikeInvoice.get(0);
		int bikeCode = Integer.parseInt(s.get(1));
		String bikeType = s.get(2);
		String owner = s.get(4);
		String rentTime = s.get(5);
		int deposit = Integer.parseInt(s.get(7));

		return new RentBikeInvoice(rentalCode, bikeCode, bikeType, owner, rentTime, deposit);
	}
}
