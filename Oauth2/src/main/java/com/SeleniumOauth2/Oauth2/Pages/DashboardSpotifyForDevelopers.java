package com.SeleniumOauth2.Oauth2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class DashboardSpotifyForDevelopers extends TestBase {
	public DashboardSpotifyForDevelopers() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "a[class='sc-94cc1fb0-5 hEmWyg']")
	private WebElement myApp;

	public MyAppHome clickOnMyApp() {
		wait.until(ExpectedConditions.elementToBeClickable(myApp)).click();
		return new MyAppHome();
	}

}
