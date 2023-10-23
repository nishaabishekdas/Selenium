package com.nopcommercedemostore.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreCheckoutSuccess extends TestBase {
	public NopCommerceDemoStoreCheckoutSuccess() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.order-completed>div.title strong")
	private WebElement orderConfirmationTxtMsg;
	
	@FindBy(css = "div.order-completed>div.buttons button")
	private WebElement checkoutSuccessContinueBtn;

	public String getOrderConfirmationTxtMsg() {
		String orderSuccessMsg = wait.until(ExpectedConditions.visibilityOf(orderConfirmationTxtMsg)).getText();
		return orderSuccessMsg;
	}
	
	public NopCommerceDemoStore clickCheckoutSuccessContinueBtn() {
		wait.until(ExpectedConditions.visibilityOf(checkoutSuccessContinueBtn)).click();
		return new NopCommerceDemoStore();
	}
}
