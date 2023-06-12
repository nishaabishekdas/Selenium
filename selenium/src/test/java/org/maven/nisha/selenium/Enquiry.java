package org.maven.nisha.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Enquiry {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\ChromeDriver\\\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void validateEnquiryBanner() {
		WebElement yourNameText = wd.findElement(By.cssSelector("#input-name"));
		yourNameText.sendKeys("Nisha Mohandas");
		WebElement emailAddress = wd.findElement(By.cssSelector("#input-email"));
		emailAddress.sendKeys("nisha@email.com");
		WebElement enquiryTextArea = wd.findElement(By.cssSelector("#input-enquiry"));
		enquiryTextArea.sendKeys("Do you have delivery on address 27 Queen street,Toronto,ON?");
		WebElement submitButton = wd.findElement(By.xpath("//input[@class='btn btn-primary' and @type='submit']"));
		submitButton.submit();
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=information/contact/success");
		Assert.assertEquals(wd.getTitle(), "Contact Us", "Page Loaded is not correct");
		WebElement displayText = wd.findElement(By.xpath("//div[@id='content']//p"));
		String textReturned = displayText.getText();
		Assert.assertEquals(textReturned, "Your enquiry has been successfully sent to the store owner!",
				"Text displayed is not as expected");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
