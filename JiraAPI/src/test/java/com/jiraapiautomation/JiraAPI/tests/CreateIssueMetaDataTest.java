package com.jiraapiautomation.JiraAPI.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateIssueMetaDataTest {
	String ApiToken;


	@BeforeMethod
	public void setUp() {
		baseURI = "https://nishmohan93.atlassian.net";
		ApiToken = "Basic bmlzaG1vaGFuLjkzQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBrU3VvSnkwd3VEaWdxTXlEMVd4M1FOVVk3RGZ3VWw0b0VhaUJtZF9OckhZbEZRMzJqQjBxSzFiVFg4SEdNV3ZxeEEyT3R4dURkbmZPRlc3WVZtNU5GUTdFcUNhb3lGNFB1S0hvejRRUXNWMTVMdVBEY2pVY1RFNUozTm9uTWlOMXZma2tVZmpsbHJQS0h0eHdZdTVIYU9kQ2VXUHdiaG5pRDl0bDdYS3F2ZWc9QTk2M0EwNkE=";
	}

	@Test
	public void extractProductIdIssueId(ITestContext context) {
		given().header("Authorization", ApiToken).when().log().all().get("/rest/api/3/issue/createmeta").then().log()
				.all().statusCode(200);
		Response response = given().header("Authorization", ApiToken).when().get("/rest/api/3/issue/createmeta");
		int productId = response.jsonPath().getInt("projects[0].id");
		context.setAttribute("productId", productId);
		int issueId = response.jsonPath().getInt("projects[0].issuetypes[1].id");
		context.setAttribute("issueId", issueId);
	}

}
