package com.naveenautomationlab.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	public static WebDriverWait wait;
	FileInputStream configFile;
	Properties prop;

	public TestBase() {
		prop=new Properties();
		try {
			configFile = new FileInputStream(
					"C:\\Users\\nishm\\eclipse-workspace\\AutomationFramework\\src\\main\\java\\com\\naveenautomationlab\\AutomationFramework\\config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browser = prop.getProperty("browser");
		switch (browser) {
		case "chrome":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "firefox":
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			System.out.println("Not a valid browser");
			break;
		}
		wd.get(prop.getProperty("URL"));
		wait = new WebDriverWait(wd, Long.parseLong(prop.getProperty("Explicit_Wait")));
		wd.manage().window().maximize();
	}
	
	public static void clearInputField(WebElement inputField) {
		inputField.clear();
	}

	public void tearDown() {
		wd.quit();
	}

}
