package org.maven.nisha.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumIntroduction {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void loginFunctionTest() {
		WebElement emailId = wd.findElement(By.id("input-email"));
		emailId.sendKeys("tony@email.com");
		WebElement password = wd.findElement(By.cssSelector("input[name='password']"));
		password.sendKeys("Password1");
		WebElement login = wd.findElement(By.cssSelector("input[value='Login']"));
		login.click();
		String currentPage = wd.getTitle();
		Assert.assertEquals("My Account", currentPage, "Login is not successful!!");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

}
