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
//		"1234567812345678, true", 
//		"123av67812345678, true", 
//		"123AV67812345678, false",
//		"1avAV67812345678, false",
//		"1av 6 7812345678, false",
//		"123451234567802, false",
//		"1234512345678ab, false",
//		"12345AC234567802, false",
//		"1234512345678AV, false",
//		"12345123456780234, false",
//		"1234512345678ab34, false",
//		"1234512345678AB34, false",
//		"123451AD45678ab34, false",
//		"abcdabcdabcdabcd, true", 
//		"789, false",
//		"789acb, false",
//		"abc, false",
//		"ABC, false",
//		"A7C, false",
//		"AbC, false",
//		"1Ac, false",
//		", false",
		"1234567812345678, true", 
		"123av67812345678, true", 
		"123AV67812345678, false",
		"1avAV67812345678, false",
		"1av 6 7812345678, false",
		"12345AC234567802, false",
		"1234512345678AV, false",
		"1234512345678AB34, false",
		"123451AD45678ab34, false",
		"abcdabcdabcdabcd, true", 
		"ABC, false",
		"A7C, false",
		"AbC, false",
		"1Ac, false",
		", false",

	})
	void test(String cardCode, boolean expected) {
		boolean isValid = CardController.validateCardCode(cardCode);
		assertEquals(expected, isValid);
	}

}
