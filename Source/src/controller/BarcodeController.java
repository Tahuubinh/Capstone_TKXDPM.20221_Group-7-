package controller;

import entity.bike.*;
import javafx.util.Pair;
import subsystem.barcodeconverter.*;


public class BarcodeController {

	private static int bikeCode;

	public static Pair<Boolean, Bike> getBikeFromBarcode(String barcode) {
        BarcodeConverterInterface bc = new BarcodeConverter();
		boolean flag = false;
		Bike bike = null;
		try {
			int barc = Integer.parseInt(barcode);
            bikeCode = bc.convertBarcodeToBikeCode(barc);
			bike = DockController.getBikeFromID(bikeCode);
			flag = (bike != null);

		} catch (NumberFormatException e) {
			System.out.println("Invalid barcode!");
		}

		return new Pair<>(flag, bike);
	}
}
