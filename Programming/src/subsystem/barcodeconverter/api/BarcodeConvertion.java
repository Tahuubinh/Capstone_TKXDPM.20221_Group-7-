package subsystem.barcodeconverter.api;

import com.google.gson.JsonObject;

import util.HTTPBinder;

public class BarcodeConvertion implements Message {

	private int barcode;

	public final static String URL = "https://barcodeservicebykv2.herokuapp.com/barcode";

	public BarcodeConvertion(int barcode) {
		this.barcode = barcode;
	}
}
