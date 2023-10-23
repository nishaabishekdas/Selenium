package com.nopcommercedemostore.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreShoppingCart extends TestBase {
	public NopCommerceDemoStoreShoppingCart() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[name='termsofservice']")
	private WebElement agreeCheckBox;

	@FindBy(css = "button[name='checkout']")
	private WebElement checkoutChekboxBtn;

	public NopCommerceDemoStoreShoppingCart clickAgreeCheckBox() {
		wait.until(ExpectedConditions.visibilityOf(agreeCheckBox)).click();
		return new NopCommerceDemoStoreShoppingCart();
	}

	public NopCommerceDemoStoreCheckout clickCheckoutChekboxBtn() {
		clickAgreeCheckBox();
		wait.until(ExpectedConditions.elementToBeClickable(checkoutChekboxBtn)).click();
		return new NopCommerceDemoStoreCheckout();
	}
}
