package com.naveenautomationlab.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlab.AutomationFramework.base.TestBase;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStore;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreCellPhones;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreCheckout;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreCheckoutSuccess;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreHtcOneMiniBlue;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreLogin;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreRegister;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreRegisterResult;
import com.naveenautomationlab.AutomationFramework.pages.NopCommerceDemoStoreShoppingCart;

public class NopCommerceDemoStoreCheckoutSuccessTest extends TestBase {
	NopCommerceDemoStore homePage;
	NopCommerceDemoStoreRegister registerPage;
	NopCommerceDemoStoreRegisterResult registerSuccessPage;
	NopCommerceDemoStoreLogin loginPage;
	NopCommerceDemoStoreCellPhones cellPhonePage;
	NopCommerceDemoStoreHtcOneMiniBlue htcPhonePage;
	NopCommerceDemoStoreShoppingCart shoppingCartPage;
	NopCommerceDemoStoreCheckout checkOutPage;
	NopCommerceDemoStoreCheckoutSuccess checkOutSuccessPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new NopCommerceDemoStore();
	}

	@Test
	public void validateCheckOut() {
		registerPage = homePage.clickRegisterButton();
		registerSuccessPage = registerPage.registerUserAccount();
		homePage = registerSuccessPage.clickRegistrationSuccessContinueBtn();
		loginPage = homePage.clickLoginButton();
		homePage=loginPage.loginToPortal(registerPage.getEmailId());
		cellPhonePage = homePage.clickCellPhoneBtnInDrpDwn();
		htcPhonePage = cellPhonePage.htcOneMiniBlueLinkclick();
		shoppingCartPage = htcPhonePage.clickShoppingCartLink();
		checkOutPage = shoppingCartPage.clickCheckoutChekboxBtn();
		checkOutSuccessPage = checkOutPage.enterCheckoutDetails();
		String finalCheckOutResultMessage = checkOutSuccessPage.getOrderConfirmationTxtMsg();
		Assert.assertEquals(finalCheckOutResultMessage, "Your order has been successfully processed!",
				"Checkout Failed");

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
