package com.naveenautomationlabs.NaveenAutomationFramework.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomationlabs.NaveenAutomationFramework.base.TestBase;

public class Utils extends TestBase {
	public static void screenshots(String testName) {
		String timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./failedTestScreenShots\\" + "_" + testName + "_" + timestamp+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
