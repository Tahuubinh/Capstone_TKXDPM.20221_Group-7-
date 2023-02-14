package subsystem.barcodeconverter;

import subsystem.barcodeconverter.api.BarcodeConvertion;

public class BarcodeConverter implements BarcodeConverterInterface{
	/**
	 * convert barde to bike code
	 */
	public int convertBarcodeToBikeCode(int barcode){
		BarcodeConvertion barcodeConverter = new BarcodeConvertion(barcode);
		return Integer.parseInt(barcodeConverter.post());
	}
}
