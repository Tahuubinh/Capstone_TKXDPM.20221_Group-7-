package subsystem.interbank;

import entity.card.*;

public interface IInterbank {
	
	String processTransaction(CreditCard card, int amount, String content, String createdAt, String command);

	/**
	 * reset card
	 * @param card
	 * @return
	 */
	String reset(CreditCard card);
}
