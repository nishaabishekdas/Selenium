package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.junit.Assert;

public class ViewStoreDefinitions {
	Response response;

	@Given("store API is available")
	public void store_api_is_available() {
		System.out.println("Given Method");
		baseURI = "http://localhost:3030/";
	}

	@When("I invoke stores API with get Method")
	public void i_invoke_stores_api_with_get_method() {
		//The path to send the request to.pathParams The path parameters. 
		//E.g. if path is "/book/{hotelId}/{roomNumber}" you can do get("/book/{hotelName}/{roomNumber}", "Hotels R Us", 22);.
		given().when().log().all().get("stores");
		response = given().when().get("stores");
		System.out.println("When Method");
	}

	@Then("the response code should be {int}")
	public void the_response_code_should_be(Integer statusCode) {
		System.out.println("Then Method");
		response.then().log().all();
		Assert.assertEquals(Long.toString(response.statusCode()), Long.toString(statusCode));
	}

	@When("I invoke {string} api with get Method")
	public void i_invoke_stores_api_using_endpoint_with_get_method(String endPoint) {
		response = given().log().all().when().get(endPoint,4);
		
	}
}
