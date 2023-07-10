package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class LaptopsAndNotebooks extends TestBase {
	List<WebElement> list;
	private By locatorOfHomePageTopMenuList = By.cssSelector("ul.list-inline>li");

	public LaptopsAndNotebooks() {
		PageFactory.initElements(wd, this);
	}

	private By addToWishListBtnOfAllLaptopsAndNoteBooks = By
			.cssSelector("div.product-thumb button[data-original-title='Add to Wish List']");

	public LaptopsAndNotebooks clickOnAddToWhishListOfAllLaptopsAndNoteBooks() {
		list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addToWishListBtnOfAllLaptopsAndNoteBooks));
		for (WebElement element : list) {
			element.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new LaptopsAndNotebooks();
	}

	public WebElement getWishListItems() {
		WebElement itemAddedToWishList = null;
		try {
			itemAddedToWishList = getWebElementsFromCommonLocator(locatorOfHomePageTopMenuList, "Wish List (5)");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return itemAddedToWishList;
	}

	public MyWishList clickOnMyWishListItems() {
		WebElement wishListLink = getWishListItems();
		wishListLink.click();
		return new MyWishList();
	}

	public WebElement getWebElementsFromCommonLocator(By locator, String webElementName) {
		list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		for (WebElement element : list) {
			System.out.println(element.getText());
			if (element.getText().equals(webElementName)) {
				return element;
			}
		}
		return null;
	}
}
