package subsystem.barcodeconverter;

import subsystem.barcodeconverter.api.BarcodeConvertion;

public class BarcodeConverter implements IBarcodeConverter{
	
	public int convertBarcodeToBikeCode(int barcode){
		BarcodeConvertion barcodeConverter = new BarcodeConvertion(barcode);
		return Integer.parseInt(barcodeConverter.post());
	}
}
