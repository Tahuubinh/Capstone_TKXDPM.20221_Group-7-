package subsystem.interbank.api;

import com.google.gson.JsonObject;

import entity.card.CreditCard;
import util.HTTPBinder;

public class ResetTransaction implements Message {

	private CreditCard card;

	public ResetTransaction(CreditCard card) {
		this.card = card;
	}

	@Override
	public String pack() {
		JsonObject sentJson = new JsonObject();
		sentJson.addProperty("cardCode", card.getCardNumber());
		sentJson.addProperty("owner", card.getOwner());
		sentJson.addProperty("cvvCode", card.getCVV());
		sentJson.addProperty("dateExpired", card.getExpiredDate());
		return sentJson.toString();
	}

	@Override
	public String patch() {
		return "00";
	}

}
