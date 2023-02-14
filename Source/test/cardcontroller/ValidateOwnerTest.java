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
		"AN9, false", 
		"89, false", 
		"AN, true", 
		", false",	// No space
		"Van An9, false", 
		"8 9, false", 
		"Van an, true", 
		" , false",	// Single space
		"Van  An9, false", 
		"8  9, false", 
		"Van  an, false", 
		"Van   an, false",
		"  , false",	// Double space
		"' Van An9', false", 
		"' 89', false", 
		"' Van an', false", // Head space
		"'Van An9 ', false", 
		"'89 ', false", 
		"'Van an ', false", // Tail space
	})
	
	
	
	void test(String owner, boolean expected) {
		boolean isValid = CardController.validateOwner(owner);
		assertEquals(expected, isValid);
	}

}
