package cardcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CardController;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class ValidateCardCodeTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	/*
	 * String cardCode, Boolean expected
	 */
	@ParameterizedTest
	@CsvSource({ 
		"1234567812345678, true", 
		"123av67812345678, true", 
		"123AV67812345678, false",
		"1234512345678, false",
		"abc, false", 
		", false",

	})
	void test(String cardCode, boolean expected) {
		boolean isValid = CardController.validateCardCode(cardCode);
		assertEquals(expected, isValid);
	}

}
