package process;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;

public class RatesAPIResponseProcessor extends Constants {
	private static HttpResponse httpResponse;

	public RatesAPIResponseProcessor(HttpResponse response) {
		httpResponse = response;
	}

	public static void assertEquals(String expected, String actual) {
		Assert.assertEquals("Actual and expected should be equal", expected, actual);
	}

	public static void assertTrue(boolean condition) {
		Assert.assertTrue("Assert Condition is true.", condition);
	}

	public static void assertResponseSuccessStatus() {
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals("Response Code should be 200", 200, statusCode);
	}

	public static void assertResponseFailStatus() {
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals("Response Code should be 400", 400, statusCode);
	}
	
    //Assertion to check if the constants DATE, BASE, RATES are not empty.
	public static void assertSuccessResponse() {
		try {
			JSONObject jsonObject = new JSONObject(EntityUtils.toString(httpResponse.getEntity()));
			System.out.println("Success Response: " + jsonObject);
			assertTrue(!EMPTY.equals(jsonObject.get(DATE).toString()));
			assertTrue(!EMPTY.equals(jsonObject.get(BASE).toString()));
			assertTrue(!EMPTY.equals(jsonObject.get(RATES).toString()));
		} catch (Exception e) {
			System.out.println("Incorrect Assertion assertSuccessResponse called " + e);
		}
	}

	//Assertion to check if the constants ERROR is not empty.
	public static void assertFailureResponse() {
		try {
			JSONObject jsonObject = new JSONObject(EntityUtils.toString(httpResponse.getEntity()));
			System.out.println("Failure Response: " + jsonObject);
			assertTrue(!EMPTY.equals(jsonObject.get(Constants.ERROR).toString()));
		} catch (Exception e) {
			System.out.println("Incorrect Assertion assertFailureResponse called " + e);
		}
	}
}