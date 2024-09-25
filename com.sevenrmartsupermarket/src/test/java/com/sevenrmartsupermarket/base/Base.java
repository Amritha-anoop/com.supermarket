package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	ScreenShotCapture screenshotcapture = new ScreenShotCapture();

	// declare object of Properties class
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream inputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Initializing browser **/
	// if we have opera browser we can specify the same
	public void initialize(String browser, String url) {

		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

	}
	
   /**For cross browser execution**/
	@Parameters("browser")
	@BeforeMethod(enabled = false)
	public void launchBrowser(String browser) {

		String url = properties.getProperty("url");
		initialize(browser, url);
	}
	
	
	/**Individual Test case Execution**/
	@BeforeMethod(enabled= true,alwaysRun = true)
	public void launchBrowser() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialize(browser, url);
	}


	@AfterMethod(alwaysRun = true)
	public void terminateBrowser(ITestResult itestresult) {

		if (itestresult.getStatus() == ITestResult.FAILURE) {
			screenshotcapture.takeScreenShot(driver, itestresult.getName());
		}

		// driver.quit();
	}

}
