package org.maven.nisha.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsDisplayIsEnabledIsSelected {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\ChromeDriver\\\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=product/product&path=25_28&product_id=42");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void validateText() {
		WebElement addToCart = wd.findElement(By.xpath("//button[contains(text(),'Add to Cart')]"));
		addToCart.click();
		// sleep();
		WebElement textAreaWarning = wd.findElement(By.xpath("//div[text()='Textarea required!']"));
		boolean isTextDisplayed = textAreaWarning.isDisplayed();
		Assert.assertTrue(isTextDisplayed, "Text not displayed");
	}

	@Test
	public void isEnabled() {
		WebElement fileButton = wd.findElement(By.id("button-upload222"));
		boolean button = fileButton.isEnabled();
		Assert.assertTrue(button, "Button is not enabled");
	}

	@Test
	public void isSelected() {
		WebElement radioMedium = wd.findElement(By.xpath("(//input[@name='option[218]'])[2]"));
		radioMedium.click();
		boolean isRadioMedium = radioMedium.isSelected();
		Assert.assertTrue(isRadioMedium, "Radio Button Medium is not Selected");
		// Check box
		WebElement checkBoxSecond = wd.findElement(By.xpath("(//input[@name='option[223][]'])[2]"));
		checkBoxSecond.click();
		boolean isCheckBoxSecond = checkBoxSecond.isSelected();
		Assert.assertTrue(isCheckBoxSecond, "Second checkbox is not Selected");
		WebElement checkBoxThird = wd.findElement(By.xpath("(//input[@name='option[223][]'])[3]"));
		checkBoxThird.click();
		boolean isCheckBoxThird = checkBoxSecond.isSelected();
		Assert.assertTrue(isCheckBoxThird, "Third checkbox is not Selected");
	}

	@Test
	public void validateDropDown() {
		Select sl = new Select(wd.findElement(By.cssSelector("#input-option217")));
		sl.selectByValue("3");
		Assert.assertEquals(sl.getFirstSelectedOption().getText(), "Blue (+$3.60)", "Selection is not as expected");
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
