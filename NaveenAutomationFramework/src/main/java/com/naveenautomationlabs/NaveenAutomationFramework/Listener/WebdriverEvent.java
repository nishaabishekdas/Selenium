package com.naveenautomationlabs.NaveenAutomationFramework.Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class WebdriverEvent extends TestBase implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		logger.info("Accepting Alert");

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		logger.info("Alert accepted");

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		logger.info("Alert Dismissed");

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		logger.info("Dismissing Alert");

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Navigating to URL: " + url);

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("Navigated to URL: " + url);

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		logger.info("Navigating from  " + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		logger.info("Navigated to  " + driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		logger.info("Page Refresh " + driver.getCurrentUrl());

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Finding Element: " + by);

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Found Element Successfully: " + by);

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicked ON: " + element);

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		logger.info("Switched Window: " + windowName);

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		logger.info(throwable.fillInStackTrace());

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		logger.info("Going to capture Screenshot of test case");

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		logger.info("Screenshot Captured...");

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		logger.info("Got Text: " + element.getText());

	}

}
