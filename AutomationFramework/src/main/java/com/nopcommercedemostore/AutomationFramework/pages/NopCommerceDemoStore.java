package com.nopcommercedemostore.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStore extends TestBase {
	public NopCommerceDemoStore() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.header-links li:first-of-type a")
	private WebElement registerButton;
	@FindBy(css = "div.header-links li:nth-of-type(2) a")
	private WebElement loginButton;

	@FindBy(css = "ul.notmobile>li:nth-of-type(2)>a")
	private WebElement electronicsDrpDwnBtn;
	@FindBy(css = "ul.notmobile>li:nth-of-type(2)>ul:first-of-type li:nth-of-type(2) a")
	private WebElement cellPhoneBtnInDrpDwn;

	public NopCommerceDemoStoreRegister clickRegisterButton() {
		wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
		return new NopCommerceDemoStoreRegister();
	}

	public NopCommerceDemoStoreLogin clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		return new NopCommerceDemoStoreLogin();
	}

	public NopCommerceDemoStore clickElectronicsDrpDwnBtn() {
		Actions ac=new Actions(wd);
		ac.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(electronicsDrpDwnBtn))).perform();
		return new NopCommerceDemoStore();
	}

	public NopCommerceDemoStoreCellPhones clickCellPhoneBtnInDrpDwn() {
		clickElectronicsDrpDwnBtn();
		wait.until(ExpectedConditions.visibilityOf(cellPhoneBtnInDrpDwn)).click();
		return new NopCommerceDemoStoreCellPhones();
	}
}
