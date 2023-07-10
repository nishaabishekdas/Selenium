package com.naveenautomationlabs.NaveenAutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.NaveenAutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.LaptopsAndNotebooks;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class LaptopsAndNotebooksTest extends TestBase {
	public YourStore yourStorePage;
	public MyAccount myAccountPage;
	public AccountLogin loginPage;
	public LaptopsAndNotebooks laptopsAndNotebooksPage;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStorePage = new YourStore();
	}

	@Test
	public void validateWhishListCount() {
		loginPage = yourStorePage.clickOnLoginBtn();
		myAccountPage = loginPage.loginToPortal();
		laptopsAndNotebooksPage = myAccountPage.clickOnShowAllLaptopsAndNoteBookBtnFromDrpDwn();
		laptopsAndNotebooksPage.clickOnAddToWhishListOfAllLaptopsAndNoteBooks();
		String wishListItems = laptopsAndNotebooksPage.getWishListItems().getText();
		Assert.assertEquals(wishListItems, "Wish List (5)", "Error in adding items to wishlist");

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
