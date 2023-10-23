package com.nopcommercedemostore.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStore;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreCellPhones;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreCheckout;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreCheckoutSuccess;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreHtcOneMiniBlue;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreLogin;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreRegister;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreRegisterResult;
import com.nopcommercedemostore.AutomationFramework.pages.NopCommerceDemoStoreShoppingCart;

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
		homePage = loginPage.loginToPortal(registerPage.getEmailId());
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
