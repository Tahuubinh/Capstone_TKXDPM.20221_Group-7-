package subsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import subsystem.interbank.Interbank;
import entity.card.CreditCard;

class InterbankTest {

	private Interbank interbankController;

    @BeforeEach
    void setUp() throws Exception {
    	interbankController = new Interbank();
    }

    /*
	 * String, String, String, String, int, String, Format String, String, String
	 * (error code) cardCode, owner, CVV, expired Date, amount, content, createdAt,
	 * command, expected
	 */
	@ParameterizedTest
	// @CsvFileSource(resources = "InterbankTest.csv", numLinesToSkip = 1)
	@CsvSource({ 
		"9999999999999999, Binh, 666, 1029, 400000, Rent bike, 2021-12-14 17:00:36, pay, 00",
		"9999999999999999, Binh, 666, 0, 0, Process for a transaction, 2021-06-12 17:00:36, pay, 00",
		"9999999999999999, Binh, 666, , 1400000, , 2021-05-12 15:18:30, pay, 00" 
	})
    public void test(String cardCode, String owner, String cvv, String expiredDate, 
    		String amount, String content, String createdAt, String command, 
    		String expected) {
		CreditCard card = new CreditCard(cardCode, owner, cvv, expiredDate);
		try {
			System.out.println(interbankController.processTransaction(card, (int) Integer.parseInt(amount), 
					content, createdAt, command));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		assertEquals(interbankController.processTransaction(card, (int) Integer.parseInt(amount), 
				content, createdAt, command), expected);
		interbankController.reset(card);
	}

}
