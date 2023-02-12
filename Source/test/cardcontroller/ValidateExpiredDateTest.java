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
		"1300, true", 
		"1234, true", 
		"0000, true",  
		"00000, false",
		"000, false", 
		"a123, false", 
		", false"

	})
	void test(String expiredDate, boolean expected) {
		boolean isValid = CardController.validateExpiredDate(expiredDate);
		assertEquals(expected, isValid);
	}

}
