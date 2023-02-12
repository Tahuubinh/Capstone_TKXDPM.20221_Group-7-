package subsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import subsystem.barcodeconverter.BarcodeConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

class BarcodeConverterTest {
	private BarcodeConverter barcodeConverter;

	@BeforeEach
	void setUp() throws Exception {
		barcodeConverter = new BarcodeConverter();
	}

	/*
	 * String, String barcode, expected bike code
	 */
	@ParameterizedTest
	@CsvSource({ "123, 123",
		         "01, 01",
		         "10, 10"    
	})
	
	@Test
	public void test(int barcode, int expected) {
		assertEquals(barcodeConverter.convertBarcodeToBikeCode(barcode), expected);
	}

}
