package com.SeleniumOauth2.Oauth2.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.SeleniumOauth2.Oauth2.Listeners.WebdriverEvents;
import com.SeleniumOauth2.Oauth2.Utilities.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	public static WebDriverWait wait;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebdriverEvents events;
	private EventFiringWebDriver eDriver;
	private Browsers BROWSER = Browsers.EDGE;

	// constructor to read configuration file and load it as key value pair
	public TestBase() {
		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					"./src\\main\\java\\com\\SeleniumOauth2\\Oauth2\\Config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
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

	public void intialisation() {
		switch (BROWSER.getBrowserName()) {
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
			System.out.println("Not a valid browser name");
			break;
		}

		eDriver = new EventFiringWebDriver(wd);
		events = new WebdriverEvents();
		eDriver.register(events);
		wd = eDriver;
		wd.get("https://developer.spotify.com/");
		wait=new WebDriverWait(wd, 10);
		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();
	}

	// Quit driver instances
	public void tearDown() {
		wd.quit();
	}
}
