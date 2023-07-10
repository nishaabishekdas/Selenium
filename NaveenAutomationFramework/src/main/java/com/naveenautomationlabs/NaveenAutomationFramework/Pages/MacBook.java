package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class MacBook extends TestBase {
	public MacBook() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.col-sm-4 h1")
	private WebElement macBookTextTitle;

	public String getMacBookTextTitle() {
		wait.until(ExpectedConditions.visibilityOf(macBookTextTitle));
		return macBookTextTitle.getText();
	}
}
