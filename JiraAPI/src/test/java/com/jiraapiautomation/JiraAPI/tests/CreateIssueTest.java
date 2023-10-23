package com.jiraapiautomation.JiraAPI.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.response.Response;

public class CreateIssueTest {
	String ApiToken;

	@BeforeMethod
	public void setUp() {
		baseURI = "https://nishmohan93.atlassian.net";
		ApiToken = "Basic bmlzaG1vaGFuLjkzQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBrU3VvSnkwd3VEaWdxTXlEMVd4M1FOVVk3RGZ3VWw0b0VhaUJtZF9OckhZbEZRMzJqQjBxSzFiVFg4SEdNV3ZxeEEyT3R4dURkbmZPRlc3WVZtNU5GUTdFcUNhb3lGNFB1S0hvejRRUXNWMTVMdVBEY2pVY1RFNUozTm9uTWlOMXZma2tVZmpsbHJQS0h0eHdZdTVIYU9kQ2VXUHdiaG5pRDl0bDdYS3F2ZWc9QTk2M0EwNkE=";
	}

	@Test
	public void verifyCreateIssueFromMetaData(ITestContext context) {
		//String requestBody = "{\"fields\":{\"description\":{\"content\":[{\"content\":[{\"text\":\"Usernameacceptsspace\",\"type\":\"text\"}],\"type\":\"paragraph\"}],\"type\":\"doc\",\"version\":1},\"issuetype\":{\"id\":"+context.getAttribute("issueId")+"},\"project\":{\"id\":"+context.getAttribute("productId")+"},\"summary\":\"Loginusernameacceptsspace\"}}";
		JsonObject createIssueRequestBody=new JsonObject();
		JsonObject fields= new JsonObject();
		fields.addProperty("summary", "Login username accepts space");
		JsonObject project= new JsonObject();
		project.addProperty("id", 10000);
		JsonObject issuetype= new JsonObject();
		issuetype.addProperty("id", 10003);
		JsonObject description= new JsonObject();
		description.addProperty("type", "doc");
		description.addProperty("version", 1);
		JsonArray content=new JsonArray();
		JsonObject internalContentObject=new JsonObject();
		internalContentObject.addProperty("type", "paragraph");
		JsonArray internalContentArray=new JsonArray();
		JsonObject internalContentArrayObject=new JsonObject();
		internalContentArrayObject.addProperty("text", "Username accepts space");
		internalContentArrayObject.addProperty("type", "text");
		internalContentArray.add(internalContentArrayObject);
		internalContentObject.add("content", internalContentArray);
		content.add(internalContentObject);
		description.add("content", content);
		fields.add("description", description);
		fields.add("issuetype", issuetype);
		fields.add("project", project);
		createIssueRequestBody.add("fields", fields);
		System.out.println(createIssueRequestBody.toString());
		
		given().header("Authorization", ApiToken).contentType("application/json").log().all().body(createIssueRequestBody.toString())
				.post("/rest/api/3/issue").then().log().all().statusCode(201);
		Response response = given().header("Authorization", ApiToken).contentType("application/json").body(createIssueRequestBody.toString())
				.post("/rest/api/3/issue");
		//String responseBody = response.getBody().asString();
		int issueIdCreated = response.jsonPath().getInt("id");
		context.setAttribute("issueIdCreated", issueIdCreated);
	}
}
