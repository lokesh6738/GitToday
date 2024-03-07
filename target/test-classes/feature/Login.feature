Feature: Validating Place API's
@AddPlace @Regression
Scenario: Verify if Place is being Succesfully added using AddPlaceAPI
	Given AddPlace Payload
	When user hits "AddPlaceAPI"
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"

@GetPlace	@Regression
Scenario: Verify if Place is being successfully retrived using Get method
	Given place id
	When user hits "GetPlaceAPI"
	Then the API call got success with status code 200

@DeletePlace	@Regression
Scenario: Verify if Delete Place functionality is working
	Given DeletePlace Payload
	When user hits "DeletePlaceAPI"
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	


