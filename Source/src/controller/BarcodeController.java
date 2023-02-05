package controller;

import entity.bike.Bike;
import subsystem.barcodeconverter.*;
import javafx.util.Pair;

public class BarcodeController {

	private static int bikeCode;

	public static Pair<Boolean, Bike> getBikeFromBarcode(String _barcode) {
		IBarcodeConverter bc = new BarcodeConverter();
		boolean flag = false;
		Bike bike = null;
		try {
			int barc = Integer.parseInt(_barcode);
            bikeCode = bc.convertBarcodeToBikeCode(barc);
            System.out.println(bikeCode);
			bike = DockController.getBikeFromID(bikeCode);
			flag = (bike == null) ? false : true;

		} catch (NumberFormatException e) {
			System.out.println("Invalid barcode at BarcodeController.checkBarcodeAndGetBikeIfTrue");
		}

		return new Pair<>(flag, bike);
	}
}
