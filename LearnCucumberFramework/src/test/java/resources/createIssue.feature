@CreateIssueApiFeature
Feature: Create Issue API Test 
  I want to use this template for my feature file
Background: 		
		When I invoke CreateIssueMetaData API
 		Then I should get a response code of 200

  @createIssueOfStoryType
 	Scenario: Test to create issue API
		And I should be able to extract project id and "Story"
 		When I invoke createIssue API using project id and issue id
 		Then I should get a response code of 201
 		And verify the extracted issueId from the response

   @createIssueOfDifferentTypes
	Scenario Outline: Test to create issue API
		When I invoke CreateIssueMetaData API
		Then I should get a response code of 200
		And  Get project id and issue id using "<issueType>" from response
		When I invoke createIssue API using project id and issue id
		Then I should get a response code of 201
		And verify the extracted issueId from the response

     Examples:
		 |issueType|
		 |Story|
		 |Bug|
		 |Task|

