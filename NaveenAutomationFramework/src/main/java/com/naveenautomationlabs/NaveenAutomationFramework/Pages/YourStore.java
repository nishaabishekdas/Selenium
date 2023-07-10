package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class YourStore extends TestBase {
	List<WebElement> list;

	public YourStore() {
		PageFactory.initElements(wd, this);
	}

	private By locatorOfHomePageTopMenuList = By.cssSelector("ul.list-inline>li");
	private By locatorOfFeaturedObjects = By.cssSelector("div.product-layout div.caption  a");

	private By locatorForRegLogin = By.cssSelector("ul.dropdown-menu-right li");

	public YourStore clickOnMyAccountDrpDwnBtn() {
		try {
			WebElement myAccountDrpDwnBtn = getWebElementsFromCommonLocator(locatorOfHomePageTopMenuList, "My Account");
			myAccountDrpDwnBtn.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return new YourStore();
	}

	public RegisterAccount clickOnRegisterBtn() {
		clickOnMyAccountDrpDwnBtn();
		try {
			WebElement RegisterBtn = getWebElementsFromCommonLocator(locatorForRegLogin, "Register");
			RegisterBtn.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return new RegisterAccount();
	}

	public AccountLogin clickOnLoginBtn() {
		clickOnMyAccountDrpDwnBtn();
		try {
			WebElement LoginBtn = getWebElementsFromCommonLocator(locatorForRegLogin, "Login");
			LoginBtn.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return new AccountLogin();
	}

	public MacBook clickOnMackBookLink() {
		try {
			WebElement macBookLink = getWebElementsFromCommonLocator(locatorOfFeaturedObjects, "MacBook");
			macBookLink.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return new MacBook();
	}

	public WebElement getWebElementsFromCommonLocator(By locator, String webElementName) {
		list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		for (WebElement element : list) {
			if (element.getText().equals(webElementName)) {
				return element;
			}
		}
		return null;
	}

}
