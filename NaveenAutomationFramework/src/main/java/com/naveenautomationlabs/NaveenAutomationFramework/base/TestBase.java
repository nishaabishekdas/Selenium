package com.naveenautomationlabs.NaveenAutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.NaveenAutomationFramework.Listener.WebdriverEvent;
import com.naveenautomationlabs.NaveenAutomationFramework.Utils.Browser;
import com.naveenautomationlabs.NaveenAutomationFramework.Utils.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	private FileInputStream file;
	private Properties prop;
	public static WebDriverWait wait;
	public static Logger logger;
	private WebdriverEvent event;
	private EventFiringWebDriver fireWebDriver;
	private Browser BROWSER = Browser.CHROME;
	private Environment ENV = Environment.PROD;

	public TestBase() {
		prop = new Properties();
		try {
			file = new FileInputStream(
					"./src\\main\\java\\com\\naveenautomationlabs\\NaveenAutomationFramework\\config\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void initialisation() {
		//String browserName = System.getenv("BrowserName");
		switch (BROWSER.getValue()) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			System.out.println("Wrong Browser");
			break;
		}
		fireWebDriver = new EventFiringWebDriver(wd);
		event = new WebdriverEvent();
		fireWebDriver.register(event);
		wd = fireWebDriver;

		wd.get(ENV.getUrl());
		wd.manage().window().maximize();
		wait = new WebDriverWait(wd, Long.parseLong(prop.getProperty("Seconds")));
	}

	public void tearDown() {
		wd.quit();
	}

}
