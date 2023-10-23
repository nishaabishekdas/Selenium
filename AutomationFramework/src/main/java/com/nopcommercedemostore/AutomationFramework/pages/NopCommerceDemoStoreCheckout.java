package com.nopcommercedemostore.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreCheckout extends TestBase {
	Select sc;

	public NopCommerceDemoStoreCheckout() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#BillingNewAddress_FirstName")
	private WebElement billingFirstNameTxtBx;

	@FindBy(css = "#BillingNewAddress_LastName")
	private WebElement billingLastNameTxtBx;

	@FindBy(css = "#BillingNewAddress_Email")
	private WebElement billingEmailAddressTxtBx;

	@FindBy(css = "#BillingNewAddress_Company")
	private WebElement billingCompanyTxtBx;

	@FindBy(css = "#BillingNewAddress_CountryId")
	private WebElement billingCountryDrpDwn;

	@FindBy(css = "#BillingNewAddress_City")
	private WebElement billingCityTxtBx;

	@FindBy(css = "#BillingNewAddress_Address1")
	private WebElement billingAddressTxtBx;

	@FindBy(css = "#BillingNewAddress_ZipPostalCode")
	private WebElement billingZipCodeTxtBx;

	@FindBy(css = "#BillingNewAddress_PhoneNumber")
	private WebElement billingPhoneNumberTxtBx;

	@FindBy(css = "#billing-buttons-container button:last-of-type")
	private WebElement billingContinueBtn;

	// SHIPPING METHOD
	@FindBy(css = "#shippingoption_0")
	private WebElement groundRadioBtn;

	@FindBy(css = "#shipping-method-buttons-container button")
	private WebElement shippingMethodContinueBtn;

	// PAYMENT METHOD

	@FindBy(css = "#paymentmethod_1")
	private WebElement creditCardRadioBtn;

	@FindBy(css = "#payment-method-buttons-container button")
	private WebElement paymentContinueBtn;

	// PAYMENT INFORMATION

	@FindBy(css = "#CreditCardType")
	private WebElement creditCardTpeDrpDwnBtn;

	@FindBy(css = "#CardholderName")
	private WebElement cardHolderNameTxtBx;

	@FindBy(css = "#CardNumber")
	private WebElement cardNumberTxtBx;

	@FindBy(css = "#ExpireMonth")
	private WebElement expiryMonthDrpDwnBtn;

	@FindBy(css = "#ExpireYear")
	private WebElement expiryYearDrpDwnBtn;

	@FindBy(css = "#CardCode")
	private WebElement cardCodeTxtBx;

	@FindBy(css = "#payment-info-buttons-container button")
	private WebElement paymentInfoContinueBtn;

	// CONFIRM ORDER

	@FindBy(css = "#confirm-order-buttons-container button")
	private WebElement confirmOrderBtn;


	public void enterFirstName() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingFirstNameTxtBx)));
		billingFirstNameTxtBx.sendKeys("Nisha");
	}

	public void enterLastName() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingLastNameTxtBx)));
		billingLastNameTxtBx.sendKeys("Mohandas");
	}

	public void enterEmailAddress() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingEmailAddressTxtBx)));
		billingEmailAddressTxtBx.sendKeys("nisha@gmail.com");
	}

	public void enterCompanyName() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingCompanyTxtBx)));
		billingCompanyTxtBx.sendKeys("Pivot");
	}

	public void clickCountryName() {
		sc = new Select(wait.until(ExpectedConditions.visibilityOf(billingCountryDrpDwn)));
		sc.selectByValue("158");
	}

	public void enterCityName() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingCityTxtBx)));
		billingCityTxtBx.sendKeys("Brampton");
	}

	public void enterAddress() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingAddressTxtBx)));
		billingAddressTxtBx.sendKeys("27 brampton Street");
	}

	public void enterZipCode() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingZipCodeTxtBx)));
		billingZipCodeTxtBx.sendKeys("L6Y3M5");
	}

	public void enterPhoneNumber() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(billingPhoneNumberTxtBx)));
		billingPhoneNumberTxtBx.sendKeys("123456789");
	}

	public NopCommerceDemoStoreCheckout clickbillingContinueBtn() {
		wait.until(ExpectedConditions.visibilityOf(billingContinueBtn)).click();
		return new NopCommerceDemoStoreCheckout();
	}

	public void clickGroundRadioBtn() {
		wait.until(ExpectedConditions.visibilityOf(groundRadioBtn)).click();
		;
	}

	public NopCommerceDemoStoreCheckout clickShippingMethodContinueBtn() {
		wait.until(ExpectedConditions.visibilityOf(shippingMethodContinueBtn)).click();
		return new NopCommerceDemoStoreCheckout();
	}

	public void clickCreditCardRadioBtn() {
		wait.until(ExpectedConditions.visibilityOf(creditCardRadioBtn)).click();
	}

	public NopCommerceDemoStoreCheckout clickPaymentContinueBtn() {
		wait.until(ExpectedConditions.visibilityOf(paymentContinueBtn)).click();
		return new NopCommerceDemoStoreCheckout();
	}

	public void clickCreditCardTpeDrpDwnBtn() {
		sc = new Select(wait.until(ExpectedConditions.visibilityOf(creditCardTpeDrpDwnBtn)));
		sc.selectByValue("visa");
	}

	public void entecardHolderName() {
		wait.until(ExpectedConditions.visibilityOf(cardHolderNameTxtBx)).sendKeys("Nisha Mohandas");
	}

	public void enterCardNumber() {
		wait.until(ExpectedConditions.visibilityOf(cardNumberTxtBx)).sendKeys("11111111111111111111");
	}

	public void clickExpiryMonthDrpDwnBtn() {
		sc = new Select(wait.until(ExpectedConditions.visibilityOf(expiryMonthDrpDwnBtn)));
		sc.selectByValue("8");
	}

	public void clickExpiryYearDrpDwnBtn() {
		sc = new Select(wait.until(ExpectedConditions.visibilityOf(expiryYearDrpDwnBtn)));
		sc.selectByValue("2033");
	}

	public void entercardCode() {
		wait.until(ExpectedConditions.visibilityOf(cardCodeTxtBx)).sendKeys("123");
	}

	public NopCommerceDemoStoreCheckout clickpaymentInfoContinueBtn() {
		wait.until(ExpectedConditions.visibilityOf(paymentInfoContinueBtn)).click();
		return new NopCommerceDemoStoreCheckout();
	}

	public NopCommerceDemoStoreCheckoutSuccess clickconfirmOrderBtn() {
		wait.until(ExpectedConditions.visibilityOf(confirmOrderBtn)).click();
		return new NopCommerceDemoStoreCheckoutSuccess();
	}

	public NopCommerceDemoStoreCheckoutSuccess enterCheckoutDetails() {
		enterFirstName();
		enterLastName();
		enterEmailAddress();
		enterCompanyName();
		clickCountryName();
		enterCityName();
		enterAddress();
		enterZipCode();
		enterPhoneNumber();
		clickbillingContinueBtn();
		clickGroundRadioBtn();
		clickShippingMethodContinueBtn();
		clickCreditCardRadioBtn();
		clickPaymentContinueBtn();
		clickCreditCardTpeDrpDwnBtn();
		entecardHolderName();
		enterCardNumber();
		clickExpiryMonthDrpDwnBtn();
		clickExpiryYearDrpDwnBtn();
		entercardCode();
		clickpaymentInfoContinueBtn();
		return clickconfirmOrderBtn();
	}
}
