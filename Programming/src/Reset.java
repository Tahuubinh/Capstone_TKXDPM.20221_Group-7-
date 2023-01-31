import org.json.JSONObject;
import util.HTTPBinder;

public class Reset {
	public static void main(String[] args) {
		testReset();
//		testProcess();
		JSONObject jsonObject = new JSONObject(
				"{\"errorCode\":\"00\",\"cardCode\":\"nhom7\"}");
		System.out.println(jsonObject.get("errorCode").equals("00"));
	}

	public static void testReset() {
		String url = "https://ecopark-system-api.herokuapp.com/api/card/reset-balance";
		HTTPBinder h = new HTTPBinder();
		System.out.println("{\"cardCode\":\"nhom7\"}");
		String result = h.patch(url, "{\"cardCode\":\"nhom7\"}");
		System.out.println(result);
	}

	public static void testProcess() {
		String url = "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";
		HTTPBinder h = new HTTPBinder();
		String result = h.patch(url, "{\"version\":\"1.0.1\"}");
		System.out.println(result);
	}

}
