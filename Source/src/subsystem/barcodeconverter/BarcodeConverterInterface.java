package subsystem.barcodeconverter;

public interface BarcodeConverterInterface {
	/**
	 * Convert barcode into bike code
	 * 
	 * @param barcode : input barcode
	 * @return bikeCode
	 */
	int convertBarcodeToBikeCode(int barcode);
}
