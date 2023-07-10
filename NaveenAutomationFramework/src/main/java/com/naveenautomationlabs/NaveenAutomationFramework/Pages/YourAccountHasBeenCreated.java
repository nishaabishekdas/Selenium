package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class YourAccountHasBeenCreated extends TestBase {
	public YourAccountHasBeenCreated() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.buttons a")
	private WebElement registerSuccessContinueBtn;

	public MyAccount clickOnRegisterSuccessContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(registerSuccessContinueBtn)).click();
		return new MyAccount();
	}
}
