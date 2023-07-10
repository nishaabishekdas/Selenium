package com.naveenautomationlabs.NaveenAutomationFramework.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class RetryFailedTestCases extends TestBase implements IRetryAnalyzer {
	int cntMax = 2;
	int cnt = 1;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed Test Case " + result.getMethod().getMethodName() + "attempt " + cnt);
		if (cnt < cntMax) {
			cnt++;
			return true;
		}
		return false;
	}
}
