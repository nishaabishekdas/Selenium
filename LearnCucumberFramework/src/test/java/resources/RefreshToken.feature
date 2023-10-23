@RefreshTokenAPI
Feature: Refresh Token API Test 

  @AuthorizationCodeAPI
 	Scenario: Test to get authorization code api
 	  When I invoke authorization code api using clientId, "code" and redirectUri from response
 		Then I should get a response code of 200
 		And  get the authcode from the response

   @GetAccessTokenAPI
	Scenario: Test to get access token API
		When I invoke access token API using authcode
		Then I should get a response code of 200
		And  get the access token and refresh token from response

   @GetPlayListAPI
  Scenario: Test to get the playlist
  When I invoke getplaylist API using access token and playlistId
  Then I should get a response code of 200
 

