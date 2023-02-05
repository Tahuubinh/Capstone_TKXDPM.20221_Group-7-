package subsystem.interbank;

import entity.card.CreditCard;

public interface IInterbank {

	String processTransaction(CreditCard card, int amount, String content, String createdAt, String command);

	String reset(CreditCard card);
}
