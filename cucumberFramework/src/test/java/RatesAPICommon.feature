Feature: API Testing

Scenario: In order to test API

  Given Rates API for Latest Foreign Exchange rates
  | Latest Rates URL  | 
  | https://api.ratesapi.io/api/latest |
 	When The API is available
  Then An automated test suite should run which will assert the success status of the response
  
  Given Rates API for Latest Foreign Exchange rates
  | Latest Rates URL  | 
  | https://api.ratesapi.io/api/latest | 
  When The API is available
  Then An automated test suite should run which will assert the response 
  
  Given Rates API for Latest Foreign Exchange rates 
  | Latest Rates URL  |  
  | https://api.ratesapi.io/api/ |
	When An incorrect or incomplete url is provided
	Then Test case should assert the correct response supplied by the call 


 	Given Rates API for Specific date Foreign Exchange rates 
 	 | Date URL  |
 	 | https://api.ratesapi.io/api/2021-05-12 |
 	 
 	When A future date is provided in the url 
  Then An automated test suite should run which will validate that the response matches for the current date 
  
  Given Rates API for Specific date Foreign Exchange rates
  | Date URL  |
  | https://api.ratesapi.io/api/2021-05-12 |
  When The API is available
  Then An automated test suite should run which will assert the success status of the response 
  
  Given Rates API for Specific date Foreign Exchange rates
  | Date URL  |
  | https://api.ratesapi.io/api/2021-05-12 |
  When The API is available
  Then An automated test suite should run which will assert the response