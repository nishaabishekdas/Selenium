package com.nopcommercedemostore.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreHtcOneMiniBlue extends TestBase {
	public NopCommerceDemoStoreHtcOneMiniBlue() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.add-to-cart-panel #add-to-cart-button-19")
	private WebElement addToCartButton;

	@FindBy(css = "#bar-notification a")
	private WebElement shoppingCartLink;

	public NopCommerceDemoStoreHtcOneMiniBlue clickAddToCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
		return new NopCommerceDemoStoreHtcOneMiniBlue();
	}

	public NopCommerceDemoStoreShoppingCart clickShoppingCartLink() {
		clickAddToCartButton();
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
		return new NopCommerceDemoStoreShoppingCart();
	}
}
