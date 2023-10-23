package com.nopcommercedemostore.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreLogin extends TestBase {
	String password = "Password1";
	public NopCommerceDemoStoreLogin() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#Email")
	private WebElement emailTxtBoxAtLogin;
	
	@FindBy(css = "#Password")
	private WebElement PasswordTxtBoxAtLogin;
	
	@FindBy(css = "div.returning-wrapper>form div.buttons button")
	private WebElement loginBtn;

	public void enterEmailAddress(String emailAddress) {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(emailTxtBoxAtLogin)));
		emailTxtBoxAtLogin.sendKeys(emailAddress);
	}
	
	public void enterPassword() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(PasswordTxtBoxAtLogin)));
		PasswordTxtBoxAtLogin.sendKeys(password);
	}
	
	public NopCommerceDemoStore clickRegisterBtnAfterCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).submit();
		return new NopCommerceDemoStore();
	}
	
	public NopCommerceDemoStore loginToPortal(String emailAddress) {
		enterEmailAddress(emailAddress);
		enterPassword();
		return clickRegisterBtnAfterCheckout();
		
		
	}
}
