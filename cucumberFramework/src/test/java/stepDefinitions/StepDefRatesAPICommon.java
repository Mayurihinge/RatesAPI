package stepDefinitions;

import cucumber.api.PendingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import process.RatesAPIObject;
import process.RatesAPIRequestProcessor;
import process.RatesAPIResponseProcessor;

public class StepDefRatesAPICommon {
	private RatesAPIObject ratesAPIObject;

	
	//Creating RatesAPI object and passing Datatable object 
	@Given("Rates API for Latest Foreign Exchange rates")
	public void rates_API_for_Latest_Foreign_Exchange_rates(DataTable dataTable) throws PendingException {
		ratesAPIObject = new RatesAPIObject(dataTable);
	}

	//Processing the RatesAPI object 
	@When("The API is available")
	public void the_API_is_available() throws Exception {
		RatesAPIRequestProcessor.process(ratesAPIObject);
	}

	//Asserting the response received in the RatesAPIResponseProcessor process
	@Then("An automated test suite should run which will assert the success status of the response")
	public void an_automated_test_suite_should_run_which_will_assert_the_success_status_of_the_response()
			throws PendingException {
		RatesAPIResponseProcessor.assertResponseSuccessStatus();
	}

	@Then("An automated test suite should run which will assert the response")
	public void an_automated_test_suite_should_run_which_will_assert_the_response() throws PendingException {
		RatesAPIResponseProcessor.assertSuccessResponse();
	}

	
	@When("An incorrect or incomplete url is provided")
	public void an_incorrect_or_incomplete_url_is_provided() throws Exception {
		RatesAPIRequestProcessor.process(ratesAPIObject);
	}

	//Asserting the Failure response
	@Then("Test case should assert the correct response supplied by the call")
	public void test_case_should_assert_the_correct_response_supplied_by_the_call() throws PendingException {
		RatesAPIResponseProcessor.assertResponseFailStatus();
		RatesAPIResponseProcessor.assertFailureResponse();
	}

	@Given("Rates API for Specific date Foreign Exchange rates")
	public void rates_API_for_Specific_date_Foreign_Exchange_rates(DataTable dataTable) throws PendingException {
		ratesAPIObject = new RatesAPIObject(dataTable);
	}

	@When("A future date is provided in the url")
	public void a_future_date_is_provided_in_the_url() throws Exception {
		RatesAPIRequestProcessor.process(ratesAPIObject);
	}

	@Then("An automated test suite should run which will validate that the response matches for the current date")
	public void an_automated_test_suite_should_run_which_will_validate_that_the_response_matches_for_the_current_date()
			throws PendingException {
		RatesAPIResponseProcessor.assertSuccessResponse();
	}
}
