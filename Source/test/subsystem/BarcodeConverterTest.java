package subsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import subsystem.barcodeconverter.BarcodeConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class BarcodeConverterTest {
	private BarcodeConverter barcodeConverter;

	@BeforeEach
	void setUp() throws Exception {
		barcodeConverter = new BarcodeConverter();
	}

	/*
	 * String barcode, String expected bikeCode
	 */
	@ParameterizedTest
	@CsvSource({ "123, 123",
		         "01, 01",
		         "10, 10"    
	})
	public void test(int barcode, int expected) {
		assertEquals(barcodeConverter.convertBarcodeToBikeCode(barcode), expected);
	}

}
