package controller;

import entity.bike.Bike;
import subsystem.barcodeconverter.*;
import javafx.util.Pair;

public class BarcodeController {

	private static int bikeCode;

	public static Pair<Boolean, Bike> getBikeFromBarcode(String _barcode) {
        IBarcodeConverter barcode = new BarcodeConverter();
		boolean flag;
		Bike bike;
		try {
			int barc = Integer.parseInt(_barcode);
            bikeCode = barcode.convertBarcodeToBikeCode(barc);
            System.out.println(bikeCode);
			bike = DockController.getBikeFromID(bikeCode);
			flag = !(bike == null);

		} catch (NumberFormatException e) {
			System.out.println("Invalid barcode");
		}

		return new Pair<>(flag, bike);
	}
}
