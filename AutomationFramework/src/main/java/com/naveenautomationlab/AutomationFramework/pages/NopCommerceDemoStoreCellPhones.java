package com.naveenautomationlab.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlab.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreCellPhones extends TestBase {
	public NopCommerceDemoStoreCellPhones() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.item-grid>div:nth-of-type(2) h2:first-of-type a")
	private WebElement htcOneMiniBlueLink;

	public NopCommerceDemoStoreHtcOneMiniBlue htcOneMiniBlueLinkclick() {
		wait.until(ExpectedConditions.visibilityOf(htcOneMiniBlueLink)).click();
		return new NopCommerceDemoStoreHtcOneMiniBlue();
	}
}
