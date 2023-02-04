package controller;

import subsystem.interbank.IInterbank;
import subsystem.interbank.Interbank;
import util.*;
import entity.*;
import javafx.util.Pair;

import java.time.LocalDateTime;

public class ReturnBikeController {

	public static Pair<String, RentBikeInvoice> processReturnBike(String _rentalCode, CreditCard _card, String _newDockID)
			throws RuntimeException {
		
		RentBikeInvoice rentBikeInvoice = RentBikeController.getRentBikeInvoice(_rentalCode);
		Bike bike = DockController.getBikeFromID(rentBikeInvoice.getBikeCode());
		LocalDateTime returnTime = LocalDateTime.now();
		LocalDateTime rentTime = LocalDateTime.parse(rentBikeInvoice.getRentTime(), TimeManager.formatDayTime);
		long diff = TimeManager.getTimeDiff(rentTime, returnTime);
		int duration = (int) Math.ceil((double) diff / 60000);
		int rentCost = bike.caculateRentCost(duration);
		int refundAmount = rentBikeInvoice.getDeposit() - rentCost;
		System.out.println("Refund amount: " + refundAmount);
		assert refundAmount > 0;

		IInterbank interbank = new Interbank();
		String respondCode = interbank.processTransaction(_card, refundAmount, "Refund Transaction",
				returnTime.format(TimeManager.formatDayTime), Constants.REFUND);
		System.out.println("respond code: " + respondCode);

		if (!respondCode.equals(Constants.SUCCESS)) {
			HandleException.getException(respondCode);
			return new Pair<>(respondCode, null);
		} else {
			updateReturnBikeStatus(_card, bike, _newDockID, refundAmount, returnTime.format(TimeManager.formatDayTime), rentBikeInvoice);
		}

		return new Pair<>(respondCode, rentBikeInvoice);
	}

	private static void updateReturnBikeStatus(CreditCard _card, Bike _bike, String _newDockID, int _refundAmount,
			String _returnStamp, RentBikeInvoice _rentBikeInvoice) {

		RentBikeController.rentalCode = null;
		int rentCost = _rentBikeInvoice.getDeposit() - _refundAmount;
		_rentBikeInvoice.updateAfterReturnBike(_returnStamp, rentCost);

		PaymentTransaction paymentTransaction = new PaymentTransaction(_rentBikeInvoice.getRentalCode(),
				_card.getCardNumber(), _card.getOwner(), Constants.RETURN_MESSAGE, _refundAmount, _returnStamp);
		paymentTransaction.savePaymentTransaction();

		_bike.updateStatus(false, _newDockID);
		Dock.updateRemainCapacity(_bike.getDockID(), "-1");
	}
}
