package com.SeleniumOauth2.Oauth2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "button[class='Button-sc-1dqy6lx-0 dqXudP']")
	private WebElement loginButton;

	public LoginSpotify clickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		return new LoginSpotify();
	}
}
