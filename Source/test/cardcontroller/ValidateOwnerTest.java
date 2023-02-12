package cardcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CardController;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class ValidateOwnerTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	/*
	 * String owner, Boolean expected
	 */
	@ParameterizedTest
	@CsvSource({ 
		"NGUYEN VAN AN, true", 
		"Nguyen Van an, true", 
		"nguyen van an, true", 
		"Nguyen Van 2, false", 
		"234, false",
		", false"

	})
	void test(String owner, boolean expected) {
		boolean isValid = CardController.validateOwner(owner);
		assertEquals(expected, isValid);
	}

}
