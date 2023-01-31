package controller;

import subsystem.interbank.IInterbank;
import subsystem.interbank.Interbank;
import util.*;
import entity.*;
import javafx.util.Pair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReturnBikeController {

	public static Pair<String, RentBikeInvoice> processReturnBike(String rentalCode, CreditCard card, String newDockID)
			throws RuntimeException {
		// Gent rent bike invoice and rental bike from rental code
		RentBikeInvoice rentBikeInvoice = RentBikeController.getRentBikeInvoice(rentalCode);
		Bike bike = DockController.getBikeFromID(rentBikeInvoice.getBikeCode());

		// Initialize for time and calculate rent duration
		Calendar calendar = Calendar.getInstance();
		DateFormat daytime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date returnTime = calendar.getTime();

		Date rentTime = null;
		try {
			rentTime = daytime.parse(rentBikeInvoice.getRentTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Calculate rent duration
		long diff = returnTime.getTime() - rentTime.getTime();
		int duration = (int) Math.ceil((double) diff / 60000);

		// Calculate rent cost and refund amount
		int rentCost = bike.caculateRentCost(duration);
		int refundAmount = rentBikeInvoice.getDeposit() - rentCost;
		System.out.println("Refund amount: " + refundAmount);
		assert refundAmount > 0;

		// Using interbank to process refund
		IInterbank interbank = new Interbank();
		String respondCode = interbank.processTransaction(card, refundAmount, "Transaction for a refund",
				daytime.format(returnTime), Constants.REFUND);
		System.out.println("respond code: " + respondCode);

		// Update after return bike
		if (!respondCode.equals(Constants.SUCCESS)) {
			HandleException.getException(respondCode);
			return new Pair<>(respondCode, null);
		} else {
			updateReturnBikeStatus(card, bike, newDockID, refundAmount, daytime.format(returnTime), rentBikeInvoice);
		}

		return new Pair<>(respondCode, rentBikeInvoice);
	}

	private static void updateReturnBikeStatus(CreditCard card, Bike bike, String newDockID, int refundAmount,
			String returnStamp, RentBikeInvoice rentBikeInvoice) {
		// Update rent bike screen status
		RentBikeController.rentalCode = null;

		// Update rent bike invoice (for our own system)
		int rentCost = rentBikeInvoice.getDeposit() - refundAmount;
		rentBikeInvoice.updateAfterReturnBike(returnStamp, rentCost);

		// Save payment by Interbank
		PaymentTransaction paymentTransaction = new PaymentTransaction(rentBikeInvoice.getRentalCode(),
				card.getCardCode(), card.getOwner(), Constants.RETURN_MESSAGE, refundAmount, returnStamp);
		paymentTransaction.savePaymentTransaction();

		// Update bike used status
		bike.updateStatus(false, newDockID);

		// Update dock capacity
		Dock.updateRemainCapacity(bike.getDockID(), "-1");
	}
}
