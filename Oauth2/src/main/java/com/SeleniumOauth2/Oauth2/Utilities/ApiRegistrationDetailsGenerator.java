package com.SeleniumOauth2.Oauth2.Utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class ApiRegistrationDetailsGenerator extends TestBase {
	private static BufferedWriter bw;

	public static void getClientIdSecretKeyRedirectUri(String clientId, String secretKey, String redirectURI) {
		try {
			bw = new BufferedWriter(new FileWriter(
					"APIConfigFile.txt"));
			bw.write("Client Id: " + clientId + "\nSecret Key: " + secretKey + "\nRedirect URI: " + redirectURI);
		    bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
