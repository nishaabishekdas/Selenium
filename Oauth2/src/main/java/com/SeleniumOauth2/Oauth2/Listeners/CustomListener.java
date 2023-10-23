package com.SeleniumOauth2.Oauth2.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SeleniumOauth2.Oauth2.Base.TestBase;
import com.SeleniumOauth2.Oauth2.Utilities.Utils;

public class CustomListener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test execution started for " + result.getMethod().getMethodName() +" *********************************");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test " + result.getMethod().getMethodName() + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test " + result.getMethod().getMethodName() + " Failed"+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Utils.takeScreenShot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test " + result.getMethod().getMethodName() + " Skipped"+" ###################################");
	}

}
