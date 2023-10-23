package com.jiraapiautomation.JiraAPI.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteIssueTest {
	String ApiToken;

	@BeforeMethod
	public void setUp() {
		baseURI = "https://nishmohan93.atlassian.net";
		ApiToken = "Basic bmlzaG1vaGFuLjkzQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBrU3VvSnkwd3VEaWdxTXlEMVd4M1FOVVk3RGZ3VWw0b0VhaUJtZF9OckhZbEZRMzJqQjBxSzFiVFg4SEdNV3ZxeEEyT3R4dURkbmZPRlc3WVZtNU5GUTdFcUNhb3lGNFB1S0hvejRRUXNWMTVMdVBEY2pVY1RFNUozTm9uTWlOMXZma2tVZmpsbHJQS0h0eHdZdTVIYU9kQ2VXUHdiaG5pRDl0bDdYS3F2ZWc9QTk2M0EwNkE=";
	}

	@Test
	public void validateDeleteIssue(ITestContext context) {
		given().header("Authorization", ApiToken).contentType("application/json").when().log().all()
				.delete("/rest/api/3/issue/{issueId}", context.getAttribute("issueIdCreated")).then().log().all()
				.statusCode(204);
	}
}
