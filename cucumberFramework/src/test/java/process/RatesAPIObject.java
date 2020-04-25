package process;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.datatable.DataTable;

public class RatesAPIObject {
	private String URLType;
	private String ratesRequestURL;

	//Passing the Datatable object in a List .
	//Creating the List and accessing the 0th and 1st value.
	public RatesAPIObject(DataTable dataTable) {
		List<String> dataList = new ArrayList<String>(dataTable.asList());
		URLType = dataList.get(0);
		ratesRequestURL = dataList.get(1);
	}

	public String getURLType() {
		return URLType;
	}

	public void setURLType(String uRLType) {
		URLType = uRLType;
	}

	public String getRatesRequestURL() {
		return ratesRequestURL;
	}

	public void setRatesRequestURL(String ratesRequestURL) {
		this.ratesRequestURL = ratesRequestURL;
	}
}
