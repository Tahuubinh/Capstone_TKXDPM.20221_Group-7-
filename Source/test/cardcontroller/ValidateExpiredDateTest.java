package cardcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CardController;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class ValidateExpiredDateTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	/*
	 * String expiredDate, Boolean expected
	 */
	@ParameterizedTest
	@CsvSource({ 
		"1111, true", 
		"0123, true", 
		"1299, true", 
		"1300, false", 
		"1234, true", 
		"0000, false",  
		"0100, true", 
		"00000, false",
		"000, false", 
		"a123, false", 
		"01s3, false",
		"0A33, false",
		"01 3, false",
		"abcd, false",
		"ABdc, false",
		"1d2D, false", 
		"1Ab3, false", 
		"345, false",
		"abc, false", 
		"2 3, false", 
		"2D3, false", 
		"2av, false",
		"34553, false",
		"ab6c3, false", 
		"2 334, false", 
		"2D353, false", 
		"26a3v, false",
		"0, false",
		", false"

	})
	void test(String expiredDate, boolean expected) {
		boolean isValid = CardController.validateExpiredDate(expiredDate);
		assertEquals(expected, isValid);
	}

}
