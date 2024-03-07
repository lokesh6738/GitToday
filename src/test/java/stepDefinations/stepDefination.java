package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Payload;
import resources.Utils;


public class stepDefination extends Utils {
	RequestSpecification req1;
	ResponseSpecification resspec;
	Response response;
	JsonPath js;
	static String placeId;
	@Given("AddPlace Payload")
	public void add_place_payload_with_world_cross_center_s() throws IOException {
		
	    req1=given().spec(reqSpec()).
		body(Payload.addPlaceJSONBody());
		
		
	}
	@When("user hits {string}")
	public void user_calls_with_http_request(String api) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(api.equalsIgnoreCase("AddPlaceAPI")) {
		response = req1.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();
		}
		else if(api.equalsIgnoreCase("GetPlaceAPI")) {
			response = req1.when().get("/maps/api/place/get/json").then().spec(resspec).extract().response();
		}
		else if(api.equalsIgnoreCase("DeletePlaceAPI")) {
			response = req1.when().delete("/maps/api/place/delete/json").then().spec(resspec).extract().response();
		}
	    
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int statuscode) {
		
	    assertEquals(response.getStatusCode(),statuscode);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedvalue) {
	    String resp = response.asString();
	    js = new JsonPath(resp);
	    placeId = js.getString("place_id");
	    assertEquals(js.get(key),expectedvalue);
	}
	@Given("place id")
	public void place_id() throws IOException  {
	    req1=given().spec(reqSpec()).queryParam("place_id", placeId);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException { 
	    req1=given().spec(reqSpec()).body("{\r\n    \"place_id\":\""+placeId+"\"\r\n}");
	}
	

}
