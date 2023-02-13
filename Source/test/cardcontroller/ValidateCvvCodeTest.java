package cardcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CardController;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class ValidateCvvCodeTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	/*
	 * String cvvCode, Boolean expected
	 */
	@ParameterizedTest
	@CsvSource({ 
		"0123, true", 
		"123, false", 
		"1234, true", 
		"2 3, false", 
		"2av, false",
		", false"

	})
	void test(String cvvCode, boolean expected) {
		boolean isValid = CardController.validateCcvCode(cvvCode);
		assertEquals(expected, isValid);
	}

}
