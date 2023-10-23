package com.SeleniumOauth2.Oauth2.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.SeleniumOauth2.Oauth2.Base.TestBase;
public class Utils extends TestBase {

	public static void takeScreenShot(String testName) {
		// Time Stamp
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

		// Take a screen shot
		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		// Save Screen Shot
		try {
			FileUtils.copyFile(screenshotFile,
					new File("./FailedTestsScreenShots\\" + "_" + testName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
