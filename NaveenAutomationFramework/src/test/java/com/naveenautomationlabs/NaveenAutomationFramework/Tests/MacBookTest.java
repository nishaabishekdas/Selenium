package com.naveenautomationlabs.NaveenAutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.NaveenAutomationFramework.Pages.MacBook;
import com.naveenautomationlabs.NaveenAutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class MacBookTest extends TestBase {
	public YourStore yourStorePage;
	public MacBook macBookPage;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStorePage = new YourStore();
	}

	@Test
	public void validateMacBookPage() {
		macBookPage = yourStorePage.clickOnMackBookLink();
		Assert.assertEquals(macBookPage.getMacBookTextTitle(), "MacBook", "Wrong Page is Loaded");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
