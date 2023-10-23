package com.nopcommercedemostore.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreRegisterResult extends TestBase {
	public NopCommerceDemoStoreRegisterResult() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.result")
	private WebElement registrationSuccessTextMsg;
	@FindBy(css = "div.buttons a")
	private WebElement registrationSuccessContinueBtn;

	public String getRegistrationSuccessTextMsg() {
		String retrievedSuccessMsg = wait.until(ExpectedConditions.visibilityOf(registrationSuccessTextMsg)).getText();
		return retrievedSuccessMsg;
	}

	public NopCommerceDemoStore clickRegistrationSuccessContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(registrationSuccessContinueBtn)).click();
		return new NopCommerceDemoStore();
	}
}
