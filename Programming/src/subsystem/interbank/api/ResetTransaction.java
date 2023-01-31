package subsystem.interbank.api;

import com.google.gson.JsonObject;

import entity.CreditCard;
import util.HTTPBinder;

public class ResetTransaction implements Message {

	private CreditCard card;

	public final static String URL = "https://ecopark-system-api.herokuapp.com/api/card/reset-balance";

	public ResetTransaction(CreditCard card) {
		this.card = card;
	}

}
