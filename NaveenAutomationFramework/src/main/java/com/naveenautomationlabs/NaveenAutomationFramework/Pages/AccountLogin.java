package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class AccountLogin extends TestBase {
	List<WebElement> list;

	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}

	private By locatorOfEmailAndPassword = By.cssSelector("#content>div.row>div:nth-of-type(2) div.form-group input");
	@FindBy(css = "#content>div.row>div:nth-of-type(2) form>input")
	private WebElement loginBtn;

	public void enteremailId() {
		try {
			WebElement emailTxtBx = getWebElementsFromCommonLocator(locatorOfEmailAndPassword, "email");
			emailTxtBx.clear();
			emailTxtBx.sendKeys("nishatest123@gmail.com");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword() {
		try {
			WebElement passwordTxtBx = getWebElementsFromCommonLocator(locatorOfEmailAndPassword, "password");
			passwordTxtBx.clear();
			passwordTxtBx.sendKeys("Password@1");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public MyAccount clickOnLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).submit();
		return new MyAccount();
	}

	public MyAccount loginToPortal() {
		enteremailId();
		enterPassword();
		return clickOnLogin();
	}

	public WebElement getWebElementsFromCommonLocator(By locator, String webElementName) {
		list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		for (WebElement element : list) {
			if (element.getAttribute("name").equals(webElementName)) {
				return element;
			}
		}
		return null;
	}
}
