package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class MyAccount extends TestBase {
	List<WebElement> list;

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h2:first-of-type")
	private WebElement myAccountText;
	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopsAndNoteBookBtn;

	private By locatorOfHomePageTopMenuList = By.cssSelector("ul.list-inline>li");
	private By blueMenuBar = By.cssSelector("ul.nav>li>a");

	public String getmyAccountText() {
		wait.until(ExpectedConditions.visibilityOf(myAccountText));
		return myAccountText.getText();
	}

	public MyWishList clickOnWishList() {
		try {
			WebElement wishListBtn = getWebElementsFromCommonLocator(locatorOfHomePageTopMenuList, "Wish List (0)");
			wishListBtn.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return new MyWishList();
	}

	public void moveCursorToLaptopsAndNotebooksDrpDwn() {
		Actions ac = new Actions(wd);
		try {
			WebElement laptopAndNotebooksDrpDwn = getWebElementsFromCommonLocator(blueMenuBar, "Laptops & Notebooks");
			ac.moveToElement(laptopAndNotebooksDrpDwn).perform();

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public LaptopsAndNotebooks clickOnShowAllLaptopsAndNoteBookBtnFromDrpDwn() {
		moveCursorToLaptopsAndNotebooksDrpDwn();
		wait.until(ExpectedConditions.elementToBeClickable(showAllLaptopsAndNoteBookBtn)).click();
		return new LaptopsAndNotebooks();
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
