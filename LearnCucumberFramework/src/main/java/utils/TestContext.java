package utils;

import io.restassured.response.Response;

public class TestContext {

	public String projectId;

	public String issueTypeId;

	public Response response;

	public String url;

	public String token;
	public String clientId;
	public String secretKey;
	public String redirectUri;
	public String playlistId;

	public String getUrl() {
		return url;
	}

	public String getToken() {
		return token;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setClientId(String ClientId) {
		this.clientId = ClientId;
	}

	public void setSecretKey(String SecretKey) {
		this.secretKey = SecretKey;
	}

	public void setredirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public void setplaylistId(String playlistId) {
		this.playlistId = playlistId;
	}

	public String getClientId() {
		return clientId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getredirectUri() {
		return redirectUri;
	}

	public String getplaylistId() {
		return playlistId;
	}
}
