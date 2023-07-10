package com.naveenautomationlabs.NaveenAutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.NaveenAutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.LaptopsAndNotebooks;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.MyWishList;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.MyWishList.MyWishListTable;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class MyWishListTest extends TestBase {
	public YourStore yourStorePage;
	public MyAccount myAccountPage;
	public AccountLogin loginPage;
	public LaptopsAndNotebooks laptopsAndNotebooksPage;
	public MyWishList myWishListPage;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStorePage = new YourStore();
	}

	@Test
	public void validateItemsCanRemoveFromWishList() {
		loginPage = yourStorePage.clickOnLoginBtn();
		myAccountPage = loginPage.loginToPortal();
		laptopsAndNotebooksPage = myAccountPage.clickOnShowAllLaptopsAndNoteBookBtnFromDrpDwn();
		laptopsAndNotebooksPage.clickOnAddToWhishListOfAllLaptopsAndNoteBooks();
		myWishListPage = laptopsAndNotebooksPage.clickOnMyWishListItems();
		myWishListPage.clickOnRemoveBtnInWebTable(MyWishListTable.ACTION.getTableHeaderName(), "Product 18");
		Assert.assertEquals(
				myWishListPage.getWebElementFromTable(MyWishListTable.PRODUCT_NAME.getTableHeaderName(), "Product 18"),
				null, "Item is not removed");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
