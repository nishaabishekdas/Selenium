package org.maven.nisha.selenium;

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

public class EnquiryBannerWithExplicitWait {
	WebDriver wd;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\ChromeDriver\\\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
		wd.manage().window().maximize();
		wait = new WebDriverWait(wd, 10);
	}

	@Test
	public void validateEnquiryBanner() {
		WebElement yourNameText = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-name")));
		yourNameText.sendKeys("Nisha Mohandas");
		WebElement emailAddress = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		emailAddress.sendKeys("nisha@email.com");
		WebElement enquiryTextArea = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-enquiry")));
		enquiryTextArea.sendKeys("Do you have delivery on address 27 Queen street,Toronto,ON?");
		WebElement submitButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@class='btn btn-primary' and @type='submit']")));
		submitButton.submit();
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=information/contact/success");
		Assert.assertEquals(wd.getTitle(), "Contact Us", "Page Loaded is not correct");
		boolean displayText = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='content']//p"),
				"Your enquiry has been successfully sent to the store owner!"));
		Assert.assertTrue(displayText, "Text displayed is not as expected");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
