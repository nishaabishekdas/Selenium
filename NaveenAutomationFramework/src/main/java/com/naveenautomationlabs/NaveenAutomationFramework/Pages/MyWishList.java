package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class MyWishList extends TestBase {
	List<WebElement> list;

	public MyWishList() {
		PageFactory.initElements(wd, this);
	}

	private By locatorOfAllHeaderNames = By.cssSelector("table thead tr td");
	private By locatorOfAlllRows = By.cssSelector("table tbody tr");

	public enum MyWishListTable {
		IMAGE("Image"), PRODUCT_NAME("Product Name"), MODEL("Model"), STOCK("Stock"), UNIT_PRICE("Unit Price"),
		ACTION("Action");

		String value;

		private MyWishListTable(String value) {
			this.value = value;
		}

		public String getTableHeaderName() {
			return value;
		}
	}

	// finding index of column

	public int getIndexOfColumn(String headerElementName) {
		list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorOfAllHeaderNames));
		for (WebElement element : list) {
			if (element.getText().equals(headerElementName)) {
				return list.indexOf(element);
			}
		}
		return -1;
	}

	// get web Element from table

	public WebElement getWebElementFromTable(String headerElementName, String uniqueTableField) {
		int indexOfHeader = getIndexOfColumn(headerElementName);
		List<WebElement> cellList;
		list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorOfAlllRows));
		for (int i = 0; i < list.size(); i++) {
			cellList = list.get(i).findElements(By.cssSelector("td"));
			if (cellList.get(i).getText().equals(uniqueTableField)) {
				return cellList.get(indexOfHeader);
			}
		}
		return null;
	}

	public MyWishList clickOnRemoveBtnInWebTable(String headerElementName, String uniqueTableField) {
		WebElement webElementContainsRemoveBtn = getWebElementFromTable(headerElementName, uniqueTableField);
		webElementContainsRemoveBtn.findElement(By.cssSelector("a[data-original-title='Remove']")).click();
		return new MyWishList();
	}
}
