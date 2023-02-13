package controller;

import subsystem.interbank.IInterbank;
import subsystem.interbank.Interbank;
import util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import entity.dock.*;
import entity.transaction.*;
import entity.invoice.*;
import entity.bike.Bike;
import entity.card.CreditCard;


public class RentBikeController {

	public static String rentalCode = null;

	public static int rentalCounter = 0;

	public static String processRentBike(CreditCard card, Bike bike) throws RuntimeException {
		System.out.println("Processing your transaction");
	
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		DateFormat daytime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		rentalCode = convertBikeCodeToRentalCode(bike.getBikeID());
		int deposit = bike.calculateDeposit();
		IInterbank interbank = new Interbank();
		String code = interbank.processTransaction(card, deposit, "Transaction for a rent", daytime.format(date),
				Constants.PAY);

		if (code.equals(Constants.SUCCESS)) {
	
			updateRentBikeStatus(card, bike, deposit, daytime.format(date), null);
		} else {
			HandleException.getException(code);
		}
		return code;
	}

	private static void updateRentBikeStatus(CreditCard card, Bike bike, int amount, String rentStamp, String returnStamp) {
		RentBikeInvoice rentBikeInvoice = new RentBikeInvoice(rentalCode, bike.getBikeID(), bike.getType(),
				card.getOwner(), rentStamp, amount);

		rentBikeInvoice.saveRentBikeInvoice();

		PaymentTransaction paymentTransaction = new PaymentTransaction(rentalCode, card.getCardCode(), card.getOwner(),
				Constants.RENT_MESSAGE, amount, rentStamp);
		paymentTransaction.savePaymentTransaction();

		bike.updateStatus(true, bike.getDockID());

		Dock.updateRemainCapacity(bike.getDockID(), "1");
	}

	public static String convertBikeCodeToRentalCode(int bikeID) {
		return bikeID + String.valueOf(rentalCounter++);
	}

	public static RentBikeInvoice getRentBikeInvoice(String rentalCode) {
		ArrayList<ArrayList<String>> rentBikeInvoice = RentBikeInvoiceDAO.queryByRentalCode(rentalCode);
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
