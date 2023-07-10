package com.naveenautomationlabs.NaveenAutomationFramework.Listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		String timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		String repName = "Report_" + timestamp + ".html";
		htmlReporter = new ExtentHtmlReporter("./Reports/" + repName);

		htmlReporter.config().setDocumentTitle("NaveenAutomation");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat(timestamp);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Name of Tester", "Nisha");
		extent.setSystemInfo("Testing Environment", "Production");
		extent.setSystemInfo("Test Website", "Naveen Automation Lab");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
