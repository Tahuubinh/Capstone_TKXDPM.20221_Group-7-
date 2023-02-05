package subsystem.interbank.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.card.CreditCard;
import entity.transaction.InterbankTransaction;
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

	public ProcessTransaction(CreditCard card, int amount, String content, String createdAt, String command) {
		this.card = card;
		this.amount = amount;
		this.content = content;
		this.createdAt = createdAt;
		this.command = command;
		this.interbankTransaction = new InterbankTransaction(this.card, this.command, this.content, this.amount,
				this.createdAt);
	}

	@Override
	public String pack() {
		JsonObject message = new JsonObject();
		try {
			String transact = new ObjectMapper().writeValueAsString(interbankTransaction);
			@SuppressWarnings("deprecation")
			JsonObject transaction = new JsonParser().parse(transact).getAsJsonObject();
			String hashCode = HashFunction.hashTransaction(Constants.SECRET_KEY, interbankTransaction).toString();

			message.addProperty("version", "1.0.1");
			message.add("transaction", transaction);
			message.addProperty("appCode", Constants.APP_CODE);
			message.addProperty("hashCode", hashCode);
		} catch (Exception e) {
			System.out.println("Exception at utils.api.ProcessTransaction");
		}
		return message.toString();

	}

	@Override
	public String patch() {
		return "00";
	}

}
