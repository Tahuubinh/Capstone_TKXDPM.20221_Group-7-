package subsystem.barcodeconverter.api;

import com.google.gson.JsonObject;
import org.json.*;

public class BarcodeConvertion implements Message {

	private int barcode;

	public final static String URL = "https://barcodeservicebykv2.herokuapp.com/barcode";

	public BarcodeConvertion(int barcode) {
		this.barcode = barcode;
	}

	@Override
	public String pack() {
		JsonObject sentJson = new JsonObject();
		sentJson.addProperty("barcode", String.valueOf(this.barcode));
		return sentJson.toString();
	}

	@Override
	public String post() {
		JSONObject obj = new JSONObject(this.pack());
		String code = obj.getString("barcode");
		return code;
	}
}
