package com.naveenautomationlabs.NaveenAutomationFramework.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomationlabs.NaveenAutomationFramework.Utils.Utils;
import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class CustomScreenShot extends TestBase implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " Started execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " Executed Successfully*********");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " got failed###################. Check Screenshot in FailedTestScreenShot Folder");
		Utils.screenshots(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " got skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
