package com.naveenautomationlabs.NaveenAutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.NaveenAutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.RegisterAccount;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.YourAccountHasBeenCreated;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class MyAccountTest extends TestBase {
	public YourStore yourStorePage;
	public RegisterAccount RegisterAccountPage;
	public YourAccountHasBeenCreated regSuccessPage;
	public MyAccount myAccountPage;
	public AccountLogin loginPage;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStorePage = new YourStore();
	}

	@Test
	public void validateLoginToPortalAfterRegistration() {
		RegisterAccountPage = yourStorePage.clickOnRegisterBtn();
		regSuccessPage = RegisterAccountPage.Register();
		myAccountPage = regSuccessPage.clickOnRegisterSuccessContinueBtn();
		Assert.assertEquals(myAccountPage.getmyAccountText(), "My Account", "Wrong Page is Loaded");
	}

	@Test
	public void validateLoginWithValidCredential() {
		loginPage = yourStorePage.clickOnLoginBtn();
		myAccountPage = loginPage.loginToPortal();
		Assert.assertEquals(myAccountPage.getmyAccountText(), "My Account", "Wrong Page is Loaded");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
