package com.jiraapiautomation.JiraAPI.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class EditIssueMetaDataTest {
	String ApiToken;

	@BeforeMethod
	public void setUp() {
		baseURI = "https://nishmohan93.atlassian.net";
		ApiToken = "Basic bmlzaG1vaGFuLjkzQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBrU3VvSnkwd3VEaWdxTXlEMVd4M1FOVVk3RGZ3VWw0b0VhaUJtZF9OckhZbEZRMzJqQjBxSzFiVFg4SEdNV3ZxeEEyT3R4dURkbmZPRlc3WVZtNU5GUTdFcUNhb3lGNFB1S0hvejRRUXNWMTVMdVBEY2pVY1RFNUozTm9uTWlOMXZma2tVZmpsbHJQS0h0eHdZdTVIYU9kQ2VXUHdiaG5pRDl0bDdYS3F2ZWc9QTk2M0EwNkE=";
	}
	
	@Test
	public void extractEditIssueMetaData(ITestContext context) {
		System.out.println(context.getAttribute("issueIdCreated"));
		String endPoint="/rest/api/3/issue/"+ context.getAttribute("issueIdCreated") +"/editmeta";
		System.out.println(endPoint);
		given().header("Authorization", ApiToken).when().log().all()
				.get(endPoint).then().log().all()
				.statusCode(200);
		Response response =given().header("Authorization", ApiToken).when().log().all()
				.get(endPoint);
		String descriptionName=response.body().jsonPath().getString("fields.description.name");
		String operationAllowed=response.body().jsonPath().getString("fields.description.operations");
		System.out.println("descriptionName"+descriptionName+"\n");
		System.out.println("operationAllowed"+operationAllowed+"\n");
		Assert.assertEquals(descriptionName, "Description","Trying to update a wrong field");
		Assert.assertEquals(operationAllowed, "[set]","This operation is not allowed");
	}
	
	
}
