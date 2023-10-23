package com.nopcommercedemostore.AutomationFramework.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.nopcommercedemostore.AutomationFramework.base.TestBase;

public class NopCommerceDemoStoreRegister extends TestBase {
	Select sc;
	Random rd=new Random();
	public int emailNum=rd.nextInt()*2;
	public String emailAddress = "nishamohan"+emailNum+"@gmail.com";
	public String password = "Password1";

	public NopCommerceDemoStoreRegister() {
		PageFactory.initElements(wd, this);
		
	}

	@FindBy(css = "#gender-female")
	private WebElement genderRadioBtnAtRegister;

	@FindBy(css = "#FirstName")
	private WebElement firstNameTxtBoxAtRegister;

	@FindBy(css = "#LastName")
	private WebElement lastNameTxtBoxAtRegister;

	@FindBy(css = "div.date-picker-wrapper>select[name='DateOfBirthDay']")
	private WebElement birthDateDrpDwnBtnAtRegister;

	@FindBy(css = "div.date-picker-wrapper>select[name='DateOfBirthMonth']")
	private WebElement birthMonthDrpDwnBtnAtRegister;

	@FindBy(css = "div.date-picker-wrapper>select[name='DateOfBirthYear']")
	private WebElement birthYearDrpDwnBtnAtRegister;

	@FindBy(css = "#Email")
	private WebElement emailTxtboxAtRegister;

	@FindBy(css = "#Company")
	private WebElement companyNameTxtboxAtRegister;

	@FindBy(css = "input[id='Newsletter']")
	private WebElement newsletterCheckboxAtRegister;

	@FindBy(css = "#Password")
	private WebElement passwordTxtboxAtRegister;

	@FindBy(css = "#ConfirmPassword")
	private WebElement confirmPasswordTxtboxAtRegister;

	@FindBy(css = "#register-button")
	private WebElement registerBtnAtRegister;

	public NopCommerceDemoStoreRegister clickGenderRadioBtnAtRegister() {
		wait.until(ExpectedConditions.elementToBeClickable(genderRadioBtnAtRegister)).click();
		return new NopCommerceDemoStoreRegister();
	}

	public void enterFirstName() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(firstNameTxtBoxAtRegister)));
		firstNameTxtBoxAtRegister.sendKeys("Nisha");
	}

	public void enterLastName() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(lastNameTxtBoxAtRegister)));
		lastNameTxtBoxAtRegister.sendKeys("Mohandas");
	}

	public void clickBirthDateDrpDwnBtnAtRegister() {
		sc = new Select(wait.until(ExpectedConditions.elementToBeClickable(birthDateDrpDwnBtnAtRegister)));
		sc.selectByValue("29");
	}

	public void clickBirthMonthDrpDwnBtnAtRegister() {
		sc = new Select(wait.until(ExpectedConditions.elementToBeClickable(birthMonthDrpDwnBtnAtRegister)));
		sc.selectByValue("4");
	}

	public void clickBirthYearDrpDwnBtnAtRegister() {
		sc = new Select(wait.until(ExpectedConditions.elementToBeClickable(birthYearDrpDwnBtnAtRegister)));
		sc.selectByValue("1993");
	}

	public void enterEmailAddress() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(emailTxtboxAtRegister)));
		emailTxtboxAtRegister.sendKeys(emailAddress);
		
	}

	public void enterCompanyName() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(companyNameTxtboxAtRegister)));
		companyNameTxtboxAtRegister.sendKeys("Pivot");
	}

	public NopCommerceDemoStoreRegister clickNewsletterCheckboxAtRegister() {
		wait.until(ExpectedConditions.visibilityOf(newsletterCheckboxAtRegister)).click();
		return new NopCommerceDemoStoreRegister();
	}

	public void enterPassword() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(passwordTxtboxAtRegister)));
		passwordTxtboxAtRegister.sendKeys(password);
	}

	public void enterConfirmPassword() {
		clearInputField(wait.until(ExpectedConditions.visibilityOf(confirmPasswordTxtboxAtRegister)));
		confirmPasswordTxtboxAtRegister.sendKeys(password);
	}

	public NopCommerceDemoStoreRegisterResult clickRegisterBtnAtRegister() {
		wait.until(ExpectedConditions.elementToBeClickable(registerBtnAtRegister)).click();
		return new NopCommerceDemoStoreRegisterResult();
	}	
	public String getEmailId() {
		return emailAddress;
	}
	public NopCommerceDemoStoreRegisterResult registerUserAccount() {
		clickGenderRadioBtnAtRegister();
		enterFirstName();
		enterLastName();
		clickBirthDateDrpDwnBtnAtRegister();
		clickBirthMonthDrpDwnBtnAtRegister();
		clickBirthYearDrpDwnBtnAtRegister();
		enterEmailAddress();
		enterCompanyName();
		clickNewsletterCheckboxAtRegister();
		enterPassword();
		enterConfirmPassword();
		return clickRegisterBtnAtRegister();
	}
}
