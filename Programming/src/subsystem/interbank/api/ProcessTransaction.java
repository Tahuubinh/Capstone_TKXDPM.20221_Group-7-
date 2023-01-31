package subsystem.interbank.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.CreditCard;
import entity.InterbankTransaction;
import util.Constants;
import util.HTTPBinder;
import util.HashFunction;

public class ProcessTransaction implements Message {
	
	private CreditCard card;

	private int amount;

	private String content;

	private String createdAt;

	private String command;
	
	private InterbankTransaction interbankTransaction;

	private static final String URL = "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";

	@SuppressWarnings("unused")
	private static final String VERSION = "1.0.1";

	public ProcessTransaction(CreditCard card, int amount, String content, String createdAt, String command) {
		this.card = card;
		this.amount = amount;
		this.content = content;
		this.createdAt = createdAt;
		this.command = command;
		this.interbankTransaction = new InterbankTransaction(this.card, this.command, this.content, this.amount,
				this.createdAt);
	}

}
