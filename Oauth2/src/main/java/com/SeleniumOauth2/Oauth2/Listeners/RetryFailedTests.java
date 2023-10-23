package com.SeleniumOauth2.Oauth2.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {

	int maxCounter = 2;
	int cnt = 1;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test !!!!!!" + result.getMethod().getMethodName() + " for " + cnt + " times");
		if (cnt < maxCounter) {
			cnt++;
			return true;
		}
		return false;
	}

}
