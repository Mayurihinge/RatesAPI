package process;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class RatesAPIRequestProcessor {
 
	//Getting the Http response from the Rates Request URL and returning the value
	public static RatesAPIResponseProcessor process(RatesAPIObject object) throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(object.getRatesRequestURL());
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		return new RatesAPIResponseProcessor(httpResponse);
	}
}