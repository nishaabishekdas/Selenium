package com.SeleniumOauth2.Oauth2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class MyAppHome extends TestBase {
	public MyAppHome() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "a[class='Button-sc-y0gtbx-0 eVPaRV']")
	private WebElement settings;

	public MyAppBasicInformation clickOnSettings() {
		wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
		return new MyAppBasicInformation();
	}
}
