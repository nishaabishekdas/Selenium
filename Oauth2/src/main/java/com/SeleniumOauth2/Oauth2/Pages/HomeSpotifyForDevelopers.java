package com.SeleniumOauth2.Oauth2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class HomeSpotifyForDevelopers extends TestBase {
	public HomeSpotifyForDevelopers() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "button[class='sc-e81d303a-1 cAPMvo']")
	private WebElement nishaDropDwnBtn;

	@FindBy(css = "a[href='/dashboard']")
	private WebElement dashboardBtn;

	public void clickOnnishaDropDwnBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(nishaDropDwnBtn)).click();
	}

	public DashboardSpotifyForDevelopers clickOnDashboard() {
		wait.until(ExpectedConditions.elementToBeClickable(dashboardBtn)).click();
		return new DashboardSpotifyForDevelopers();
	}
}
