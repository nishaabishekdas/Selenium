package com.SeleniumOauth2.Oauth2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class LoginSpotify extends TestBase {

	public LoginSpotify() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[id='login-username']")
	private WebElement userLoginTxtBx;

	@FindBy(css = "input[id='login-password']")
	private WebElement passwordTxtBx;

	@FindBy(css = "button[id='login-button']")
	private WebElement loginBtn;

	public void enterLoginId() {
		wait.until(ExpectedConditions.elementToBeClickable(userLoginTxtBx)).clear();
		userLoginTxtBx.sendKeys("nishaabishek0312@gmail.com");

	}

	public void enterLoginPassword() {
		wait.until(ExpectedConditions.elementToBeClickable(passwordTxtBx)).clear();
		passwordTxtBx.sendKeys("Winter@123");

	}

	public HomeSpotifyForDevelopers clickOnLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		return new HomeSpotifyForDevelopers();
	}

	public HomeSpotifyForDevelopers loginToSpotify() {
		enterLoginId();
		enterLoginPassword();
		clickOnLoginBtn();
		return new HomeSpotifyForDevelopers();
	}
}
