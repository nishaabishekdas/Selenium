package com.jiraapiautomation.JiraAPI.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jiraapiautomation.JiraAPI.Utils.RandomString;

public class EditIssueTest {
	String ApiToken;

	@BeforeMethod
	public void setUp() {
		baseURI = "https://nishmohan93.atlassian.net";
		ApiToken = "Basic bmlzaG1vaGFuLjkzQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBrU3VvSnkwd3VEaWdxTXlEMVd4M1FOVVk3RGZ3VWw0b0VhaUJtZF9OckhZbEZRMzJqQjBxSzFiVFg4SEdNV3ZxeEEyT3R4dURkbmZPRlc3WVZtNU5GUTdFcUNhb3lGNFB1S0hvejRRUXNWMTVMdVBEY2pVY1RFNUozTm9uTWlOMXZma2tVZmpsbHJQS0h0eHdZdTVIYU9kQ2VXUHdiaG5pRDl0bDdYS3F2ZWc9QTk2M0EwNkE=";
	}

	@Test
	public void validateEditIssue(ITestContext context) {
		String randomString = RandomString.generateRandomString();
		JsonObject editIssueRequestBody = new JsonObject();
		JsonObject fields = new JsonObject();
		JsonObject description = new JsonObject();
		description.addProperty("type", "doc");
		description.addProperty("version", 1);
		JsonArray content = new JsonArray();
		JsonObject internalContentObject = new JsonObject();
		internalContentObject.addProperty("type", "paragraph");
		JsonArray internalContentArray = new JsonArray();
		JsonObject internalContentArrayObject = new JsonObject();
		internalContentArrayObject.addProperty("text", randomString);
		internalContentArrayObject.addProperty("type", "text");
		internalContentArray.add(internalContentArrayObject);
		internalContentObject.add("content", internalContentArray);
		content.add(internalContentObject);
		description.add("content", content);
		fields.add("description", description);
		editIssueRequestBody.add("fields", fields);
		System.out.println(editIssueRequestBody.toString());

//		String requestBody = "{\"fields\":{\"description\":{\"content\":[{\"content\":[{\"text\":\"" + randomString
//				+ "\",\"type\":\"text\"}],\"type\":\"paragraph\"}],\"type\":\"doc\",\"version\":1}}}";
		given().header("Authorization", ApiToken).contentType("application/json").log().all().body(editIssueRequestBody.toString())
				.put("/rest/api/3/issue/{issueId}", context.getAttribute("issueIdCreated")).then().log().all()
				.statusCode(204);

	}
}
