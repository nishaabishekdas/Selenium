package org.maven.naveen.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterAccount {
	WebDriver wd;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\ChromeDriver\\\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		wd.manage().window().maximize();
		wait = new WebDriverWait(wd, 10);
	}

	@Test
	public void register() {
		WebElement myAccountMenu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@title='My Account' and @class='dropdown-toggle']")));
		myAccountMenu.click();
		WebElement registerTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Register']")));
		registerTab.click();
		boolean isTitleOnRegister = wait.until(ExpectedConditions.titleIs("Register Account"));
		Assert.assertTrue(isTitleOnRegister, "Wrong page is loaded");
		WebElement firstName = wait
				.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#input-firstname"))));
		firstName.sendKeys("Nisha");
		String retrieveFirstName = firstName.getAttribute("value");
		Assert.assertEquals(retrieveFirstName, "Nisha", "Name is not correct");
		WebElement lastName = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-lastname")));
		lastName.sendKeys("Mohandas");
		String retrieveLastName = lastName.getAttribute("value");
		Assert.assertEquals(retrieveLastName, "Mohandas", "Last Name is not correct");
		WebElement emailID = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		emailID.sendKeys("nishaMohandas@email.com");
		String retrieveEmailID = emailID.getAttribute("value");
		Assert.assertEquals(retrieveEmailID, "nishaMohandas@email.com", "Email is not correct");
		WebElement telephone = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-telephone")));
		telephone.sendKeys("1234567890");
		String retrieveTelephone = telephone.getAttribute("value");
		Assert.assertEquals(retrieveTelephone, "1234567890", "Telephone number is not correct");
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		password.sendKeys("Password@5");
		String retrievePassword = password.getAttribute("value");
		Assert.assertEquals(retrievePassword, "Password@5", "Password is not correct");
		WebElement confirmPassword = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-confirm")));
		confirmPassword.sendKeys("Password@5");
		String retrieveConfirmPassword = confirmPassword.getAttribute("value");
		Assert.assertEquals(retrieveConfirmPassword, "Password@5", "Confirm Password is not correct");
		WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(wd.findElement(
				By.xpath("(//div[@class='col-sm-10']//label[@class='radio-inline'])[2]//input[@name='newsletter']"))));
		radioButton.click();
		boolean isNo = radioButton.isSelected();
		Assert.assertTrue(isNo, "Radio button No is not selected");
		WebElement privacyCheckBox = wait
				.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//input[@name='agree']"))));
		privacyCheckBox.click();
		boolean isChecked = privacyCheckBox.isSelected();
		Assert.assertTrue(isChecked, "Privacy Checkbox is not selected");
		WebElement continueButton = wait
				.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//input[@value='Continue']"))));
		boolean isContinue = continueButton.isDisplayed();
		Assert.assertTrue(isContinue, "Continue button is not displayed");
		continueButton.submit();
		boolean isTitle = wait.until(ExpectedConditions.titleIs(wd.getTitle()));
		System.out.println(wd.getTitle());
		Assert.assertTrue(isTitle, "Wrong page loaded");
		WebElement webMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content h1")));
		Assert.assertEquals(webMessage.getText(), "Your Account Has Been Created!", "Message displayed is not correct");
		WebElement continueButtonOnSuccessRegister = wait
				.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//a[text()='Continue']"))));
		boolean isContinueOnSuccessRegister = continueButtonOnSuccessRegister.isDisplayed();
		Assert.assertTrue(isContinueOnSuccessRegister, "Continue button is not displayed");
		continueButtonOnSuccessRegister.click();
		boolean isTitleAfterRegister = wait.until(ExpectedConditions.titleIs("My Account"));
		Assert.assertTrue(isTitleAfterRegister, "Wrong page is loaded");

	}

	@Test
	public void login() {
		WebElement myAccountMenu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@title='My Account' and @class='dropdown-toggle']")));
		myAccountMenu.click();
		WebElement loginTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));
		loginTab.click();
		boolean isTitleOnLogin = wait.until(ExpectedConditions.titleIs("Account Login"));
		Assert.assertTrue(isTitleOnLogin, "Wrong page loaded");
		WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		username.sendKeys("nishaMohandas@email.com");
		String retrieveLastName = username.getAttribute("value");
		Assert.assertEquals(retrieveLastName, "nishaMohandas@email.com", "Username is not correct");
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		password.sendKeys("Password@5");
		String retrievePassword = password.getAttribute("value");
		Assert.assertEquals(retrievePassword, "Password@5", "Password is not correct");
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//input[@value='Login']"))));
		boolean isContinue = loginButton.isDisplayed();
		Assert.assertTrue(isContinue, "Login button is not displayed");
		loginButton.submit();
		boolean isTitleAfterLogin = wait.until(ExpectedConditions.titleIs("My Account"));
		Assert.assertTrue(isTitleAfterLogin, "Wrong page is loaded");
	}

	@Test
	public void updatePassword() {
		login();
		WebElement changePassword = wait.until(ExpectedConditions
				.elementToBeClickable(wd.findElement(By.xpath("//a[text()='Change your password']"))));
		boolean isChangePassword = changePassword.isDisplayed();
		Assert.assertTrue(isChangePassword, "change Password is not displayed");
		changePassword.click();
		boolean isTitleOnPasswedChange = wait.until(ExpectedConditions.titleIs("Change Password"));
		Assert.assertTrue(isTitleOnPasswedChange, "Wrong page is loaded");
		WebElement inputPassword = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		inputPassword.sendKeys("Password@5");
		String retrieveChangePassword = inputPassword.getAttribute("value");
		Assert.assertEquals(retrieveChangePassword, "Password@5", "Password is not correct");
		WebElement confirmPassword = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-confirm")));
		confirmPassword.sendKeys("Password@5");
		String retrieveConfirmPassword = confirmPassword.getAttribute("value");
		Assert.assertEquals(retrieveConfirmPassword, "Password@5", "Confirm Password is not correct");
		WebElement continueButtonOnPasswordUpdate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Continue']")));
		boolean isContinueOnChangePassword = continueButtonOnPasswordUpdate.isDisplayed();
		Assert.assertTrue(isContinueOnChangePassword, "Continue button is not displayed");
		continueButtonOnPasswordUpdate.submit();
		boolean isContinueOnPasswordUpdate = wait.until(ExpectedConditions.titleIs("My Account"));
		Assert.assertTrue(isContinueOnPasswordUpdate, "Wrong page is loaded");
		boolean messageAfterUpdate = wait
				.until(ExpectedConditions.textToBe(By.cssSelector("#account-account>div:nth-of-type(1)"),
						"Success: Your password has been successfully updated."));
		Assert.assertTrue(messageAfterUpdate, "Display message is not correct");
		WebElement myAccountMenu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@title='My Account' and @class='dropdown-toggle']")));
		myAccountMenu.click();
		WebElement logoutTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//a[text()='Logout']")));
		logoutTab.click();
		boolean isLogout = wait.until(ExpectedConditions.titleIs("Account Logout"));
		Assert.assertTrue(isLogout, "Wrong page is loaded");
		WebElement logoutContinue = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Continue']")));
		logoutContinue.click();
		boolean isLogoutToHome = wait.until(ExpectedConditions.titleIs("Your Store"));
		Assert.assertTrue(isLogoutToHome, "Wrong page is loaded");
		// Login Again
		WebElement myAccount = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@title='My Account' and @class='dropdown-toggle']")));
		myAccount.click();
		WebElement loginTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));
		loginTab.click();
		boolean isTitleOnLogin = wait.until(ExpectedConditions.titleIs("Account Login"));
		Assert.assertTrue(isTitleOnLogin, "Wrong page loaded");
		WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		username.sendKeys("nisha3@email.com");
		String retrieveLastName = username.getAttribute("value");
		Assert.assertEquals(retrieveLastName, "nishaMohandas@email.com", "Username is not correct");
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		password.sendKeys("Password@5");
		String retrievePassword = password.getAttribute("value");
		Assert.assertEquals(retrievePassword, "Password@5", "Password is not correct");
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//input[@value='Login']"))));
		boolean isContinue = loginButton.isDisplayed();
		Assert.assertTrue(isContinue, "Login button is not displayed");
		loginButton.submit();
		boolean isTitleAfterLogin = wait.until(ExpectedConditions.titleIs("My Account"));
		Assert.assertTrue(isTitleAfterLogin, "Wrong page is loaded");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
