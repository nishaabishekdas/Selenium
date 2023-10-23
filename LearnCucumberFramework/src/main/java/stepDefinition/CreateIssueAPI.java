package stepDefinition;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

import com.google.gson.Gson;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import response.createIssueMetadataResponse.CreateIssueMetadataResponse;
import response.createIssueMetadataResponse.Issuetype;
import response.createIssueResponse.CreateIssueResponse;
import utils.JsonReader;
import utils.TestContext;

public class CreateIssueAPI {
	private TestContext testContext;
	CreateIssueMetadataResponse createMetadataResponse;
	Gson gson = new Gson();

	public CreateIssueAPI(TestContext testContext) {
		super();
		this.testContext = testContext;
	}

	@When("I invoke CreateIssueMetaData API")
	public void i_invoke_create_issue_meta_data_api() {
		baseURI = "https://nishmohan93.atlassian.net";
		testContext.response = given().header("Authorization",
				"Basic bmlzaG1vaGFuLjkzQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBrU3VvSnkwd3VEaWdxTXlEMVd4M1FOVVk3RGZ3VWw0b0VhaUJtZF9OckhZbEZRMzJqQjBxSzFiVFg4SEdNV3ZxeEEyT3R4dURkbmZPRlc3WVZtNU5GUTdFcUNhb3lGNFB1S0hvejRRUXNWMTVMdVBEY2pVY1RFNUozTm9uTWlOMXZma2tVZmpsbHJQS0h0eHdZdTVIYU9kQ2VXUHdiaG5pRDl0bDdYS3F2ZWc9QTk2M0EwNkE=")
				.contentType("application/json").get("/rest/api/3/issue/createmeta");
		System.out.println(testContext.response.toString());
	}

	@Then("I should get a response code of {int}")
	public void i_should_get_a_response_code_of(Integer statusCode) {
		Assert.assertEquals(Long.toString(testContext.response.statusCode()), Long.toString(statusCode));
	}

	@Then("I should be able to extract project id and {string}")
	public void i_should_be_able_to_extract_project_id_and_issue_type_id(String issueName) {
		// Step 2 - Parse the response and store the values in
		// CreateIssueMetadataResponse pojo class
		createMetadataResponse = testContext.response.as(CreateIssueMetadataResponse.class);

		// Step 3 - Extract the values from the pojo class using getter methods
		testContext.projectId = createMetadataResponse.getProjects().get(0).getId();
		List<Issuetype> issueList = createMetadataResponse.getProjects().get(0).getIssuetypes();
		for (Issuetype issueType : issueList) {
			if (issueType.getName().equals(issueName)) {
				testContext.issueTypeId = issueType.getId();
			}
		}
	}

	@When("I invoke createIssue API using project id and issue id")
	public void i_invoke_create_issue_api_using_project_id_and_issue_id() {
		// Read Json body
		JSONObject json = JsonReader.readJsonFile("createIssue.json");
		// Populate this Json into the pojo classes
		CreateIssueResponse createIssueBody = gson.fromJson(json.toString(), CreateIssueResponse.class);
		// set in the dynamic values
		createIssueBody.getFields().getProject().setId(testContext.projectId);
		createIssueBody.getFields().getIssuetype().setId(testContext.issueTypeId);
		testContext.response = given().header("Authorization",
				"Basic bmlzaG1vaGFuLjkzQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBrU3VvSnkwd3VEaWdxTXlEMVd4M1FOVVk3RGZ3VWw0b0VhaUJtZF9OckhZbEZRMzJqQjBxSzFiVFg4SEdNV3ZxeEEyT3R4dURkbmZPRlc3WVZtNU5GUTdFcUNhb3lGNFB1S0hvejRRUXNWMTVMdVBEY2pVY1RFNUozTm9uTWlOMXZma2tVZmpsbHJQS0h0eHdZdTVIYU9kQ2VXUHdiaG5pRDl0bDdYS3F2ZWc9QTk2M0EwNkE=")
				.contentType("application/json").body(createIssueBody).log().all().post("/rest/api/3/issue/");
		System.out.println(testContext.response.toString());
	}

	@Then("verify the extracted issueId from the response")
	public void verify_the_extracted_issue_id_from_the_response() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertNotNull(testContext.response.body().jsonPath().getString("id"));
	}

//	@Then("I should be able to extract project id and {string}")
//	public void i_should_be_able_to_extract_project_id_and_story(String story) {
//		
//	}

	@Then("Get project id and issue id using {string} from response")
	public void get_project_id_and_issue_id_using_story_from_response(String story) {
		// Step 2 - Parse the response and store the values in
		// CreateIssueMetadataResponse pojo class
		createMetadataResponse = testContext.response.as(CreateIssueMetadataResponse.class);

		// Step 3 - Extract the values from the pojo class using getter methods
		testContext.projectId = createMetadataResponse.getProjects().get(0).getId();
		List<Issuetype> issueList = createMetadataResponse.getProjects().get(0).getIssuetypes();
		for (Issuetype issueTypeElement : issueList) {
			if (issueTypeElement.getName().equals(story)) {
				testContext.issueTypeId = issueTypeElement.getId();
			}
		}
	}

}
