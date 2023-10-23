package com.SeleniumOauth2.Oauth2.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumOauth2.Oauth2.Base.TestBase;
import com.SeleniumOauth2.Oauth2.Pages.DashboardSpotifyForDevelopers;
import com.SeleniumOauth2.Oauth2.Pages.HomeSpotifyForDevelopers;
import com.SeleniumOauth2.Oauth2.Pages.LoginPage;
import com.SeleniumOauth2.Oauth2.Pages.LoginSpotify;
import com.SeleniumOauth2.Oauth2.Pages.MyAppBasicInformation;
import com.SeleniumOauth2.Oauth2.Pages.MyAppHome;
import com.SeleniumOauth2.Oauth2.Utilities.ApiRegistrationDetailsGenerator;

public class MyAppBasicInformationTest extends TestBase {
	public LoginPage login;
	public LoginSpotify loginSpotify = new LoginSpotify();
	public HomeSpotifyForDevelopers homePage = new HomeSpotifyForDevelopers();
	public DashboardSpotifyForDevelopers dashboard = new DashboardSpotifyForDevelopers();
	public MyAppHome appHome = new MyAppHome();
	public MyAppBasicInformation appBasicInfo = new MyAppBasicInformation();

	@BeforeMethod
	public void setUp() {
		intialisation();
		login = new LoginPage();
	}

	@Test
	public void test() {
		System.out.println("Test is working");
	}

	@Test
	public void verifyClientId() {
		loginSpotify = login.clickOnLoginButton();
		homePage = loginSpotify.loginToSpotify();
		homePage.clickOnnishaDropDwnBtn();
		dashboard = homePage.clickOnDashboard();
		appHome = dashboard.clickOnMyApp();
		appBasicInfo = appHome.clickOnSettings();
		String clientIDOfUser = appBasicInfo.getClientID();
		appBasicInfo.clickOnViewClientSecretLink();
		String clientSecretKey = appBasicInfo.getClientSecretKey();
		String redirectUri = appBasicInfo.getRedirectUri();
		System.out.println(clientIDOfUser + "&" + clientSecretKey + "&" + redirectUri);
		ApiRegistrationDetailsGenerator.getClientIdSecretKeyRedirectUri(clientIDOfUser, clientSecretKey, redirectUri);
		Assert.assertEquals("ba0e644545524576a7ac73041f60b1c6", clientIDOfUser, "ClientID is not correct");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
