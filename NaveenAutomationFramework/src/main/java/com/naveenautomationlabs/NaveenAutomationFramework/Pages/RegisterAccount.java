package com.naveenautomationlabs.NaveenAutomationFramework.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class RegisterAccount extends TestBase {
	List<WebElement> list;
	Random rd = new Random();
	public int emailNum = rd.nextInt() * 2;
	public String emailAddress = "nishamohan" + emailNum + "@gmail.com";
	public String password = "Password1";

	public RegisterAccount() {
		PageFactory.initElements(wd, this);
	}

	private By locatorOfPersonalDetails = By.cssSelector("fieldset[id='account'] div.col-sm-10 input");
	private By locatorOfYourPasswordFieldSet = By.cssSelector("form.form-horizontal>fieldset:nth-of-type(2) input ");

	@FindBy(css = "div.col-sm-10>label:last-of-type")
	private WebElement NewsLetterNoRadioBtn;
	@FindBy(css = "div.buttons input:first-of-type")
	private WebElement AgreechkBx;
	@FindBy(css = "div.buttons input:last-of-type")
	private WebElement registerContinueBtn;

	public void enterFirstName() {
		try {
			WebElement firstNameTxtBx = getWebElementsFromCommonLocator(locatorOfPersonalDetails, "firstname");
			firstNameTxtBx.clear();
			firstNameTxtBx.sendKeys("Nisha");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void enterLastName() {
		try {
			WebElement lastNameTxtBx = getWebElementsFromCommonLocator(locatorOfPersonalDetails, "lastname");
			lastNameTxtBx.clear();
			lastNameTxtBx.sendKeys("Mohandas");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void enterEmailId() {
		try {
			WebElement emailTxtBx = getWebElementsFromCommonLocator(locatorOfPersonalDetails, "email");
			emailTxtBx.clear();
			emailTxtBx.sendKeys(emailAddress);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void enterTelephoneNumber() {
		try {
			WebElement telephoneTxtBx = getWebElementsFromCommonLocator(locatorOfPersonalDetails, "telephone");
			telephoneTxtBx.clear();
			telephoneTxtBx.sendKeys("1234567890");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword() {
		try {
			WebElement passwordTxtBx = getWebElementsFromCommonLocator(locatorOfYourPasswordFieldSet, "password");
			passwordTxtBx.clear();
			passwordTxtBx.sendKeys(password);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void enterConfirmPassword() {
		try {
			WebElement confirmPasswordTxtBx = getWebElementsFromCommonLocator(locatorOfYourPasswordFieldSet, "confirm");
			confirmPasswordTxtBx.clear();
			confirmPasswordTxtBx.sendKeys(password);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void clickOnNewsLetterRadioButton() {
		wait.until(ExpectedConditions.elementToBeClickable(NewsLetterNoRadioBtn)).click();
	}

	public void clickOnAgreeChkBx() {
		wait.until(ExpectedConditions.elementToBeClickable(AgreechkBx)).click();
	}

	public YourAccountHasBeenCreated clickRegisterCntinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(registerContinueBtn)).submit();
		return new YourAccountHasBeenCreated();
	}

	public WebElement getWebElementsFromCommonLocator(By locator, String webElementName) {
		list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		for (WebElement element : list) {
			if (element.getAttribute("name").equals(webElementName)) {
				return element;
			}
		}
		return null;
	}

	public YourAccountHasBeenCreated Register() {
		enterFirstName();
		enterLastName();
		enterEmailId();
		enterTelephoneNumber();
		enterPassword();
		enterConfirmPassword();
		clickOnNewsLetterRadioButton();
		clickOnAgreeChkBx();
		return clickRegisterCntinueBtn();
	}
}
