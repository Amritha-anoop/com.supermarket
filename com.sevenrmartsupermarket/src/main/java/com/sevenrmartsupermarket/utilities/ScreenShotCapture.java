package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenShotCapture {

	/** interface to capture ss **/
	TakesScreenshot takescreenshot;

	public void takeScreenShot(WebDriver driver, String imageName) {
		try {

			takescreenshot = (TakesScreenshot) driver;
			/** captures screenshot **/
			File screenShot = takescreenshot.getScreenshotAs(OutputType.FILE);

			/** System date and time **/

			String timeStamp = GeneralUtility.getTimeStamp();

			/** path of ssimage **/
			String path = Constants.Screenshot_FILE_PATH + imageName + "_" + timeStamp + ".png";

			File destination = new File(path);
			/** move image to folder **/

			FileHandler.copy(screenShot, destination);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
